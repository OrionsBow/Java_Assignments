/*
 * Chris Darcy, Feb 2018: Test the ArrayQueue
 */

import javax.swing.JOptionPane;


public class QueueTest {
	public static void main(String[] args){
		
		Queue q = new CircularArrayQueue(4); 

		//Tests integers
		JOptionPane.showMessageDialog(null, "Test for integers only");
		for(int i=0; i<4; i++) 
			q.enqueue(i);
		q.enqueue(5);
		JOptionPane.showMessageDialog(null, "Dequeuing...");
		while(!q.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		}
		
		//Tests Strings
		JOptionPane.showMessageDialog(null, "Test for Strings only");
		JOptionPane.showMessageDialog(null, "Queue empty ? " + q.isEmpty());
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");
		JOptionPane.showMessageDialog(null, "Front of queue: " + q.front());
		q.dequeue();
		q.enqueue(null);
		JOptionPane.showMessageDialog(null, "Queue full ? " + q.isFull());
		q.enqueue("E");
		JOptionPane.showMessageDialog(null, "Dequeuing...");
		while(!q.isEmpty())
				JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		
		//Tests Circular Queue for multiple loops
		JOptionPane.showMessageDialog(null, "Test for multiple loops");
		for(int i=0; i<12; i++) { 
			if(q.isFull())
				q.dequeue();
			q.enqueue(i);
		}
		JOptionPane.showMessageDialog(null, "Dequeuing...");
		while(!q.isEmpty())
				JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		
		//Tests for integers and Strings
		JOptionPane.showMessageDialog(null, "Test for integers and Strings");
		for(int i=0; i<2; i++) 
			q.enqueue(i);
		q.enqueue("Banana");
		q.enqueue("Apple");
		JOptionPane.showMessageDialog(null, "Dequeuing...");
		while(!q.isEmpty())
				JOptionPane.showMessageDialog(null, "Object dequeued: " + q.dequeue());
		
		System.exit(0);
	}
}