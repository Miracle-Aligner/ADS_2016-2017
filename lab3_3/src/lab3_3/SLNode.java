package lab3_3;

import lab3_3.lab3_3.Name;

public class SLNode {
	Name data; // the data stored in this node.
	SLNode next; // pointer to the next node
	
	/**
	 * Construct the node of singly-linked list with data and null pointer to
	 * the next node
	 * 
	 * @param data
	 *            the data to stored in this node
	 */
	public SLNode(Name data) {
		this.data = data;
		next = null;
	}

	/**
	 * Construct the node of singly-linked list with data and pointer to the
	 * next node
	 * 
	 * @param data
	 *            the data to stored in this node
	 * @param next
	 *            pointer to the next node
	 */
	public SLNode(Name data, SLNode next) {
		this.data = data;
		this.next = next;
	}
}
