import javax.swing.JOptionPane;

public class QueueComparison {
	
	public static void main(String[] args){	
		
	int size = 10;
	int i,j = 0;
	
	//Initialize Queues
	LLQueue l = new LLQueue();
	CircularArrayQueue c = new CircularArrayQueue(size);
	
	//Measure enqueue time for Linked List
	long llInitalE = System.nanoTime();
	for(i=0; i<size; i++)
		l.enqueue("Count it: " + i);
	long llFinalE = System.nanoTime();
	
	//Linked list calculation for total time to enqueue
	long llTotalE = llFinalE - llInitalE;
	JOptionPane.showMessageDialog(null, "Linked List Queue time taken to enqueue " + i + " Strings: " + llTotalE +"ns");
	
	//Dequeue until empty
	long llInitalD = System.nanoTime();
	while(!l.isEmpty()) {
		l.dequeue();
	}
	long llFinalD = System.nanoTime();
	
	//Linked list calculation for total time to dequeue
	long llTotalD = llFinalD - llInitalD;
	JOptionPane.showMessageDialog(null, "Linked List Queue time taken to dequeue " + i + " Strings: " + llTotalD +"ns");
	
	
	//Measure enqueue time for Circular Array Queue
	long circInitalE = System.nanoTime();
	for(j=0; j<size; j++)
		c.enqueue("Count it: " + j);
	long circFinalE = System.nanoTime();
	
	//Circular Array Queue calculation for total time
	long circTotalE = circFinalE - circInitalE;
	JOptionPane.showMessageDialog(null, "Circular Array Queue time taken to enqueue " + j + " Strings: " + circTotalE +"ns");
	
	//Dequeue until empty
	long circInitialD = System.nanoTime();
	while(!c.isEmpty())
		c.dequeue();
	long circFinalD = System.nanoTime();
		
	//Linked list calculation for total time to dequeue
	long circTotalD = circFinalD - circInitialD;
	JOptionPane.showMessageDialog(null, "Circular Array Queue time taken to dequeue " + j + " Strings: " + circTotalD +"ns");
	}
}
