package lab6;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 5
 * 
 * @author Olena Khomenko <br>
 *         Represents information about student: its name and number of course
 *         <br>
 *         This class is a sample how to define class, fields and methods
 * 
 *         Rewrite this class and its methods <br>
 *         Choose information to be saved in a class from lab manuals (table 1,
 *         col.2).<br>
 * 
 *         Write methods setXXX to set specified value to the field XXX. <br>
 * 
 *         Write method print to output information about student (values of the
 *         fields) in formatted string. <br>
 * 
 *         Write static methods boolean isValidXXX to check whether specified
 *         string could set (or convert and set) to the field XXX
 *
 */

public class Student {

	private int course;
	private String sex;
	private String name;
	private String surname;
	private int cardNumber;
	private String city;

	public Student(int cardNumber, int course, String sex, String name, String surname, String city) {
		this.cardNumber = cardNumber;
		this.course = course;
		this.sex = sex;
		this.name = name;
		this.surname = surname;
		this.city = city;
	}

	public int getkey() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCardNumber() {
		return this.cardNumber;
	}

	public int getCourse() {
		return this.course;
	}

	public String getSex() {
		return this.sex;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public String getCity() {
		return this.city;
	}

	@Override
	public String toString() {
		return String.format("%-10d|%-10s|%-15s|%-10s|%-10d|%-11s|\n", cardNumber, name, surname, sex, course, city);
	}

	public boolean equals(Student s1, Student s2) {
		if (s1.getCardNumber() == s2.getCardNumber()) {
			if (s1.getSurname().equals(s2.getSurname())) {
				if (s1.getName().equals(s2.getName())) {
					if (s1.getCity().equals(s2.getCity())) {
						if (s1.getCourse() == s2.getCourse()) {
							if (s1.getSex().equals(s2.getSex())) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Determines if the specified string is valid card number: contains only
	 * one digit character
	 * 
	 * @param number
	 *            the string to be tested
	 * @return true if the specified string is a valid card number, false
	 *         otherwise.
	 */
	public static boolean isValidCardNumber(String number) {
		char[] chArray = number.toCharArray();
		for (char ch : chArray) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;

	}

	public static boolean isValidCourse(String course) {
		char[] chArray = course.toCharArray();
		for (char ch : chArray) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}

		if (Integer.parseInt(course) > 0) {
			if (Integer.parseInt(course) < 7)
				return true;
		}

		return false;
	}

	public static boolean isValidSex(String sex) {
		char[] chArray = sex.toCharArray();
		for (char ch : chArray) {
			if (!Character.isAlphabetic(ch)) {
				return false;
			}
		}

		if (!sex.equalsIgnoreCase("male")) {
			if (!sex.equalsIgnoreCase("female")) {
				return false;
			}
		}
		return true;

	}

	public static boolean isValidName(String name) {
		char[] chArray = name.toCharArray();
		for (char ch : chArray) {
			if (!Character.isAlphabetic(ch)) {
				return false;
			}
		}
		return true;

	}

	public static boolean isValidSurname(String surname) {
		char[] chArray = surname.toCharArray();
		for (char ch : chArray) {
			if (!Character.isAlphabetic(ch)) {
				return false;
			}
		}
		return true;

	}

	public static boolean isValidCity(String city) {
		char[] chArray = city.toCharArray();
		for (char ch : chArray) {
			if (!Character.isAlphabetic(ch)) {
				return false;
			}
		}
		return true;
	}

}
