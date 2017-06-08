package lab6;

import java.util.List;

import lab6.max_priority_queue.HeapPriorityQueue;
//import lab6.lab6.max_priority_queue.HeapPriorityQueue;
import lab6.max_priority_queue.UnsortedArrayPriorityQueue;

public class Main {
	static final int N = 10;

	public static void main(String[] args) {
		// create priority queue based on linear data structure
		// For example,

		MaxPriorityQueue pq1 = new UnsortedArrayPriorityQueue(new StudentComparator());

		// create priority queue based on linear data structure
		// For example,

		MaxPriorityQueue pq2 = new HeapPriorityQueue(new StudentComparator());

		// read student from file
		// create object of class StudentReader and invoke method read

		StudentReader reader = new StudentReader("students.csv");
		List <Student> students = reader.read();
		
		// fill pq1 and pq2
		
		int studSize = students.size();
		for (int i = 0; i < studSize; i++)
		{
			pq1.insert(students.get(i));
			pq2.insert(students.get(i));
		}
		
		Student[] s1 = new Student[N];
		
		// remove 10 items from pq1
		
		for (int i = 0; i < N; i++)
		{
			s1[i] = pq1.removeMax();
		}
		System.out.println("Elemets, deleted from MaxPriorityQueue pq1:");
		outputStudents(s1);

		Student[] s2 = new Student[N];
		// remove 10 items from pq2
		
		for (int i = 0; i < N; i++)
		{
			s2[i] = pq2.removeMax();
		}
		System.out.println("\nElemets, deleted from MaxPriorityQueue pq2:");
		outputStudents(s2);

		if (equals(s1, s2) == true) {
			System.out.println("\nWork is done!");
		}

	}

	private static void outputStudents(Student[] s1) {
		System.out.printf("CardNumber|   Name   |    Surname    |   Sex    |Study Year|   City    |\n");
		for (int i = 0; i < s1.length; i++)
		{
			System.out.printf("%s", s1[i].toString());
		}
	}

	private static boolean equals(Student[] s1, Student[] s2) {
		// Compare elements in arrays s1 and s2
		int arrSize = s1.length;
		boolean isEqual = true;
		for (int i = 0; i < arrSize; i++)
		{
			if (!contains(s1[i], s2))
			{
				isEqual = false;
			}
		}
		return isEqual;
	}
	
	private static boolean contains(Student s, Student[] arr) {
		int arrSize = arr.length;
		boolean isEqual = false;
		for (int i = 0; i < arrSize; i++)
		{
			if (arr[i].equals(s))
			{
				isEqual = true;
			}
		}
		return isEqual;
	}
}
