package dao;

import model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOMemoryImpl implements EmployeeDAO {

	// not thread-safe
	private static Employee[] employeeArray = new Employee[10];

	/**
	 * Package level access
	 */
	EmployeeDAOMemoryImpl() {
	}

	/**
	 * Add an Employee record
	 * 
	 * @param emp
	 *            Employee to add
	 */
	public void add(Employee emp) {
		try {
			if (findById(emp.getId()) != null) {
				throw new Exception("Id already exists!");
			}
			if (emp.getFirstName().matches("[A-Za-Z]+"))
				throw new Exception("Invalid first name!");
			if (emp.getLastName().matches("[A-Za-Z]+"))
				throw new Exception("Invalid last name!");
			employeeArray[emp.getId()] = emp;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Update an employee record
	 * 
	 * @param emp
	 *            The employee for which we update information
	 */

	public void update(Employee emp) {
		try {
			if (findById(emp.getId()) != null)
				throw new Exception("Id already exists!");
			if (emp.getFirstName().matches("[A-Za-Z]+"))
				throw new Exception("Invalid first name!");
			if (emp.getLastName().matches("[A-Za-Z]+"))
				throw new Exception("Invalid last name!");
			employeeArray[emp.getId()] = emp;
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	/**
	 * Delete an employee record that has this ID
	 * 
	 * @param id
	 *            The id to search the Employee
	 */

	public void delete(int id) {
		try {

			if (findById(id) == null)
				throw new Exception("Invalid id!");
			employeeArray[id] = null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Find an Employee record using this ID
	 * 
	 * @param id
	 *            The id to search the Employee
	 * @return The employee who has the id
	 */
	public Employee findById(int id) {
		return employeeArray[id];
	}

	/**
	 * Return an array of all of the Employee records. We are using a collection
	 * List object to store the results. This makes it easier to just add to the
	 * collection
	 * 
	 * @return An array of all of the Employee records
	 */
	public Employee[] getAllEmployees() {
		List<Employee> emps = new ArrayList<>();
		// Iterate through the memory array and find Employee objects
		for (Employee e : employeeArray) {
			if (e != null) {
				emps.add(e);
			}
		}
		return emps.toArray(new Employee[0]);
	}
}
