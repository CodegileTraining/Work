package com.codegile.week2.extra.problem1.dao;

import java.util.ArrayList;
import java.util.List;

import com.codegile.week2.extra.problem1.exceptions.*;
import com.codegile.week2.extra.problem1.model.Employee;

/**
 * An implementation of the employee DAO interface.
 */
public class EmployeeDAOMemoryImpl implements EmployeeDAO {

  private int size = 0;
  // not thread-safe
  private static Employee[] employeeArray = new Employee[10];

  // package level access
  EmployeeDAOMemoryImpl() {
  }

  // Add an Employee record
  public void add(Employee emp) throws InvalidIdException, InvalidNameException, CapacityLimitReachedException {
    if (size == employeeArray.length) {
      throw new CapacityLimitReachedException();
    }

    int id = emp.getId();

    try {
      if (findById(id) != null)
        throw new UnavailableIdException(id);
    }
    catch (IdNotFoundException | CapacityZeroException e) {
    }
    catch (InvalidIdException e) {
      throw e;
    }

    String first = emp.getFirstName();

    if (!first.matches("[a-zA-Z]+")) {
      throw new InvalidNameException(first);
    }

    String last = emp.getLastName();

    if (!last.matches("[a-zA-Z]+")) {
      throw new InvalidNameException(last);
    }
  }

  // Update an employee record
  public void update(Employee emp) {
    employeeArray[emp.getId()] = emp;
  }

  // Delete an employee record that has this ID
  public void delete(int id) throws InvalidIdException, CapacityZeroException {
    if (size == 0) {
      throw new CapacityZeroException();
    }

    try {
      findById(id);
    }
    catch (InvalidIdException e) {
      throw e;
    }
    employeeArray[id] = null;
    size--;
  }

  // Find an Employee record using this ID
  public Employee findById(int id) throws InvalidIdException, CapacityZeroException {
    if (size == 0) {
      throw new CapacityZeroException();
    }
    if (id >= employeeArray.length) {
      throw new IdExceedsCapacityException(id, employeeArray.length - 1);
    }

    Employee emp;

    try {
      emp = employeeArray[id];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      throw new InvalidIdException(id);
    }
    if (emp == null)
      throw new IdNotFoundException(id);

    return emp;

  }

  // Return an array of all of the Employee records
  // We are using a collection List object to store the results
  // This makes it easier to just add to the collection
  public Employee[] getAllEmployees() throws CapacityZeroException {
    if (size == 0) {
      throw new CapacityZeroException();
    }

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
