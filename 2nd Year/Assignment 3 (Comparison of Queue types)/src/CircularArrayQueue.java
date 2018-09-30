import javax.swing.JOptionPane;
//Chris D'Arcy, Feb 2018, Circular Array Queue
//Altered Code = AC
public class CircularArrayQueue implements Queue {
	 protected Object Q[];				// array used to implement the queue 
	 protected int capacity; 			// The actual capacity of the queue array
	 protected int rear, front = 0;			// index for the rear and front of the queue
	 public static final int CAPACITY = 1000;	// default array capacity
	   
	 public CircularArrayQueue() {
		   // default constructor: creates queue with default capacity
		   this(CAPACITY);
	 }

	 public CircularArrayQueue(int cap) {
		  // this constructor allows you to specify capacity
		  capacity = (cap > 0) ? cap : CAPACITY;
		  Q = new Object[capacity]; 
	 } 
	 
	 public void enqueue(Object n) //ALTERED CODE.
	 {
		 if (isFull()) {
			 JOptionPane.showMessageDialog(null, "Cannot enqueue object; queue is full."); //If full, display error and do not enqueue
		 }
		 else if(n == null)
			 JOptionPane.showMessageDialog(null, "Error: Object cannot be null.");//AC.If object is null, display error and do not enqueue
		 else {
			 Q[rear] = n; //Adds enqueued element to rear
			 rear = (rear+1) % capacity; //AC. Ensures array is enqueued as a circular queue. 
		 }
	}
	 	 
	 public Object dequeue() //ALTERED CODE. 
	 {
		 if (isEmpty())
			 return null;
		 
		 else { 
			 Object toReturn = Q[front]; //Takes front object
			 Q[front] = null; //AC. Sets that array space to null
			 front = (front+1) % capacity; //AC. Increments the front pointer so it behaves as a circular queue. Sets the front to the one behind the previous front
		 	 return toReturn; //Returns the former front object 
		 }
	 }
	 
	 public boolean isEmpty() { //ALTERED CODE
		 return (rear == front && freeSpace()) ? true : false; //Checks if the front pointer is equal to the rear pointer and if there is any free space
	 }

	 public boolean isFull() {//ALTERED CODE
	        return(rear == front && !freeSpace()) ? true: false;//Checks if the front pointer is equal to the rear pointer and if there is no free space
	 }
	 		 
	 public boolean freeSpace() {//ALTERED CODE
		 int j = 0;
		 for(int i=0; i< capacity; i++) { //Counts how many null objects (ie free space) is in the array
			 if(Q[i] == null)
				 j++;
		 }
		 return(j != 0) ? true: false; //If there is any free space, return true. Else false
	 }
	 		 
	 public Object front() { //AC. returns element in front of queue (head). Returns error if empty
			Object tmp = " Error: Empty"; 
			return(isEmpty()) ? tmp: Q[front];
		}
}
