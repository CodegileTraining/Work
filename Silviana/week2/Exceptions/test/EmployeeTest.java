package com.example.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.model.Employee;
import com.example.dao.EmployeeDAOFactory;
import com.example.dao.EmployeeDAO;
import java.util.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeTest {

	public static void main(String[] args) throws Exception {
		EmployeeDAOFactory factory = new EmployeeDAOFactory();

		boolean timeToQuit = false;

		EmployeeDAO dao = factory.createEmployeeDAO();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		do {
			timeToQuit = executeMenu(in, dao);
		} while (!timeToQuit);
	}

	/**
	 * The menu which helpes to know what you want to do : create, read, update, delete, list, quit
	 * @param in
	 * 		Input source to use for data entry.
	 * @param dao
	 * 		A employee which supports CRUD modifications.
	 * @return
	 * @throws IOException
	 * @throws InvalidIdException
	 * @throws InvalidFirstNameException
	 * @throws InvalidBirthDateException
	 * @throws NegativeSalaryException
	 */
	public static boolean executeMenu(BufferedReader in, EmployeeDAO dao) throws IOException, InvalidIdException,
			InvalidFirstNameException, InvalidBirthDateException, NegativeSalaryException {
		Employee emp;
		String action;
		int id;

		System.out.println("\n\n[C]reate | [R]ead | [U]pdate | [D]elete | [L]ist | [Q]uit: ");
		action = in.readLine();
		if ((action.length() == 0) || action.toUpperCase().charAt(0) == 'Q') {
			return true;
		}

		switch (action.toUpperCase().charAt(0)) {
		// Create a new employee record
		case 'C':
			emp = inputEmployee(in);
			dao.add(emp);
			System.out.println("Successfully added Employee Record: " + emp.getId());
			System.out.println("\n\nCreated " + emp);
			break;

		// Display an employee record
		case 'R':
			System.out.println("Enter int value for employee id: ");
			id = new Integer(in.readLine().trim());

			// Find this Employee record
			try {
				emp = dao.findById(id);
				if (emp == null)
					throw new EmployeeNotFoundException("Employee not found!");

				System.out.println(emp + "\n");

			} catch (EmployeeNotFoundException e) {
				e.printStackTrace();
			}

			// Update an existing employee record
		case 'U':
			System.out.println("Enter int value for employee id: ");
			id = new Integer(in.readLine().trim());
			// Find this Employee record
			emp = null;
			try {
				emp = dao.findById(id);
				if (emp == null)
					throw new EmployeeNotFoundException("Employee not found!");
			} catch (EmployeeNotFoundException ex) {
				ex.printStackTrace();
			}

			// Go through the record to allow changes

			emp = inputEmployee(in, emp);
			dao.update(emp);
			System.out.println("Successfully updated Employee Record: " + emp.getId());
			break;

		// Delete an employee record
		case 'D':
			System.out.println("Enter int value for employee id: ");
			id = new Integer(in.readLine().trim());

			// Find this Employee record
			dao.delete(id);
			System.out.println("Deleted Employee " + id);
			break;

		// Display a list (Read the records) of Employees
		case 'L':
			Employee[] allEmps = dao.getAllEmployees();
			for (Employee employee : allEmps) {
				System.out.println(employee + "\n");
			}
			break;
		}

		return false;
	}

	/**
	 *  Reads and returns a valid Employee for use in the program.
	 * @param in
	 * 		Input source to use for data entry.
	 * @return
	 * 		The Employee who was introduced.
	 * @throws IOException
	 * @throws InvalidIdException
	 * @throws InvalidFirstNameException
	 * @throws InvalidBirthDateException
	 * @throws NegativeSalaryException
	 */
	public static Employee inputEmployee(BufferedReader in) throws IOException, InvalidIdException,
			InvalidFirstNameException, InvalidBirthDateException, NegativeSalaryException {
		return inputEmployee(in, null, true);
	}

	/**
	 * Reads and returns a valid Employee for use in the program.
	 * @param in
	 * 		Input source to use for data entry.
	 * @param empDefaults
	 * @return
	 *		The Employee who was introduced.
	 * @throws IOException
	 * @throws InvalidIdException
	 * @throws InvalidFirstNameException
	 * @throws InvalidBirthDateException
	 * @throws NegativeSalaryException
	 */
	public static Employee inputEmployee(BufferedReader in, Employee empDefaults) throws IOException,
			InvalidIdException, InvalidFirstNameException, InvalidBirthDateException, NegativeSalaryException {
		return inputEmployee(in, empDefaults, false);
	}

	/**
	 * Reads and returns a valid id for use in the program.
	 * @param in
	 * 		Input source to use for data entry.
	 * @param empDefaults
	 * @param newEmployee
	 * @return
	 * 		The employee who was introduced.
	 * @throws IOException
	 * @throws InvalidIdException
	 * @throws InvalidFirstNameException
	 * @throws InvalidBirthDateException
	 * @throws NegativeSalaryException
	 */
	public static Employee inputEmployee(BufferedReader in, Employee empDefaults, boolean newEmployee)
			throws IOException, InvalidIdException, InvalidFirstNameException, InvalidBirthDateException,
			NegativeSalaryException {
		SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy");
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		int id = -1;
		String firstName;
		String lastName;
		Date birthDate = null;
		Employee emp;
		float salary;

		if (newEmployee) {
			do {
				System.out.println("Enter int value for employee id: ");
				try {
					id = new Integer(in.readLine().trim());
					if (id < 0) {
						throw new InvalidIdException("Id is not a valid positive integer!");
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			} while (id < 0);
		} else {
			id = empDefaults.getId();
			System.out
					.println("Modify the fields of Employee record: " + id + ". Press return to accept current value.");
		}

		String prompt = "Enter value for employee first name"
				+ ((empDefaults == null) ? "" : " [" + empDefaults.getFirstName() + "]");

		do {
			System.out.println(prompt + " : ");
			firstName = in.readLine().trim();
			if (firstName.equals("") && empDefaults != null) {
				firstName = empDefaults.getFirstName();
			}
			if (firstName.length() < 1) {
				throw new InvalidFirstNameException("You didn't introduce a valid first name!");
			}
		} while (firstName.length() < 1);

		prompt = "Enter value for employee last name"
				+ ((empDefaults == null) ? "" : " [" + empDefaults.getLastName() + "]");
		do {
			System.out.println(prompt + " : ");
			lastName = in.readLine().trim();
			if (lastName.equals("") && empDefaults != null) {
				lastName = empDefaults.getLastName();
			}
			if (lastName.length() < 1) {
				throw new InvalidFirstNameException("You didn't introduce a valid first name!");
			}
		} while (lastName.length() < 1);

		prompt = "Enter value for employee birth date (" + df.toLocalizedPattern() + ")"
				+ ((empDefaults == null) ? "" : " [" + df.format(empDefaults.getBirthDate()) + "]");
		do {
			System.out.println(prompt + " : ");
			String dateStr = in.readLine().trim();
			if (dateStr.equals("") && empDefaults != null) {
				birthDate = empDefaults.getBirthDate();
			} else {
				birthDate = null;
				try {
					birthDate = new Date(df.parse(dateStr).getTime());
					throw new InvalidBirthDateException("You didn't introduce a valid birth date!");
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		} while (birthDate == null);

		prompt = "Enter float value for employee salary"
				+ ((empDefaults == null) ? "" : " [" + nf.format((double) empDefaults.getSalary()) + "]");
		do {
			System.out.println(prompt + " : ");
			salary = 0;
			try {
				String amt = in.readLine().trim();
				if (!amt.equals("")) {
					salary = Float.parseFloat(amt);
				}
				if (salary == 0 && empDefaults != null) {
					salary = empDefaults.getSalary();
				}
				if (salary < 0) {
					salary = 0;
					throw new NegativeSalaryException("You introduced a negative salary!");

				}
			} catch (NegativeSalaryException e) {
				e.printStackTrace();
			}
		} while (salary == 0);

		// Create an Employee object
		emp = new Employee(id, firstName, lastName, birthDate, salary);
		return emp;
	}
}