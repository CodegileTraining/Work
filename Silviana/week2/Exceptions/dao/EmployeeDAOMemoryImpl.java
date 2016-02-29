package com.example.dao;

import com.example.model.Employee;
import com.example.test.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOMemoryImpl implements EmployeeDAO {

	private static Employee[] employeeArray = new Employee[10];

	/**
	 * Package level access.
	 */
	EmployeeDAOMemoryImpl() {
	}

	/**
	 * Add an Employee record.
	 * 
	 * @param emp
	 *            Returns a vector of Employees.
	 */
	public void add(Employee emp) {
		employeeArray[emp.getId()] = emp;
	}

	/**
	 * Update an Employee record/
	 * 
	 * @param emp
	 *            Returns a vector of Employees.
	 */
	public void update(Employee emp) {
		employeeArray[emp.getId()] = emp;
	}

	/**
	 * Delete an employee record that has this ID
	 * 
	 * @param id
	 *            The id for the Employee we want to delete.
	 */
	public void delete(int id) {
		employeeArray[id] = null;
	}

	/**
	 * Find an Employee record using this ID
	 * 
	 * @param id
	 *            The id for the Employee we want to find.
	 */
	public Employee findById(int id) throws EmployeeNotFoundException {
		return employeeArray[id];
	}

	/**
	 * Return an array of all of the Employee records We are using a collection
	 * List object to store the results This makes it easier to just add to the
	 * collection
	 */
	public Employee[] getAllEmployees() {
		List<Employee> emps = new ArrayList<>();
		/**
		 * We use emps to iterate through the memory array and find Employee
		 * objects
		 */
		for (Employee e : employeeArray) {
			if (e != null) {
				emps.add(e);
			}
		}
		return emps.toArray(new Employee[0]);
	}
}
