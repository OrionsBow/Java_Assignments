/** QuickSort.java: 
 *  Michael Madden, NUI Galway.
 *  Based on code from Goodrich & Tamassia, “Data Structures and Algorithms in Java”
 *  With some simplifications for clarity, and test code at the end.
 */

import javax.swing.JOptionPane;

import java.awt.Component;
import java.util.Comparator;

public class QuickSort
{
      /** QuickSort method:
	  * Sorts the elements of array arr in nondecreasing order according
	  * to comparator c, using the quick-sort algorithm. Most of the work
	  * is done by the auxiliary recursive method quickSortStep.
	  **/
	static int comp;
	static int move;
	
	public void QuickSort () {
		this.comp = 0;
		this.move= 0;
		
	}
	
	public static void quickSort (Object[] arr, Comparator c) {		
	    if (arr.length < 2) return; // the array is already sorted in this case
	    quickSortStep(arr, c, 0, arr.length-1); // call the recursive sort method
	    return;
	}
	  
	/** QuickSortStep method: 
	  * Method called by QuickSort(), which sorts the elements of array s between
	  * indices leftBound and rightBound, using a recursive, in-place,
	  * implementation of the quick-sort algorithm.
	 **/
	private static void quickSortStep (Object[] s, Comparator c,
	                              int leftBound, int rightBound ) 
	{	   
	   if (leftBound >= rightBound) return; // the indices have crossed
	   Object temp;  // temp object used for swapping
	   
	   int i = (int)Math.round( (s.length-1)* Math.random()); //For random pivot
	   temp = s[i];// For random pivot
	   // Swap selected pivot to rightBound
	   //temp = s[leftBound]; //For leftBound
	   s[i] = s[rightBound];
	   s[rightBound] = temp;
	   Object pivotValue = s[rightBound];  // Assigns pivot
	    
	   // Now partition the array 
	   int upIndex = leftBound;     // will scan rightward, 'up' the array
	   int downIndex = rightBound-1; // will scan leftward, 'down' the array
	  
	   while (upIndex <= downIndex) //While they have not crossed
	   { 
	       // scan right until larger than the pivot
	       while ( (upIndex <= downIndex) && (c.compare(s[upIndex], pivotValue)<=0) ) {
	    	   comp++;
	    	   upIndex++; 
	       }
	       // scan leftward to find an element smaller than the pivot
	       while ( (downIndex >= upIndex) && (c.compare(s[downIndex], pivotValue)>=0)) {
	    	   comp++;
	    	   downIndex--;
	       }
	       if (upIndex < downIndex) { // both elements were found
	          temp = s[downIndex]; 
		      s[downIndex] = s[upIndex]; // swap these elements
		      s[upIndex] = temp;
		      move++;
	       }
	   } // the loop continues until the indices cross
	   
	   int pivotIndex = upIndex;
	   temp = s[rightBound]; // swap pivot with the element at upIndex
	   s[rightBound] = s[pivotIndex]; 
	   s[pivotIndex] = temp;
	   move++;
	   //System.out.print("up " + upIndex + " " + "down " + downIndex + "\n"); 
	   //System.out.println(array2String((String[]) s));
	 
	   // the pivot is now at upIndex, so recursively quicksort each side
	   quickSortStep(s, c, leftBound, pivotIndex-1);
	   quickSortStep(s, c, pivotIndex+1, rightBound);
	}

	public static String[] objectArray (int size) {
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
				"q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		String[] arr = new String[size];
		//System.out.println(size);
		
		for(int j=0;j<size;j++)
			arr[j] = (String)(alphabet[(int)(26*Math.random())] + Math.round(1000*Math.random()));	
		
	    return arr;
	}
	
	/** M Madden: Main method to test QuickSort */
	public static void main(String[] args)
	{
		
		for(int size = 100; size < 1700000; size = size*2) {
		//int size = 100;
			//String[] arr2 = objectArray(size); 
			//String[] arr2 = sortedArray(); //sorted array
			String[] arr2= reversedArray(size); // reverse sorted array
			
			float startTime = System.nanoTime();
			quickSort(arr2, new StringComparator());
			float finishTime = System.nanoTime();
			
			float totalTime = finishTime - startTime;
			
			System.out.print("For size " + size + ", the total time is: " + (totalTime*Math.pow(10, -9)) +"s");	
			int totalOp= move + comp;
			System.out.println("\tMove: " + move + "  Compare: " + comp + "  Number of Operations: " +totalOp);
			comp = move = 0;
		}
	}

	/** M Madden: utility method to return string representation of array of strings */
	private static String array2String(String[] a)
	{
		String text="[";
		for (int i=0; i<a.length; i++) {
			text += a[i];
			if (i<a.length-1)
				text += ",";
		}
		text += "]";
		return text;
	}


public static String[] sortedArray () {
	String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	String[] arr = new String[26];
	for(int i =0; i < 26; i++)
		arr[i] =  alphabet[i];
    return arr;
}

public static String[] reversedArray (int size) {
	String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	String[] arr = new String[26];
	for(int i =0; i < 26; i++) {
		int j = 26 - i;
		arr[i] =  alphabet[j-1];
		j--;
	}
    return arr;
}
}
/** M Madden: Comparator class for case-insensitive comaprison of strings */
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