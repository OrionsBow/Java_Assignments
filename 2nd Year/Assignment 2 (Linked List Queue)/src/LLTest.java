import javax.swing.JOptionPane;

// Chris D'Arcy, Feb 2018; Comparison Test of Array Queue vs Linked List Queue

public class LLTest 
{
	public static void main(String[] args)
	{
		LLQueue list = new LLQueue();
		CircularArrayQueue q = new CircularArrayQueue();
		
		//Test for integers Array Queue
		JOptionPane.showMessageDialog(null, "Array Queue integer test");
		for(int i=0; i<4; i++) 
			q.enqueue(i);
		JOptionPane.showMessageDialog(null, "Dequeuing...");
		while(!q.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		}
		
		//Test for integers Linked List Queue
		JOptionPane.showMessageDialog(null, "Linked list integer test");
		for(int i=0; i<4; i++) 
			list.enqueue(i);
		JOptionPane.showMessageDialog(null, "Dequeuing...");
		while(!list.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Object dequeued: " + list.dequeue());
		}
		
		//Test for Strings Array Queue (and front() method + null test)
		JOptionPane.showMessageDialog(null, "Array Queue string test");
		JOptionPane.showMessageDialog(null, "Front" + q.front());
		q.enqueue(null);
		q.enqueue("I");
		q.enqueue("love");
		q.enqueue("Java");
		q.enqueue("Programming");
		
		JOptionPane.showMessageDialog(null, "Object at front: " + q.front());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		JOptionPane.showMessageDialog(null, "Object at front: " + q.front());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		q.enqueue("is");
		q.enqueue("cool");
		JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
	
		//Test for Strings Linked List (and front() method + null test)
		JOptionPane.showMessageDialog(null, "Linked list string test");
		JOptionPane.showMessageDialog(null, list.front());
		list.enqueue(null);
		list.enqueue("I");
		list.enqueue("love");
		list.enqueue("Java");
		list.enqueue("Programming");
		
		JOptionPane.showMessageDialog(null, "Object at front: " + list.front());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + list.dequeue());
		JOptionPane.showMessageDialog(null, "Object at front: " + list.front());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + list.dequeue());
		list.enqueue("is");
		list.enqueue("cool");
		JOptionPane.showMessageDialog(null, "Object dequeued: " + list.dequeue());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + list.dequeue());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + list.dequeue());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + list.dequeue());
	
		//Test of isEmpty() Array Queue
		JOptionPane.showMessageDialog(null, "Array Queue isEmpty() test");
		JOptionPane.showMessageDialog(null, "Is Array Queue empty ? " + q.isEmpty());
		q.enqueue("I");
		JOptionPane.showMessageDialog(null, "Is Array Queue empty ? " + q.isEmpty());
		q.enqueue("love");
		q.enqueue("Java");
		q.enqueue("Programming");
		
		JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		JOptionPane.showMessageDialog(null, "Is Array Queue empty ? " + q.isEmpty());
		
		//Test of isEmpty() Linked List
		JOptionPane.showMessageDialog(null, "Linked list isEmpty() test");
		JOptionPane.showMessageDialog(null, "Is Array Queue empty ? " + list.isEmpty());
		list.enqueue("I");
		JOptionPane.showMessageDialog(null, "Is Array Queue empty ? " + list.isEmpty());
		list.enqueue("love");
		list.enqueue("Java");
		list.enqueue("Programming");
		
		JOptionPane.showMessageDialog(null, "Object dequeued: " + list.dequeue());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + list.dequeue());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + list.dequeue());
		JOptionPane.showMessageDialog(null, "Object dequeued: " + list.dequeue());
		JOptionPane.showMessageDialog(null, "Is Array Queue empty ? " + list.isEmpty());
	}
}