package bst;

import java.util.List;

public class Task1Main {
	// name of file which stores data about students
	private static String fileName = "students.csv";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create object of class StudentReader and invoke method read
		StudentReader reader = new StudentReader(fileName);
		List <Student> students = reader.read();
		StudentDictionary<Student> dict = new BSTree<>();

		// TEST dict.put
		// fill dictionary:insert students to the dictionary
		for (int i = 0; i < students.size(); i++) {
			dict.put(students.get(i));
		}

		// TEST dict.print dictionary
		// output the content of a dictionary
		System.out.printf("\n-------------------------------PART ONE---------------------------------\n");
		System.out.printf("CardNumber|   Name   |    Surname    |   Sex    |Study Year|   City    |\n");
		dict.printDictionary();

		// TEST dict.put
		// insert students with non-unique key
		// TODO
		Student alice = new Student(87456123 , 5, "male", "ALice", "Cooper", "Detroit");
		dict.put(alice);

		// TEST: dict.contains
		// TODO
		System.out.printf("\n---------------TEST: dict.contains");
		if (dict.contains(alice))
			System.out.println("\n--------Description: The recently added student with not unique key is presented in the dictionary.");
		else
			System.out.println("Error: The recently added student with not unique key ISN'T presented in the dictionary.");
		System.out.println("\nCHANGED DICTIONARY:");
		System.out.printf("CardNumber|   Name   |    Surname    |   Sex    |Study Year|   City    |\n");
		dict.printDictionary();
		
		// TEST: dict.get
		// TODO
		Student alice4Test = dict.get(alice.getCardNumber());
		System.out.printf("\n---------------TEST: dict.get");
		System.out.printf("\nCardNumber = %d\nName: %s\nSurname: %s\nSex: %s\nStudy Year = %d\nCity: %s\n",
							alice4Test.getCardNumber(),
							alice4Test.getName(),
							alice4Test.getSurname(),
							alice4Test.getSex(),
							alice4Test.getCourse(),
							alice4Test.getCity());

		// TEST: dict.remove
		// TODO
		System.out.printf("\n---------------TEST: dict.remove");
		System.out.printf("\n--------Description: remove Alice");
		dict.remove(alice.getCardNumber()); // Alice
		System.out.println("");
		System.out.println("\nCHANGED DICTIONARY:");
		System.out.printf("CardNumber|   Name   |    Surname    |   Sex    |Study Year|   City    |\n");
		dict.printDictionary();
		
		System.out.printf("\n--------Description: remove root");
		dict.remove(123456780); // Sasha
		System.out.println("");
		System.out.println("\nCHANGED DICTIONARY:");
		System.out.printf("CardNumber|   Name   |    Surname    |   Sex    |Study Year|   City    |\n");
		dict.printDictionary();
		
		System.out.printf("\n--------Description: remove Natasha");
		dict.remove(54123698); // Natasha
		System.out.println("");
		System.out.println("\nCHANGED DICTIONARY:");
		System.out.printf("CardNumber|   Name   |    Surname    |   Sex    |Study Year|   City    |\n");
		dict.printDictionary();
		
		System.out.printf("\n--------Description: remove root whit two childrens");
		dict.remove(87564128); // Gosha
		System.out.println("");
		System.out.println("\nCHANGED DICTIONARY:");
		System.out.printf("CardNumber|   Name   |    Surname    |   Sex    |Study Year|   City    |\n");
		dict.printDictionary();
		
		System.out.println("");
		System.out.printf("\n-------------------------------PART TWO---------------------------------");
		System.out.println("\nRESTORE CHANGES:");
		StudentDictionary<Student> dict2 = new BSTree<>();
		for (int i = 0; i < students.size(); i++) {
			dict2.put(students.get(i));
		}
		System.out.printf("CardNumber|   Name   |    Surname    |   Sex    |Study Year|   City    |\n");
		dict2.printDictionary();
		
		System.out.printf("\n---------------TEST: delete by criteria (female, Kyiv, 5th course)");
		dict2.removeByCriterion(5, "female", "Kyiv");
		System.out.println("");
		System.out.println("\nCHANGED DICTIONARY:");
		System.out.printf("CardNumber|   Name   |    Surname    |   Sex    |Study Year|   City    |\n");
		dict2.printDictionary();
		
		
	}

}