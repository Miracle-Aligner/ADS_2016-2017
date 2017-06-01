package lab3_3;

import lab3_3.lab3_3.Name;

public interface Stack {

	/**
	 * Tests if this stack is empty
	 * 
	 * @return true if this stack contains no items; false otherwise
	 */
	boolean isEmpty();

	/**
	 * Removes the item at the top of this stack and returns that item as the
	 * value of this function.
	 * 
	 * @return the object at the top of this stack or empty String if this stack
	 *         is empty
	 * 
	 */
	Name pop();

	/**
	 * Adds an item onto the top of this Stack
	 * 
	 * @param item
	 *            the item to be pushed onto this stack
	 */
	void push(Name item);

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack
	 * 
	 * @return the top element in the stack, or null if the stack is empty.
	 **/
	Name top();

	/**
	 * Returns the number of elements in this stack
	 * 
	 * @return the number of elements in the stack
	 */
	int size();

}