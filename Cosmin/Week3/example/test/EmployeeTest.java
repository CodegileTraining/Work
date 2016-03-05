package Week3.ExceptionsCodegile.src.com.example.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Date;

import Week1.Day1.MyException;
import Week3.ExceptionsCodegile.src.com.example.dao.EmployeeDAO;
import Week3.ExceptionsCodegile.src.com.example.dao.EmployeeDAOFactory;
import Week3.ExceptionsCodegile.src.com.example.exceptions.InvalidEmployeeIDException;
import Week3.ExceptionsCodegile.src.com.example.model.Employee;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeTest {

	public static void main(String[] args) throws Exception {
		EmployeeDAOFactory factory = new EmployeeDAOFactory();

		boolean timeToQuit = false;

		EmployeeDAO dao = factory.createEmployeeDAO();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			do {
				timeToQuit = executeMenu(in, dao);
			} while (!timeToQuit);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Number format exception " + e.getMessage());
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean executeMenu(BufferedReader in, EmployeeDAO dao) throws IOException, MyException {
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
			emp = dao.findById(id);
			if (emp != null) {
				System.out.println(emp + "\n");
			} else {
				throw new MyException("Invalid employee id:" + id);
			}

			break;

		// Update an existing employee record
		case 'U':
			System.out.println("Enter int value for employee id: ");
			id = new Integer(in.readLine().trim());
			// Find this Employee record
			emp = null;
			emp = dao.findById(id);
			if (emp == null) {
				throw new MyException("\n\nEmployee " + id + " not found");
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

	public static Employee inputEmployee(BufferedReader in) throws IOException, MyException {
		return inputEmployee(in, null, true);
	}

	public static Employee inputEmployee(BufferedReader in, Employee empDefaults) throws IOException, MyException {
		return inputEmployee(in, empDefaults, false);
	}

	public static Employee inputEmployee(BufferedReader in, Employee empDefaults, boolean newEmployee)
			throws IOException, MyException {
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
						System.out.println("Please retry with a valid positive integer id");
					}
				} catch (NumberFormatException e) {
					System.out.println("Please retry with a valid positive integer id");
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
				throw new MyException("Invalid first name");
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
				throw new MyException("Invalid last name");
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
				} catch (ParseException e) {
					System.out.println("Please retry with a valid birth date: " + e.getMessage());
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
					System.out.println("Please retry with a positive salary");
					salary = 0;
				}
			} catch (NumberFormatException e) {
				System.out.println("Please retry with a valid float salary: " + e.getMessage());
			}
		} while (salary == 0);

		// Create an Employee object
		emp = new Employee(id, firstName, lastName, birthDate, salary);
		return emp;
	}
}