package lab4_task2.lab4_task2;

import common.FigureSet;
import common.GeomFigure;

/**
 * 
 * This class implements a set as a hash table. Hash table resolves collisions
 * Hash table is an associative array of entries. <br>
 * Each entry contains geometric figure or null. <br>
 * 
 *
 */
public class SChHastable implements FigureSet {

	private DLNode[] table;

	/**
	 * the number of non-null entries in the hashtable
	 */
	private int size;

	private int capacity;

	/**
	 * default size of the hashtable
	 */
	private final int initialCapacity = 11;

	/**
	 * The load factor is a measure of how full the hash table is allowed to get
	 * / before its capacity is automatically increased
	 */
	private double loadFactor = 0.75;

	/**
	 * Constructs a new, empty hashtable with a default initial capacity (11)
	 * and load factor (0.75).
	 */
	public SChHastable() {
		// create an array of size equals to default initialCapacity
		this.table = new DLNode[this.initialCapacity];
		this.capacity = this.initialCapacity;
		this.size = 0;
	}

	/**
	 * Constructs a new, empty hashtable with the specified initial capacity and
	 * default load factor (0.75).
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the hashtable
	 */
	public SChHastable(int initialCapacity) {
		// create an array of size equals to initialCapacity
		this.table = new DLNode[initialCapacity];
		this.capacity = initialCapacity;
		this.size = 0;
	}

	/**
	 * Constructs a new, empty hashtable with the specified initial capacity and
	 * the specified load factor.
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the hashtable
	 * @param loadFactor
	 *            the load factor of the hashtable
	 */
	public SChHastable(int initialCapacity, double loadFactor) {
		// TODO create an array of size equals to initialCapacity
		// TODO initialize field loadFactor
		this.size = 0;
		this.loadFactor = loadFactor;
		this.capacity = initialCapacity;
		this.table = new DLNode[initialCapacity];

	}

	/**
	 * Returns the number of entries in the hashtable
	 * 
	 * @return the number of entries in the hashtable
	 */
	public int size() {
		return size;
	}

	/**
	 * Increases the capacity of and internally reorganizes this hashtable, in
	 * order to accommodate and access its entries more efficiently. This method
	 * is called when the number of elements in the hashtable exceeds this
	 * hashtable's capacity and load factor
	 */
	private void rehash() {
		// TODO
		DLNode[] prevTable = this.table;
		int currArrSize = this.table.length;
		this.capacity *= 2;
		this.table = new DLNode[this.capacity];
		for (int i = 0; i < currArrSize; i++){
			DLNode tmp;
			tmp = prevTable[i];
			while (tmp != null){
				this.add(tmp.data);
				tmp = tmp.next;
			}
		}
	}

	/**
	 * The hash function is used to calculate the hasvalue of the object gf.
	 * Choose hashing method from your variant (table 1): deletion or
	 * multiplication
	 * 
	 * @param gf
	 *            some geometric figure
	 * @return hash value - index in table
	 */
	private int hash(GeomFigure gf) {
		return gf.hashCode() % this.capacity;
	}

	@Override
	public boolean add(GeomFigure gf) {
		// TODO
		// if gf is not null and hashtable doesn't contain gf
		// ---calculate hash-value (slot number) of gf
		// ---add new Node (gf) to the linked list in the this slot
		// ---increase the size of hash table
		// ---return true
		if (gf != null){
			if(!contains(gf)) {
				int figHash = hash(gf);
				if (this.table[figHash] != null) {
					DLNode tmp = this.table[figHash];
					this.table[figHash] = new DLNode(gf, tmp, null);
					if (tmp!=null)
						tmp.prev = this.table[figHash];
				} else {
					this.table[figHash] = new DLNode(gf);
				}
				this.size++;
				if ((double) (this.size / this.capacity) >= loadFactor) {
					rehash();
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean contains(GeomFigure gf) {
		// if gf is not null
		// ----Calculate hashvalue (slot number)of gf
		// ------search gf in the linked list in this slot
		if (gf != null){
			int figHash = hash(gf);
			DLNode tmp = this.table[figHash];
			if (tmp != null){
				while (tmp != null){
					if (gf.equals(tmp.data)){
						return true;
					}
					tmp = tmp.next;
				}
			}
		}
		return false;
	}

	@Override
	public boolean remove(GeomFigure gf) {
		// if gf is not null and hashtable contains gf
		// ---Calculate hashvalue of gf
		// ---if slot is not empty
		// -------delete Node (gf) from linked list
		// -------decrease the size of hash table
		// -------return true
		if (gf != null){
			if(contains(gf)) {
				int figHash = hash(gf);
				DLNode tmp = this.table[figHash];
				while (!gf.equals(tmp.data)) {
					tmp = tmp.next;
				}
				if (tmp.prev != null){
					if(tmp.next != null){
						tmp.next.prev = tmp.prev;
					}
					tmp.prev.next = tmp.next;
					tmp.data = null;
				} else {
					this.table[figHash] = null;
				}
				this.size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		// check the size of hashtable
		return size == 0;
	}

	@Override
	public void print() {
		// TODO
		// Output the table , where each row contains a number of the hash-table
		// slot, and the all elements that hashes to this slot.For example,

		// If a slot is empty the row contains a number of the hash-table slot
		// and the message �The slot is empty�.
		System.out.println(String.format("   Slot   |   Hashcode   |   Vertex 1   |   Vertex 2   |   Vertex 3   |  Angle   |"));
		for (int i = 0; i < capacity; i++){
			if(table[i] != null){
				System.out.println("");
				DLNode temp = table[i];
				while(temp != null){
					System.out.println(String.format("    %-6s|%s", i, temp.data.toString()));
					temp = temp.next;
				}
				System.out.println("");
			} else {
				System.out.println(String.format("    %-6s|     The      |     slot     |      is      |    empty.    |          |", i));
			}
		}
	}

}

class DLNode {
	GeomFigure data; // the data stored in this node.

	DLNode next; // pointer to the next node
	DLNode prev; // pointer to the previous nod

	/**
	 * Construct the node of doubly-linked list with null pointers to the next
	 * and previous nodes
	 *
	 * @param data
	 *            the data to stored in this node
	 */
	public DLNode(GeomFigure data) {
		this.data = data;
		next = null;
		prev = null;
	}

	/**
	 * Construct the node of doubly-linked list and fill its fields
	 *
	 * @param data
	 *            the data to stored in this node
	 * @param next
	 *            pointer to the next node
	 * @param prev
	 *            pointer to the previous node
	 */
	public DLNode(GeomFigure data, DLNode next, DLNode prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

}
