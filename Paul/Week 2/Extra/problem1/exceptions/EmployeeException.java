package com.codegile.week2.extra.problem1.exceptions;

/**
 * Superclass for all project-specific exception classes.
 */
public class EmployeeException extends Exception {
  private static final long serialVersionUID = 1L;

  public EmployeeException(String message) {
    super(message);
  }

}
