package com.codegile.week2.extra.problem1.exceptions;

/**
 * To be thrown when an id is contextually unavailable.
 */
public class UnavailableIdException extends InvalidIdException {
  private static final long serialVersionUID = 1L;

  public UnavailableIdException(int id) {
    super(id, "id is unavailable.");
  }

}
