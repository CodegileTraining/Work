package com.example.dao;

import com.example.exception.*;
import com.example.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOMemoryImpl implements EmployeeDAO {

    // not thread-safe
    private static Employee[] employeeArray = new Employee[10];
    int size;

    // package level access
    EmployeeDAOMemoryImpl() {
        size = 0;
    }

    // Add an Employee record
    public void add(Employee emp) throws EmployeeExceededException, EmployeeIDTaken, EmployeeInvalidNameException, InvalidIdException {

        if (size == employeeArray.length)
            throw new EmployeeExceededException();
        int id = emp.getId();
        if (id > 10) {
            throw new InvalidIdException();
        }
        if (findById(id) != null) {
            throw new EmployeeIDTaken();
        }

        if (emp.getFirstName().matches("[a-zA-Z]+") || emp.getLastName().matches("[a-zA-Z]+")) {
            throw new EmployeeInvalidNameException();
        }
        employeeArray[emp.getId()] = emp;
        size++;
    }

    // Update an employee record
    public void update(Employee emp) {
        employeeArray[emp.getId()] = emp;
    }

    // Delete an employee record that has this ID
    public void delete(int id) throws NoEmployeesException {
        if(size==0)
            throw new NoEmployeesException();
        employeeArray[id] = null;
    }

    // Find an Employee record using this ID
    public Employee findById(int id) throws InvalidIdException {
        if(id<0||id>10)
            throw new InvalidIdException();
        return employeeArray[id];
    }

    // Return an array of all of the Employee records
    // We are using a collection List object to store the results
    // This makes it easier to just add to the collection
    public Employee[] getAllEmployees() throws NoEmployeesException {
        List<Employee> emps = new ArrayList<>();
        // Iterate through the memory array and find Employee objects
        if(size==0)
            throw new NoEmployeesException();
        for (Employee e : employeeArray) {
            if (e != null) {
                emps.add(e);
            }
        }
        return emps.toArray(new Employee[0]);
    }
}
