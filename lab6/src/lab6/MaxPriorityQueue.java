package lab6;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 6
 * 
 * @author Olena Khomenko
 * 
 *         Max-priority queue order elements in a FIFO
 *         (first-in-first-out)policy. <br>
 *         The head of the this queue is the largest element with respect to the
 *         specified ordering. It would be removed by a call to removeMin().
 *         Every Queue implementation must specify its ordering properties
 * 
 */

public interface MaxPriorityQueue {
	/**
	 * insert new element into max-priority queue
	 * 
	 * @param s
	 *            the Student's object to insert
	 */
	public void insert(Student s);

	/**
	 * test the whether max-priority queue is empty
	 * 
	 * @return true if priority queue is empty
	 */
	public boolean isEmpty();

	/**
	 * remove from ax-priority queue and return the element with largest
	 * priority
	 * 
	 * @return the element with largest priority or null if queue is empty
	 * 
	 */
	public Student removeMax();

	/**
	 * Retrieves, but does not remove, the the element with largest priority of
	 * this queue
	 * 
	 * @return the element with biggest priority, or null if this queue is empty
	 */
	public Student max();

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size();

}
