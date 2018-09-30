import javax.swing.JOptionPane;
//Chris D'Arcy, Feb 2018, Linked List Queue
//Altered Code = AC
public class LLQueue implements Queue
{
  protected Node head;	 // head node of the list
  protected Node tail;	 // last position in the list
  protected Node curr;	 // node referencing current position in the list  
  protected long size;	 // number of nodes in the list
  
  /* Default constructor that creates an empty list. */
  public LLQueue() {
    curr = tail = head = null;
    size = 0;
  }

  public long size() { 
	  return size;
  }
 
  public Object getCurr() {
	  if (curr == null)   // Verify that there is a current node
		  return null;
	  return curr.getElement();	
  }
  
  public boolean gotoHead() {
	  if (isEmpty()) 
		  return false;
	  curr = head;
	  return true;
  }

  public boolean gotoNext() {
	  if (curr == tail)
		  return false;
	  curr = curr.getNext();
	  return true;
  }

  public boolean gotoTail() {
	  if (isEmpty()) 
		  return false;
	  curr = tail;
	  return true;
  }

  public void insertNext(Object el) {
	  if (head == null) { 
         insertHead(el);  // If haven't inserted a head, do so now (for convenience)
   	     return;
	  }
	  
	  Node newnode = new Node(el, curr.getNext());  // create new node with its next node equal to curr's next node	  
	  curr.setNext(newnode); // update the next node of the current node to point to the new one
	  size++;

	  // have inserted a new item at the tail, so update the tail reference to the new node
	  if (tail == curr) 
		  tail = newnode;

	  // make this new node the current one
	  curr = newnode;	  
  }
  
  public void deleteNext() {
	  if (curr == null || curr.getNext() == null) return; // no next: list empty or already at end

	  // update the tail if the node we are deleting is the tail
	  if (tail == curr.getNext()) 
		  tail = curr;	  

	  curr.setNext(curr.getNext().getNext());  // set curr's next equal to the next node's next
	  // Note: Garbage collector will automatically clear up the node no longer referenced
	  size--;
	  
  }

  public void insertHead(Object el) {
	  Node oldhead = head;
	  head = new Node(el, oldhead);
	  size++;	  
	  curr = head;
	  if (size == 1 /* oldhead == null */) // if this is the first node, it is both head and tail
		  tail = head;
}
  
  public void deleteHead() {
	  if (head == null) return; // list already empty
	  
	  head = head.getNext();
	  size--;
	  curr = head;
	  if (size <= 0) // list has 0 or 1 items, sets tail to head (ie tail to null)
		  tail = head;
	  
  }

@Override
public void enqueue(Object n) { //AC
	if(n == null) { //Stops a null object being enqueued 
		JOptionPane.showMessageDialog(null, "Error: Cannot enqueue null object");
		return;
	}
	gotoTail(); //goes to the end of the list
	insertNext(n); //Puts in a new node containing the element
}

@Override
public Object dequeue() { //AC
	if(gotoHead()) { //checks if there is a head and if there is, puts current pointer at head
		Object tmp = getCurr(); //Saves the element in the head node.
		deleteHead();//Deletes head node
		return tmp;
	}
	Object tmp = new Object(); //If it is empty, makes temp object an error
	tmp = "No head, list is empty";
	return tmp; //returns temp object
}

@Override
public boolean isFull() { //AC. Linked list can never be full
	return false;
}

@Override
public Object front() { //AC. returns element in front of queue (head). Returns error if empty
	Object tmp = " Error: Empty"; 
	return(isEmpty()) ? tmp: head.getElement();
}


@Override
public boolean isEmpty() { //AC. If there is no head, return true (ie empty)
	  return (head == null);
}
}