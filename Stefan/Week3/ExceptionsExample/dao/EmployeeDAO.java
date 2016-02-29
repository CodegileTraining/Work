package com.example.dao;

import com.example.model.Employee;
/**
 * Employee DAO principle Interface 
 * @author Stefan
 *
 */
public interface EmployeeDAO {

	/**
	 * Adds the parameter of type Employee to a list of employees
	 * @param emp
	 * @throws ArrayIndexOutOfBoundsException
	 */
    public void add(Employee emp) throws ArrayIndexOutOfBoundsException;
/**
 * Replace an existing employee from the list with the Employee type parameter
 * @param emp
 * @throws ArrayIndexOutOfBoundsException
 */
    public void update(Employee emp)throws ArrayIndexOutOfBoundsException;
/**
 * Delete an existing employee  from the employes list
 * The id of the employee to be deleted is passed as parameter
 * @param id
 * @throws ArrayIndexOutOfBoundsException
 */
    public void delete(int id)throws ArrayIndexOutOfBoundsException;
/**
 * Finds and returns an employee from the list if exists
 * @param id
 * @return An Employee object if such employee with the given id exists in the list 
 * @throws ArrayIndexOutOfBoundsException
 */
    public Employee findById(int id)throws ArrayIndexOutOfBoundsException;
/**
 * 
 * @return The list of employees 
 */
    public Employee[] getAllEmployees();
    
}