package com.codegile.week2.extra.problem1.exceptions;

/**
 * To be thrown when an invalid employee id is encountered.
 */
public class InvalidIdException extends EmployeeException {
  private static final long serialVersionUID = 1L;

  /**
   * Constructs with basic invalid id message.
   * 
   * @param id The id found to be invalid.
   */
  public InvalidIdException(int id) {
    super("Invalid id : " + id);
  }

  /**
   * Constructs with possibility of specifying exception details through a String.
   * 
   * @param id The id found to be invalid.
   * @param message Extra exception specifications.
   */
  public InvalidIdException(int id, String message) {
    super("Invalid id [" + id + "] " + message);
  }

}
