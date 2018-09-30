import javax.swing.JOptionPane;
import java.util.Comparator;

public class SortingTest{

	public static int[] quickCount = new int[2];
	public static float shellDiff,insertionDiff,quickDiff = 0;
	
	public static String[] objectArray (int size) {
		String[] arr = new String[size];
		System.out.println(size);
		
		for(int j=0;j<size;j++)
			arr[j] = (String)(5*Math.random() + "b");	
		
	    return arr;
	}
	
	public static void quickSort (Object[] arr, Comparator c) {
	    if (arr.length < 2) return; // the array is already sorted in this case
	    quickSortStep(arr, c, 0, arr.length-1); // call the recursive sort method
	}
		
	private static void quickSortStep (Object[] s, Comparator c,
	                              int leftBound, int rightBound ) 
	{
		
	   if (leftBound >= rightBound) return; // the indices have crossed
	   Object temp;  // temp object used for swapping
	   // Set the pivot to be the last element
	   Object pivotValue = s[rightBound];
	    
	   // Now partition the array 
	   int upIndex = leftBound;     // will scan rightward, 'up' the array
	   int downIndex = rightBound-1; // will scan leftward, 'down' the array
	   while (upIndex <= downIndex) 
	   { 
	       // scan right until larger than the pivot
	       while ( (upIndex <= downIndex) && (c.compare(s[upIndex], pivotValue)<=0) ) {
	    	   upIndex++; 
	    	   quickCount[1]++;
	       }
	       // scan leftward to find an element smaller than the pivot
	       while ( (downIndex >= upIndex) && (c.compare(s[downIndex], pivotValue)>=0)) {
	    	   downIndex--;
	    	   quickCount[1]++;
	       }
	       if (upIndex < downIndex) { // both elements were found
	          temp = s[downIndex]; 
		      s[downIndex] = s[upIndex]; // swap these elements
		      quickCount[0]++;
		      s[upIndex] = temp;
	       }
	   } // the loop continues until the indices cross
	    
	   int pivotIndex = upIndex;
	   temp = s[rightBound]; // swap pivot with the element at upIndex
	   s[rightBound] = s[pivotIndex]; 
	   quickCount[0]++;
	   s[pivotIndex] = temp; 
	 
	   // the pivot is now at upIndex, so recursively quicksort each side
	   quickSortStep(s, c, leftBound, pivotIndex-1);
	   quickSortStep(s, c, pivotIndex+1, rightBound);
	   
	   //System.out.println(quickCount[0]);
	}

	public static int[] shellSort (Comparable[] arr)   
	{
		int last = arr.length-1;
		int[] count = {0,0};
		
		// Begin with gap = half length of array; reduce by half each time.
		for (int gap = arr.length/2; gap > 0; gap = gap/2)
		{
			if (gap % 2 == 0) {
				gap++; // if gap is even, move to next largest odd number
			}
			
			// Apply Insertion Sort to the subarrays defined by the gap distance
			for (int first = 0; first < gap; first++) {
				//System.out.printf("Before"+count[1]);
				int[] temp = insertionSort (arr, first, last, gap);
				count[0] = count[0] + temp[0];
				count[1] = count[1] + temp[1];
				//System.out.println("After"+count[2]);
			}
		} // end for
		return count;
	} // end shellSort
	
	public static int[] shellSortInefficient (Comparable[] arr)   
	{
		int last = arr.length-1;
		int[] count = {0,0};
		
		// Begin with gap = half length of array; reduce by half each time.
		for (int gap = arr.length/2; gap > 0; gap = gap/2)
		{			
			// Apply Insertion Sort to the subarrays defined by the gap distance
			for (int first = 0; first < gap; first++) {
				//System.out.printf("Before"+count[1]);
				int[] temp = insertionSort (arr, first, last, gap);
				count[0] = count[0] + temp[0];
				count[1] = count[1] + temp[1];
				//System.out.println("After"+count[2]);
			}
		} // end for
		return count;
	} // end shellSort

	private static int[] insertionSort(Comparable[] a, int first, int last, int gap)                                             
	{
		int index;     // general index for keeping track of a position in array
		int toSort;  // stores the index of an out-of-place element when sorting.
		int move = 0;
		int compare = 0;
		
		// NOTE: Instead of considering a full array of adjacent elements, we are considering 
		// a sub-list of elements from 'first' to 'last, separated by 'gap'. All others are ignored.
		//
		// Work forward through the list, starting at 2nd element, 
		// and sort each element relative to the ones before it.
		
		for (toSort = first+gap; toSort <= last; toSort += gap)
		{
			Comparable toSortElement = a[toSort];

			// Go back through the list to see how far back (if at all)
			// this element should be moved.
			// Note: we assume all elements before this are sorted relative to each other.
			boolean moveMade = false;
			index = toSort - gap;
			compare++;
			while ((index >= first) && (toSortElement.compareTo(a[index]) < 0)) //1 comp
			{
				// Shuffle elements over to the right, put firstUnsorted before them 
				a[index+gap] = a[index]; //1move
				move++;
				index = index - gap;
				moveMade = true;
			} 
			if (moveMade) {
				//System.out.println("Inserting " + toSortElement + " at pos " + (index+1));
				a[index+gap] = toSortElement; //1 move
				move++;
			}
		} 
		int[] counter = {move, compare};
		return counter;
	} 

	public static int[] insertionSort(Comparable arr[])
	{
		return(insertionSort(arr, 0, arr.length-1, 1));
	}

	public static void main(String[] args)
	{
		int[] count = new int[2];
		int[] count2 = new int[2];
		int[] count3 = new int[2];
		
		
		float shellStart,shellEnd,insertionStart,insertionEnd,quickStart,quickEnd, shInStart,shInEnd = 0;
		
		int i = 0;
		
		for(i=0; i<1; i++) {
			String[] arr = objectArray((int)(50000 * Math.random()));
			
			String copy[] = arr.clone();
			String copy2[] = arr.clone();
			String copy3[] = arr.clone();
			String copy4[] = arr.clone();
			
			//Array Length Declaration
			//JOptionPane.showMessageDialog(null, "Array length is "+ copy2.length);
			
			//ShellSort
			//JOptionPane.showMessageDialog(null, "Array before sorting with Shell Sort:\n" + array2String(copy));
			shellStart = System.nanoTime();
			int tmp[]= shellSort(copy);
			shellEnd = System.nanoTime();
			shellDiff = shellDiff + (shellEnd - shellStart);
			
			count[0] = count[0] + tmp[0];
			count[1] = count[1] + tmp[1];
			//JOptionPane.showMessageDialog(null,  "After Shell Sort" + array2String(copy));
			//System.out.printf("Shell sort has a move of " + count[0] + " and a compare of " + count[1] + "\n"); 
	
			//InsertionSort
			//JOptionPane.showMessageDialog(null, "Array before sorting with InsertionSort\n" + array2String(copy2));
			insertionStart = System.nanoTime();
			int tmp2[] = insertionSort(copy2);
			insertionEnd = System.nanoTime();
			insertionDiff = insertionDiff + (insertionEnd - insertionStart);
			
			count2[0] = count2[0] + tmp2[0];
			count2[1] = count2[1] + tmp2[1];
			//JOptionPane.showMessageDialog(null, "After Sorting with InsertionSort:\n " + array2String(copy2));
			//System.out.println("Insertion sort has a move of " + count2[0] + " and a compare of " + count2[1] + "\n");
			
			//QuickSort
			//JOptionPane.showMessageDialog(null, "Array before sorting with Quick Sort:\n" + array2String(copy3));	
			quickStart = System.nanoTime();
			quickSort(copy3, new StringComparator());
			quickEnd = System.nanoTime();
			quickDiff = quickDiff + (quickEnd - quickStart);
			
			count3[0] = count3[0] + quickCount[0];
			count3[1] = count3[1] + quickCount[1];
			//JOptionPane.showMessageDialog(null, "Array after sorting with Quick Sort:\n" + array2String(copy3));		
			//System.out.println("Quick sort has a move of " + count3[0] + " and a compare of " + count3[1] + "\n");
			
			shInStart = System.nanoTime();
			shellSortInefficient(copy4);
			shInEnd = System.nanoTime();
			System.out.println(shInEnd - shInStart);
			
		}
		System.out.println("Shell sort has an average move of " + count[0]/i + " and an average compare of " + count[1]/i  + " (Out of " + i +")"); 
		System.out.println("Insertion sort has an average move of " + count2[0]/i + " and an average compare of " + count2[1]/i  + " (Out of " + i +")");
		System.out.println("Quick sort has an average move of " + count3[0]/i + " and an average compare of " + count3[1]/i  + " (Out of " + i +")");
		
		System.out.println("Shell sort has an average time of " + shellDiff/i + "us");
		System.out.println("Insertion sort has an average time of " + insertionDiff/i + "us");
		System.out.println("Quick sort has an average time of " + quickDiff/i + "us");
	}

	private static String array2String(String[] a)
	{
		String text="[";
		for (int i=0; i<a.length; i++) {
			text += a[i];
			if (i<a.length-1)
				text += " ";
		}
		text += "]";
		return text;
	}
}

class StringComparator implements Comparator
{
	public int compare(Object ob1, Object ob2)
	{
		String s1 = (String)ob1;
		String s2 = (String)ob2;
		//return s1.compareTo(s2); // use compareTo for case-sensitive comparison
		return s1.compareToIgnoreCase(s2);
	}
}

