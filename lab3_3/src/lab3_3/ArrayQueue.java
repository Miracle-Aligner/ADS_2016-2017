package lab3_3;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 3
 * 
 *         Resizable-array queue. Implements Queue interface <br>
 *         This class skeleton contains methods with TODO <br>
 *         Implement methods with TODO and write addition methods to support
 *         class functionality.
 * 
 */

public class ArrayQueue implements Queue {
	// The array in which the elements of the queue are stored
	String[] queue;

	// The index of the element at the head of the queue
	private int head;

	// The index at which the next element would be added to the tail of the
	// queue
	private int tail;

	// The minimum capacity that we'll use for a newly created queue
	private final int defaultCapacity = 8;

	public ArrayQueue() {
		// Allocate empty array to hold the defaultCapacity number of elements.
		queue = new String [defaultCapacity];
		head = 0;
		tail = 0;
	}

	public ArrayQueue(int initialCapacity) {
		// Allocate empty array to hold the initialCapacity number of elements.
		queue = new String [initialCapacity];
		head = 0;
		tail = 0;
	}
	
    private void resize (int capacity) {
        assert capacity >= size();
        String[] temp = new String[capacity];
        for (int i = 0; i < size(); i++) 
        {
            temp[i] = queue[(head + i) % queue.length];
        }
        queue = temp;
        head = 0;
        tail  = size();
    }

	@Override
	public boolean enqueue(String e) {
        if (size() == queue.length)
        	resize(queue.length * 2);
        queue[tail++] = e;
        if (tail == queue.length)
        	tail = 0;
		return true;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String dequeue() {
		// TODO
        if (isEmpty())
        {
        	System.out.printf ("	Queue underflow.");
        	return null;
        }
        String del= queue[head];
        queue[head] = null;                            // to avoid loitering
        head++;
        if (head == queue.length) 
        	head = 0;           // wrap-around
        // shrink size of array if necessary
        if (size() > 0 && size() == queue.length / 4) 
        	resize (queue.length / 2); 
        return del;
	}

	@Override
	public String head() {
		return queue[head];
	}

	@Override
	public int size() {
		int counter = 0;
		for (int i = 0; i < queue.length; i++)
		{
			if (queue[i] != null)
				counter++;
		}
		return counter;
	}
	
	public void printQueue (){
		if (!isEmpty())
		{
			for (int i = 0; i < size(); i++)
			{
				System.out.printf ("	%d. %s\n", i, queue[(head + i) % queue.length]);
			}
		}
	}
	
	public void printSizes (){
		System.out.println ("");
		System.out.printf ("		Size of the queue: %d\n", size());
		System.out.printf ("		Size of the array: %d\n", queue.length);
		System.out.println ("");
	}
	
}
