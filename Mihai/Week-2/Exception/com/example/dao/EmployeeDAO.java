package com.example.dao;

import com.example.exception.*;
import com.example.model.Employee;

/**
 * Interface for EmployeeDAO
 */
public interface EmployeeDAO {

    public void add(Employee emp) throws EmployeeIDTaken, EmployeeInvalidNameException, InvalidIdException, EmployeeExceededException;

    public void update(Employee emp);

    public void delete(int id) throws NoEmployeesException;

    public Employee findById(int id) throws InvalidIdException;

    public Employee[] getAllEmployees() throws NoEmployeesException;

}