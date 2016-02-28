package com.codegile.week2.extra.problem1.exceptions;

/**
 * To be thrown when an employee object is found to have an invalid name.
 */
public class InvalidNameException extends EmployeeException {
  private static final long serialVersionUID = 1L;

  public InvalidNameException(String name) {
    super("Invalid name [" + name + "]");
  }

}
