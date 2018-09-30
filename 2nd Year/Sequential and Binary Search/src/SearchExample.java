import javax.swing.JOptionPane;

public class SearchExample 
{
	public static void main(String[] args)
	{
		// Array of sorted items
		String[] arr = {"aaa", "aba", "ccc", "fff", "hhh", "hzz", "zzz"};
		
		String target = JOptionPane.showInputDialog("Enter string to search for:");
		
		// Note that binary search requires sorted array
		int loc = binarySearch(arr, target);

		if (loc == -1) {
			JOptionPane.showMessageDialog(null, 
					"The element '" + target + "' is not in the array.");
		}
		else {
			JOptionPane.showMessageDialog(null, 
					"The element '" + target + "' is at index " + loc);
		}
	}
	
	/**
	 * Sequential search: loop through all items of array in turn.
	 * @author Michael Madden.
	 */
	public static int sequentialSearch(String[] arr, String target)
	{
		// Loop sequentially through the array, comparing each element to 
		// the target. Return its index when we get a match.
		for (int i=0; i<arr.length; i++) {
			if (arr[i].equals(target))
				return i;
		}
		// If we get to here, there was no match: return -1 to signal this.
		return -1;
	}
	
	/**
	 * Performs binary search on arr (String array) to find index of target (a String).
	 * Returns index (an int) or -1 if not found.
	 * Requires arr to be sorted according to normal string ordering.
	 * @author Michael Madden.
	 */
	public static int binarySearch(String[] arr, String target)
	{
		int low = 0;
		int high = arr.length-1;
		int guess;
		
		while(true) {
			guess = (high+low)/2;
			if (arr[guess].equals(target))
				return guess;    // found it!
			else if (high==low)
				return -1;       // cannot be found
			else if (arr[guess].compareTo(target) < 0)
				low = guess+1;   // guess too low
			else if (arr[guess].compareTo(target) > 0)
				high = guess-1;  // guess too high	
			assert(false); // should never reach this line of code
		}
	}
}