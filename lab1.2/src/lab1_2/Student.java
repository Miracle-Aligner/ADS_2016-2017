package lab1_2;

public class Student {
	/**
	 * name of this student
	 */
	String name;

	/**
	 * number of course (from 1 to 6)
	 */
	int day;
	int month;
	int year;

	/**
	 * Sets the name of a student
	 * 
	 * @param name
	 *            string specified the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the day of a birth of a student
	 * 
	 * @param day
	 *            integer specified the number of student's day of birth
	 */
	public void setDay(int day) {
		this.day = day;
	}
	
	/**
	 * Sets the month of a birth of a student
	 * 
	 * @param month
	 *            integer specified the number of student's birth month
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	
	/**
	 * Sets the year of a birth of a student
	 * 
	 * @param year
	 *            integer specified the number of student's birth year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Outputs formatted values of fields in standard output
	 * 
	 */
	public void print() {
		System.out.println(String.format("║ %-15s║  %-5d║  %-7d║  %-6d║", name, day, month, year));
	}

	/**
	 * Determines if the specified string is a student's name. This string is
	 * valid if it contains all alphabet letters and begins from uppercase
	 * letter
	 * 
	 * @param name
	 *            the string to be tested
	 * @return true if the specified string is a name, false otherwise.
	 */
	public boolean isValidName(String name) {
		if (name.length() == 0)
		{
			return false;
		}
		if (!Character.isUpperCase(name.charAt(0))) {
			return false;
		}
		for (int i = 1; i < name.length(); i++) {
			if (!Character.isAlphabetic(name.charAt(i)))
				return false;
		}
		return true;

	}

	/**
	 * Determines if the specified string is valid year. This string is
	 * valid if it contains number in range [1946; 2003], because
	 * there is no age limit for enrollees; so 1946 - is the lower limit
	 * cause the avarage life duration in Ukraine is 71 years old 
	 * (2017 - 71 = 1946) & the youngest student in Ukraine is 14 years old.
	 * (2017 - 14 = 2003).
	 * Let's exclude other possible geeks, whose age is less than 14.
	 * 
	 * @param yearStr
	 *            the string to be tested
	 * @return true if the specified string is a valid year, false
	 *         otherwise.
	 */
	public boolean isValidYear(String yearStr) {
		if (!Character.isAlphabetic(yearStr.charAt(0)) &&
			!Character.isAlphabetic(yearStr.charAt(1)) &&
			!Character.isAlphabetic(yearStr.charAt(2)) &&
			!Character.isAlphabetic(yearStr.charAt(3)))
			{	
			if (yearStr.length() == 4) {
				int year = Integer.parseInt(yearStr);
				if (year >= 1946 && year <= 2003) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Determines if the specified string is valid month. This string is
	 * valid if it contains number in range [1; 12].
	 * 
	 * @param monthStr
	 *            the string to be tested
	 * @return true if the specified string is a valid month, false
	 *         otherwise.
	 */
	public boolean isValidMonth(String monthStr) {
		if ((monthStr.length() == 2 && 
			(!Character.isAlphabetic(monthStr.charAt(0)) &&
			!Character.isAlphabetic(monthStr.charAt(1)))) ||
			(monthStr.length() == 1 && 
			!Character.isAlphabetic(monthStr.charAt(0))))
		{
			int month = Integer.parseInt(monthStr);
			if (month >= 1 && month <= 12) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Determines if the specified string is valid day. 
	 * 
	 * @param dayStr
	 *            the string to be tested
	 * @param monthStr
	 *            (for testing if the current day is in the current month)
	 * @param yearStr
	 *            (for testing if year is leap)
	 * @return true if the specified string is a valid day, false
	 *         otherwise.
	 */
	public boolean isValidDay(String dayStr, String monthStr, String yearStr) {
		if ((dayStr.length() == 2 && 
			(!Character.isAlphabetic(dayStr.charAt(0)) &&
			!Character.isAlphabetic(dayStr.charAt(1)))) ||
			(dayStr.length() == 1 && 
			!Character.isAlphabetic(dayStr.charAt(0))) &&
			isValidMonth(monthStr) &&
			isValidYear(yearStr)) 
		{
			int year = Integer.parseInt(yearStr);
			
			if (Integer.parseInt(dayStr) < 1 || Integer.parseInt(dayStr) > 31)
				return false;
			
			if (dayStr.equals("31") && (monthStr.equals("4") || monthStr.equals("6") || monthStr.equals("9") || 
				monthStr.equals("11") || monthStr.equals("04") || monthStr.equals("06") || monthStr.equals("09"))) 
			{
				return false; // only 1,3,5,7,8,10,12 has 31 days
			} 
			else if (monthStr.equals("2") || monthStr.equals("02")) 
			{
				//leap year
				if(year % 4 == 0)
				{
					if(dayStr.equals("30") || dayStr.equals("31"))
					{
						return false;
					}
					else
					{
						return true;
					}
				}
				else
				{
					if(dayStr.equals("29")||dayStr.equals("30")||dayStr.equals("31"))
					{
						return false;
					}
					else
					{
						return true;
					}
				}
			}
			else
			{
				return true;
			}
			
		}
		return false;
	}

}
