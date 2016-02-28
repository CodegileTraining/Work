package com.codegile.week2.extra.problem1.exceptions;

/**
 * To be thrown when the data retention capacity is reached.
 */
public class CapacityLimitReachedException extends EmployeeException {
  private static final long serialVersionUID = 1L;

  public CapacityLimitReachedException() {
    super("Database capacity limit reached.");
  }

}
