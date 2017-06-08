package lab6;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {

		// TODO
		// implement comprising priorities of s1 and s2
		// use fields according your variant
		int s1Priority = 0;
		int s2Priority = 0;

		boolean city1Priority = s1.getCity().equals("Kyiv");
		boolean city2Priority = s2.getCity().equals("Kyiv");

		if (city1Priority && city2Priority == false)
			s1Priority += 5;
		else if (city1Priority == false && city2Priority)
			s2Priority += 5;

		int courseCompare = Integer.compare(s1.getCourse(), s2.getCourse());

		if (courseCompare < 0)
			s1Priority -= s2.getCourse() - s1.getCourse();
		else if (courseCompare > 0)
			s2Priority -= s1.getCourse() - s2.getCourse();

		return Integer.compare(s1Priority, s2Priority);
	}

}





//
//System.out.printf("s ONE: %s", s1.toString());
//System.out.printf("s TWO: %s", s2.toString());
//System.out.printf("Difference between courses: %d\n", Math.abs(s2.getCourse() - s1.getCourse()));
//System.out.printf("Course compare: %d\n", courseCompare);
//System.out.printf("s ONE priority: %d\n", s1Priority);
//System.out.printf("s TWO priority: %d\n", s2Priority);
//if (Integer.compare(s1Priority, s2Priority) > 0)
//{
//	System.out.printf("s1 has priority.\n\n");
//}
//else if (Integer.compare(s1Priority, s2Priority) < 0)
//{
//	System.out.printf("s2 has priority.\n\n");
//}
//else
//{
//	System.out.printf("NO ONE has priority.\n\n");
//}
	