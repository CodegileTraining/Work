package com.codegile.week2.extra.problem1.exceptions;

/**
 * To be thrown when an id being searched for is found to be non-existent.
 */
public class IdNotFoundException extends InvalidIdException {
  private static final long serialVersionUID = 1L;

  public IdNotFoundException(int id) {
    super(id, "id not found.");
  }
 
}
