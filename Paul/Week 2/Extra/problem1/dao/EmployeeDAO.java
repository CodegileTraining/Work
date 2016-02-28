package com.codegile.week2.extra.problem1.dao;

import com.codegile.week2.extra.problem1.exceptions.*;
import com.codegile.week2.extra.problem1.model.Employee;

/**
 * To be implemented by class acting as a data access object for employee entries.
 */
public interface EmployeeDAO {

  /**
   * Adds a new employee to the access object.
   * 
   * @param emp Employee to add.
   * @throws InvalidIdException when the provided employee has an unavailable or invalid id.
   * @throws InvalidNameException when the provided employee has an invalid first or last name.
   * @throws CapacityLimitReachedException when the access object's container is full.
   */
  public void add(Employee emp) throws InvalidIdException, InvalidNameException, CapacityLimitReachedException;

  /**
   * Updates an existing employee. Skips all object validation if the DAO's container is full.
   * 
   * @param emp The employee object containing the id of the object to be changed, and the new values.
   * @throws InvalidIdException when the provided employee's id is non-existent or invalid.
   * @throws CapacityZeroException when the access object's container is empty.
   */
  public void update(Employee emp) throws InvalidIdException, CapacityZeroException;

  /**
   * Deletes the employee having the provided id. Skips searching if the DAO's container is empty.
   * 
   * @param id The id to search for.
   * @throws InvalidIdException When id is invalid or not found.
   * @throws CapacityZeroException When the access object's container is empty.
   */
  public void delete(int id) throws InvalidIdException, CapacityZeroException;

  /**
   * Returns the employee having the provided id. Skips searching if the DAO's container is empty.
   * 
   * @param id The id to search for.
   * @return The employee with the given id.
   * @throws InvalidIdException
   * @throws CapacityZeroException
   */
  public Employee findById(int id) throws InvalidIdException, CapacityZeroException;

  /**
   * Returns an array with all employees in the access object's container if the container is not empty.
   * 
   * @return An array with the employees.
   * @throws CapacityZeroException When the access object's container is empty.
   */
  public Employee[] getAllEmployees() throws CapacityZeroException;

}