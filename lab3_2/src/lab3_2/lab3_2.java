package lab3_2;

public class lab3_2 {
	public enum Name {Mark, Mary, Alex, Alexa, Brian, Jane, John, Lala, Thom, Hannah};
	private static final int enumSize = Name.values().length;
	public static void main (String[] args) {
		LinkedStack stack = new LinkedStack();
		Name namesArr[] = Name.values();
		for (int i = 0; i < enumSize - 1; i++)
		{;
			stack.push(namesArr[i]);
		}
		
		System.out.println ("The starting stack:");
		stack.printStackData();
		System.out.println ("");
		
		System.out.println ("Adding one element:");
		stack.push(namesArr[enumSize - 1]);
		stack.printStackData();
		System.out.println ("");
		
		System.out.println ("Deleting one element:");
		stack.pop();
		stack.printStackData();
		System.out.println ("");
		
		System.out.println ("Deleting ALL elements:");
		int stackSize = stack.size();
		for (int i = 0; i < stackSize; i++)
			stack.pop();
		stack.printStackData();
		System.out.println ("");
		
		System.out.println ("Deleting an element from an empty stack:");
		stack.pop();
		stack.printStackData();
		System.out.println ("");
	}
}
