package lab1_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class SorterTask2 {
	// name of file which stores data about students
	
	// everything's alright:
	private static String fileName = "students.csv";
	
	//10 studs, 5 of them have valid data, others have empty fields:
	//private static String fileName = "students1.csv";
	
	//none of studs has valid data
	//private static String fileName = "students2.csv";
	
	//10 studs. invalid data, fields aren't blank:
	//private static String fileName = "students3.csv";
	

	// path to the current directory that contains directory "data"
	private static String currenDir = System.getProperty("user.dir")
			+ File.separatorChar + "data";

	public static void main(String[] args) {
		CSVReader reader = null;
		Student[] students = null;
		String path = Paths.get(currenDir, fileName).toString();

		// read data from a file "students.csv"
		try {

			reader = new CSVReader(new FileReader(path));
			System.out.println("File \"" + path + " \"  have been reading ");

			// 1) read all lines from a file
			List<String[]> list = reader.readAll();

			if (!list.isEmpty()) {
				int numLines = list.size();
				System.out.println("File contains " + numLines + "  lines");

				// 2) create the array of students and check data from the file
				students = createArrayOfStudents(list);

			} else {
				System.out.println("Error: file  " + path + "   is empty");
			}

			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error: file  " + path + "   not found");
		} catch (IOException e) {
			System.err.println("Error:read file " + path + "   error");
		} catch (SecurityException e) {
			System.err.println(e.getMessage());
		}

		// 3) Output the array in a table view
		System.out.println("\nBefore sorting\n");
		printStudents(students);

		// 4) Sort the array of students
		students = sort(students);

		// 5) Output sorted array in a table view
		System.out.println("\nAfter sorting\n");
		printStudents(students);
	}

	/**
	 * Checks validity data in the specified list of string array, creates array
	 * and fill the array by object of class Student using only valid data
	 * 
	 * @param list
	 *            the list of array of strings
	 * @return array of students or empty array if all items in the list are not
	 *         valid
	 */
	public static Student[] createArrayOfStudents(List<String[]> list) {
		// number of students with valid data
		int numStudents = 0;

		// create empty array of students with the length = list.size()
		Student[] students = new Student[list.size()];

		// start reading and analyzing each line from this list
		for (Iterator<String[]> it = list.iterator(); it.hasNext();) {

			// line contains data about one student
			String[] line = it.next();

			students[numStudents] = new Student();

			// check correctness information about student and fill
			// fields of Student object
			numStudents += writeStudInfo(students[numStudents], line);
		}
		// check if all data in a file are valid
		if (numStudents != list.size()) {

			// if not, create new array with smaller length
			students = copyOf(students, numStudents);
		}
		return students;
	}

	/**
	 * Copies the specified array, the copy has the specified length. For all
	 * indices that are valid in both the original array and the copy, the two
	 * arrays will contain identical values. For any indices that are valid in
	 * the copy but not the original, the copy will contain null. Such indices
	 * will exist if and only if the specified length is greater than that of
	 * the original array.
	 * 
	 * @param students
	 *            the array of Student class objects to be copied
	 * @param numStudents
	 *            the length of the copy to be returned
	 * @return a copy of the original array, truncated or padded with null to
	 *         obtain the specified length
	 */
	private static Student[] copyOf(Student[] students, int numStudents) {
		// TODO
		// Create new array of students of size numStudents
		// Copy numStudents first elements from array students to the new array
		// Return new array
		Student[] studentsArr = new Student [numStudents];
		
		for (int i = 0; i < numStudents; ++i) {
			studentsArr[i] = students[i];
		}
		return studentsArr;

	}

	/**
	 * Checks correctness the information about student in this line. If checks
	 * for all elements in this line are successful, fills fields of the object
	 * s and return 1.
	 * 
	 * @param s
	 *            the instance of Student with empty fields. If s is null,
	 *            return 0
	 * @param line
	 *            array of Strings represented data about student. If line is
	 *            null, return 0
	 * @return 1 if all data about student are correct, 0 - otherwise
	 */
	public static int writeStudInfo(Student s, String[] line) {

		// return 0 if number of string in a line don't equals to number of
		// fields of class Student
		if (line.length != s.getClass().getDeclaredFields().length) {
			System.err.println("Error: the line  \"" + Arrays.toString(line)
					+ "\" not completed");
			return 0;

		}
		final int nameID = 0;
		final int dayID = 1;
		final int monthID = 2;
		final int yearID = 3;
		
		line[nameID] = line[nameID].trim();
		line[dayID] = line[dayID].trim();
		line[monthID] = line[monthID].trim();
		line[yearID] = line[yearID].trim();
		
		if(line[nameID] == null || line[dayID] == null || line[monthID] == null || line[yearID] == null) 
		{
			return 0;
		}
		// TODO
		// for check each string in a line:
		// 1)invoking methods isValidXXX from class Student
		// 2) if string contains valid information, set the field of student
		
		if (s.isValidName(line[nameID]) && 
			s.isValidYear(line[yearID]) && 
			s.isValidMonth(line[monthID]) && 
			s.isValidDay(line[dayID], line[monthID], line[yearID])) 
		{
			s.setName(line[nameID]);
			s.setDay(Integer.parseInt (line[dayID]));
			s.setMonth(Integer.parseInt (line[monthID]));
			s.setYear(Integer.parseInt (line[yearID]));
			return 1;
		} 
		// if string contains invalid information don't set field and
		// immediately return 0
		else 
			return 0;

		// if all fields in a line contains valid information return 1
	}

	/**
	 * Outputs the table output array of student in table form: each element is
	 * on a separate row. Each row begins with a field by which sorting was
	 * performed Table should have a header with field's names.
	 * 
	 * @param stds
	 *            array of students to be output
	 */
	public static void printStudents(Student[] studs) {
		// TODO
		// check is the studs is null reference
		// check if the length of array is 0
		// output array of students invoking method print from class Student
		if (studs.length != 0 && studs[0] != null){
			System.out.println("╔════════════════╦═══════╦═════════╦════════╗");
			System.out.printf("║     Surname    ║  Day  ║  Month  ║  Year  ║\n");
			System.out.println("╠════════════════╬═══════╬═════════╬════════╣");
			for (int i = 0; i < studs.length;i++) studs[i].print();
			System.out.println("╚════════════════╩═══════╩═════════╩════════╝");
		}
	}

	/**
	 * Sorts the specified array of objects using counting sort.
	 * 
	 * @param studs
	 *            the array to be sorted
	 */
	public static Student[] sort(Student[] studs) {
		// TODO
		int range = 12; // equals the quantity of month in year
		int[] keysArr = new int[range + 1]; // provides temporary working storage
		Student[] studsSorted = new Student[studs.length]; // sorted output array

		// step1 : Count the number of keys of each value
		for (int i = 0; i < studs.length; i++) {
			keysArr[studs[i].month]++; // Use key as index in temporary array

		}

		// Step2: compute partial sums
		for (int i = 1; i < keysArr.length; i++) {
			keysArr[i] += keysArr[i - 1];
		}
		// Step3: calculate the index of each key in the sorted array
		for (int i = studs.length - 1; i >= 0; i--) {
			keysArr[studs[i].month]--;
			studsSorted[keysArr[studs[i].month]] = studs[i];
		}
		return studsSorted;
	}
}
