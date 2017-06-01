package lab3_3;

import lab3_3.ArrayQueue;
import lab3_3.LinkedStack;

public class lab3_3 {
	public enum Name {	
						Mary,
						Mark,
						Elena,
						Alex, 
						Alexa, 
						Brian, 
						Jane, 
						John, 
						Lala, 
						Thom, 
						Hannah, 
						Antoniy, 
						Antoinnetta, 
						Fedya, 
						Natasha, 
						Artyom, 
						Daryna, 
						Kal, 
						Nadya, 
						Peter, 
						Alice, 
						Bogdan, 
						Polyna, 
						Lyosha, 
						Iryna, 
						Amadeus, 
						Karina, 
						Alexandr, 
						Anfisa, 
						Yaroslav,
						Lolita
						};
	private static final int enumSize = Name.values().length;
	public static void main (String[] args) {
		ArrayQueue queue1 = new ArrayQueue();
		ArrayQueue queue2 = new ArrayQueue();
		
		LinkedStack stack = new LinkedStack();
		Name namesArr[] = Name.values();
		for (int i = 0; i < enumSize; i++)
		{;
			stack.push(namesArr[i]);
		}
		
		System.out.println ("The starting stack:");
		stack.printStackData();
		System.out.println ("");
		
		while(!stack.isEmpty())
		{
			Name name = stack.pop();
			int id = name.ordinal();
			String addVar = name.toString();
			if (id % 2 == 0)
				queue1.enqueue(addVar);
			else
				queue2.enqueue(addVar);
		}
		
		System.out.println ("Queue 1 (female names):");
		queue1.printQueue();
    	queue1.printSizes();
		System.out.println ("");
		System.out.println ("Queue 2 (male names):");
		queue2.printQueue();
    	queue2.printSizes();
		System.out.println ("");
	}

}
