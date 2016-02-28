package inst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents an Institution which can contain multiple employees.
 * 
 * @author Roxana
 *
 */
public class Institution {

	private static Institution institution;
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	private Institution() {
	}

	/**
	 * It checks whether an instance of {@link Institution} is created, if not
	 * it automatically creates it.
	 * 
	 * @return a institution
	 */
	public static Institution get() {
		if (institution == null) {
			institution = new Institution();
		}
		return institution;
	}

	/**
	 * Initializing the list of employees.
	 */
	public void initEmployee() {
		File file = new File("fisAngajati");
		Scanner fsc = null;
		try {
			fsc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		while (fsc.hasNextLine()) {
			String line = fsc.nextLine();
			String[] splitLine = line.split("-");

			if (splitLine[0].equals("Director"))
				employees.add(new Director("", splitLine[1]));

			if (splitLine[0].equals("Manager"))
				employees.add(new Manager("", splitLine[1]));

			if (splitLine[0].equals("Secretary"))
				employees.add(new Secretary("", splitLine[1]));
		}

	}

	/**
	 * Adds a gift to the employee.
	 * 
	 * @param e
	 *            Employee to receive gift
	 * @param g
	 *            Gift for employee
	 */
	public void addGiftToEmployee(Employee e, Gift g) {
		g.setEmployee(e);
		e.addGift(g);
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	/**
	 * Displaying the list of employees
	 * 
	 */
	public void printEmployees() {
		for (Employee e : employees) {
			e.printGifts();

		}
	}
}
