package com.example.dao;

import com.example.model.Employee;
import java.util.ArrayList;
import java.util.List;
/**
 * Implementation Class for Employee type objects 
 * Contains a list of employees and methods for add,update,delete,find and return the entire list 
 * @author Stefan
 *
 */
public class EmployeeDAOMemoryImpl implements EmployeeDAO {

    // not thread-safe
    private static Employee[] employeeArray = new Employee[10];

    // package level access
    EmployeeDAOMemoryImpl() {
    }

    // Add an Employee record
    /**
     * This method adds a given Employee type object to the employee list
     * Throws ArrayIndexOutOfBoundsException if the id of the Employee parameter is bigger than 
     * the length of the list
     */
    public void add(Employee emp) throws ArrayIndexOutOfBoundsException{ 
    
        employeeArray[emp.getId()] = emp;
    }

    // Update an employee recordu
    /**
     * Replace an employee from the list with the Employee type parameter
     */
    public void update(Employee emp) {
        employeeArray[emp.getId()] = emp;
    }

    // Delete an employee record that has this ID
    /**
     * Replaces an employee from the employees list with null
     * The id of the employee to be deletes is given as int parameter
     * 
     */
    public void delete(int id) throws ArrayIndexOutOfBoundsException {
        employeeArray[id] = null;
    }

    // Find an Employee record using this ID
    /**
     * Returns the employee with the id given as parameter ,if exists
     * Throws ArrayIndexOutOfBoundsException otherwise
     */
    public Employee findById(int id) throws ArrayIndexOutOfBoundsException{
        return employeeArray[id];
    }

    // Return an array of all of the Employee records
    // We are using a collection List object to store the results
    // This makes it easier to just add to the collection
    /**
     * Return the list of employees as array
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
