package com.codegile.week2.extra.problem1.dao;

/**
 * Factory-type class that will provide data access objects for employees.
 */
public class EmployeeDAOFactory {

  /**
   * Returns a new DAO for employees.
   * 
   * @return Employee DAO.
   */
  public EmployeeDAO createEmployeeDAO() {
    return new EmployeeDAOMemoryImpl();
  }

}