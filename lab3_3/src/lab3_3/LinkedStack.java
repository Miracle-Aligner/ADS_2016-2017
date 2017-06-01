package lab3_3;

import lab3_3.SLNode;
import lab3_3.lab3_3.Name;

public class LinkedStack implements Stack {
	private SLNode top;

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public Name pop() {
		if (isEmpty()){
			System.out.println("	Stack underflow.");
			return (Name) null;
		}
		Name item = top.data;
		top = top.next;
		
		return item;
	}

	@Override
	public void push(Name item) {
		top = new SLNode (item, top);
	}

	@Override
	public Name top() {
		return top.data;
	}
	
	@Override
	public int size() {
		if (!isEmpty())
		{
			int i;
			SLNode temp = top;
			for (i = 1; temp.next != null; i++){
				temp = temp.next;
			}
			return i;
		}
		return 0;
	}
	public void printStackData (){
		if (!isEmpty())
		{
			int i;
			SLNode temp = top;
			for (i = 0; temp.next != null; i++)
			{
				System.out.printf ("	%d. %s\n", i, temp.data);
				temp = temp.next;
			}
			System.out.printf ("	%d. %s\n", i, temp.data);
		}
		else 
			System.out.printf ("	The stack is empty.\n");
		
		System.out.println ("");
		System.out.printf ("		Size of the stack: %d\n", size());
		System.out.println ("");
	}

}
