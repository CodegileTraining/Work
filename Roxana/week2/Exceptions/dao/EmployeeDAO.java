package dao;

import model.Employee;

public interface EmployeeDAO {

	/**
	 * Add an Employee record
	 * 
	 * @param emp
	 *            Employee to add
	 */
	public void add(Employee emp);

	/**
	 * Update an employee record
	 * 
	 * @param emp
	 *            The employee for which we update information
	 */

	public void update(Employee emp);

	/**
	 * Delete an employee record that has this ID
	 * 
	 * @param id
	 *            The id to search the Employee
	 */

	public void delete(int id);

	/**
	 * Find an Employee record using this ID
	 * 
	 * @param id
	 *            The id to search the Employee
	 * @return The employee who has the id
	 */
	public Employee findById(int id);

	/**
	 * Return an array of all of the Employee records. We are using a collection
	 * List object to store the results. This makes it easier to just add to the
	 * collection
	 * 
	 * @return An array of all of the Employee records
	 */
	public Employee[] getAllEmployees();

}