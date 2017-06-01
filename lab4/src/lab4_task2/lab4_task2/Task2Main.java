package lab4_task2.lab4_task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

import common.FigureSet;
import common.GeomFigure;

public class Task2Main {
	// name of file which stores data about geometric figures
	private static String fileName = "figures.csv";

	// path to the current directory that contains directory "data"
	private static String currenDir = System.getProperty("user.dir")
			+ File.separatorChar + "data";

	public static void main(String[] args) {
		// 1) read all lines from a file

		// 2) create the array of geometric figures and check data from the file

		// 3) Create a set of figures

		// 4) Print a set of figures
		
		List<String[]> lines = readcsvFile(fileName, currenDir);

		if (!lines.isEmpty()) {
			int numLines = lines.size();
			System.out.println("File contains " + numLines + "  lines");

			// 2) create the array of geometric figures and check data from the
			// file
			GeomFigure[] farray = createArrayOfFigures(lines);
			// 3) Create a set of figures
			FigureSet figures = new SChHastable();
			for (GeomFigure f : farray) {
				figures.add(f);
			}
			// 4) Print a set of figures
			figures.print();

		} else {
			System.out.println("Error: file  " + fileName + "   is empty");
			System.exit(0);
		}

	}

	static List<String[]> readcsvFile(String fileName, String dirName) {
		CSVReader reader = null;
		String path = Paths.get(currenDir, fileName).toString();
		List<String[]> list = null;

		// read data from a file
		try {

			reader = new CSVReader(new FileReader(path));
			System.out.println("File \"" + path + " \"  have been reading ");

			// read all lines from a file
			list = reader.readAll();
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error: file  " + path + "   not found");
		} catch (IOException e) {
			System.err.println("Error:read file " + path + "   error");
		} catch (SecurityException e) {
			System.err.println(e.getMessage());
		}

		return list;
	}

	static GeomFigure[] createArrayOfFigures(List<String[]> list) {
		int num = 0;
		// create empty array of geometric figures with the length = list.size()
		GeomFigure[] farray = new GeomFigure[list.size()];
		// start reading and analyzing each line from this list
		for (Iterator<String[]> it = list.iterator(); it.hasNext();) {

			// line contains data about one geometric figures
			String[] line = it.next();
			try {
				// TODO
				// check information about geometric figure and fill
				// fields of GeomFigure object
				int v1[] = new int [2];
				int v2[] = new int [2];
				int v3[] = new int [2];
				
				v1[0] = (int) Integer.valueOf(line[0]);
				v1[1] = (int) Integer.valueOf(line[1]);
				v2[0] = (int) Integer.valueOf(line[2]);
				v2[1] = (int) Integer.valueOf(line[3]);
				v3[0] = (int) Integer.valueOf(line[4]);
				v3[1] = (int) Integer.valueOf(line[5]);
				double angle = (double) Double.valueOf(line[6]);
				GeomFigure newOne = new GeomFigure(v1, v2, v3, angle);
				if (newOne.validFigure())
				{
					farray[num++] = newOne;
				}

			} catch (NumberFormatException e) {
				System.out.printf("Angle value out of bounds.\n");
			}

		}
		// check if all data in a file are valid
		if (num != list.size()) {
			// if not, create new array with smaller length
			farray = copyOf(farray, num);
		}

		return farray;
	}

	static GeomFigure[] copyOf(GeomFigure[] farray, int num) {
		// TODO
		// Create new array of geometric figures of size num
		// Copy num first elements from farray students to the new array
		// Return new array
		GeomFigure[] GeomFigure = new GeomFigure[num];
		for (int i = 0; i < num; i++)
		{
			GeomFigure[i] = farray[i];
		}
		
		return new GeomFigure[0];
	}
}
