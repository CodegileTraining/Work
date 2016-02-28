package com.codegile.week2.extra.problem1.exceptions;

/**
 * To be thrown when a chosen id exceeds the maximum value permitted.
 */
public class IdExceedsCapacityException extends InvalidIdException {
  private static final long serialVersionUID = 1L;

  public IdExceedsCapacityException(int id, int max) {
    super(id, "id exceeds maximum permitted (" + max + ")");
  }

}
