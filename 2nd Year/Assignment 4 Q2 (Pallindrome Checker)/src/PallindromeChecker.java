import java.lang.Character;
import java.lang.StringBuilder;

public class PallindromeChecker {
	public static void main(String args[]){
		int size = 100; //User input size
		
		//Check for validity of size
		if(size == 0) return;
		if(size < 0) size = size*-1;
		
		//Creates each storage type
		ArrayStack stack = new ArrayStack(size);
		CircularArrayQueue q = new CircularArrayQueue(size);
		
		//User inputed String
		StringBuilder userEntry = new StringBuilder("Rac ecar. 9%");
		
		//Removes any character from String that is not a letter
		for(int j=0;j<userEntry.length();j++) {
			if(!Character.isLetter(userEntry.charAt(j))) {
				userEntry.deleteCharAt(j);
				j--;
			}
		}
		String pallTest = userEntry.toString().toLowerCase(); //String converted to lowercase
		for(int i=0;i<pallTest.length();i++) { //Loop loads conditioned String onto both storage types
			stack.push(pallTest.substring(i, i+1));
			q.enqueue(pallTest.substring(i, i+1));
		}
		int check = 0;
		while(!stack.isEmpty()) {//Unloads characters simultaneously from each storage type and checks if they are equal
			if(!(stack.pop().equals(q.dequeue()))) { 
				System.out.println("Not a palindrome");
				check = 1;
				return;
			}    
		}
		if(check == 0)
			System.out.println("Is a palindrome");
		
}
}