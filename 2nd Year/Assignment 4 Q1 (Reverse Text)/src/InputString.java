
public class InputString {
	public static void main(String[] args){
		ArrayStack stack = new ArrayStack(100);
		
		String userEntry = "I am the best in the world @ 65000 things";
		System.out.println(stack.reverse(userEntry));
	}
}
