package lab3_1;

public class lab3_1 {
	public static void main (String[] args) {
	    	ArrayQueue queue = new ArrayQueue();
	    	queue.enqueue("Hello");
	    	queue.enqueue("It's me");
	    	queue.enqueue("I was wondering");
	    	queue.enqueue("if after all these years");
	    	queue.enqueue("you'd like to meet");
	    	queue.enqueue("To go over everything");
	    	queue.enqueue("They say that time's supposed to heal ya");
	    	queue.enqueue("But I ain't done much healing");
	    	
	    	System.out.println ("The starting queue:");
	    	System.out.println ("");
	    	queue.printQueue();
	    	queue.printSizes();
	    	
	    	
	    	
	    	for (int i = 0; i < 2; i++)
	    	{
	    		queue.dequeue();
	    	}
	    	
	    	System.out.println ("The queue after deleting 2 strings:");
	    	System.out.println ("");
	    	queue.printQueue();
	    	queue.printSizes();
	    	
	    	
	    	queue.enqueue("Hello, can you hear me?");
	    	queue.enqueue("I'm in California dreaming about who we used to be");
	    	queue.enqueue("When we were younger and free");
	    	queue.enqueue("I've forgotten how it felt");
	    	queue.enqueue("before the world fell at our feet");
	    	
	    	System.out.println ("The queue after adding 5 strings (which in summary exceeds array size):");
	    	System.out.println ("");
	    	queue.printQueue();
	    	queue.printSizes();
	    	
	    	
	    	int queueSize = queue.size();
	    	for (int i = 0; i < queueSize; i++)
	    	{
	    		queue.dequeue();
	    	}
	    	
	    	System.out.println ("The queue after deleting ALL strings:");
	    	System.out.println ("");
	    	queue.printQueue();
	    	queue.printSizes();
	    	
	    	System.out.println ("Trying to delete an element from empty queue:\n");
	    	queue.dequeue();
	    	System.out.println ("");
	    	queue.printQueue();
	    	queue.printSizes();
	    	
	    	/*queueSize  = 148; // random test size value
	    	for (int i = 0; i < queueSize; i++)
	    		queue.enqueue("A" + i + 'i');
	        
	    	System.out.println ("Demonstration of resizing of the array:");
	    	System.out.println ("");
	    	queue.printQueue();
	    	queue.printSizes();*/
	    }

}
