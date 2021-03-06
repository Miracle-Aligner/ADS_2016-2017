package lab6.max_priority_queue;

import lab6.Heap;
import lab6.MaxPriorityQueue;
import lab6.Student;
import lab6.StudentComparator;
import lab6.array_linked_lists.StudentArrayList;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 6
 * 
 * @author Olena Khomenko
 * 
 *         An unbounded max-priority queue based on a priority heap. The
 *         elements of the max-priority queue are ordered by a
 *         StudentComparator. The head of this queue is the greatest element
 *         with respect to the specified ordering. <br>
 *         A priority queue does not permit null elements. <br>
 *         Keeps elements of type Student.<br>
 */

public class HeapPriorityQueue implements MaxPriorityQueue, Heap {
	private StudentArrayList heap;
	private StudentComparator c;

	/**
	 * Creates a PriorityQueue with the default initial capacity and whose
	 * elements are ordered according to the specified comparator.
	 * 
	 * @param c
	 *            the comparator that will be used to order this priority queue
	 */

	public HeapPriorityQueue(StudentComparator c) {
		heap = new StudentArrayList();
		this.c = c;
		heap.add(0, null);
	}

	@Override
	public void insert(Student s) {
		// Inserts the specified element s into heap
		heap.add(s);
		swim(size());
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Student removeMax() {
		// removes and returns max-priority element of heap
		if (isEmpty())
		{
			System.out.println("removeMax() error: the heap is empty.");
			return null;
		}
		Student result = max();
		int maxIndx = maxIndx();
		if (size() > 1)
		{
			heap.set(maxIndx, heap.get(size()));
			sink(maxIndx);
		}
		heap.remove(size());
		return result;
	}

	@Override
	public Student max() {
		// returns max-priority element of heap
		if (isEmpty())
			return null;
		Student max = heap.get(1);
		for (int i = 2; i <= size(); i++) {
			if (c.compare(max, heap.get(i)) < 0) {
				max = heap.get(i);
			}
		}
		return max;
	}
	
	public int maxIndx() {
		// returns index of max-priority element of heap
		if (isEmpty())
			return -1;
		int maxIdx = 1;
		for (int i = 2; i <= size(); i++) {
			if (compare(maxIdx, i) < 0) {
				maxIdx = i;
			}
		}
		return maxIdx;
	}

	@Override
	public int size() {
		return heap.size() - 1;
	}

	@Override
	public void swim(int index) {
		if (index > 1)
		{
			int par = getParent(index);
			if(compare(index, par) > 0)
			{
				swap(index, par);
				swim(par);
			}
		}
	}

	@Override
	public void sink(int index) {
		int l = getLeft(index);
		int r = getRight(index);
		int largest = 1;
		if (l <= size() && compare(l, index) > 0)
			largest = l;
		else
			largest = index;
		if (r <= size() && compare(r, largest) > 0)
			largest = r;
		if (largest != index)
		{
			swap(index, largest);
			sink (largest);
		}
	}
	
	private int compare(int i, int j) {
	       return c.compare(heap.get(i), heap.get(j));
	}

	private void swap(int i, int j) {
		Student swap = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, swap);
	}
	    
	@Override
	public int getParent(int index) {
		return index / 2;
	}

	@Override
	public int getLeft(int i) {
		return 2 * i;
	}

	@Override
	public int getRight(int i) {
		return 2 * i + 1;
	}

}
