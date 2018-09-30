
public interface LinkedList {
	long size(); //return size of list
	boolean isEmpty(); //True if list is empty
	Object getCurr(); //Returns element at current pos
	boolean gotoHead(); //Sets curr pos to head; true if worked
	boolean gotoNext(); //sets curr pos 
	void insertNext();
	
	}
