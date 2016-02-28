package com.codegile.week2.extra.problem1.exceptions;

/**
 * To be thrown when operations are executed which require the existence of objects in the data retention structure
 * (when the database is empty).
 */
public class CapacityZeroException extends EmployeeException {
  private static final long serialVersionUID = 1L;

  public CapacityZeroException() {
    super("Database is empty.");
  }

}
