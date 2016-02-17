package com.codegile.week1.day3.homework.problem1;

public class BadQuantityException extends Exception {
  private static final long serialVersionUID = 1L;

  public BadQuantityException(int inserted) {
    super("Invalid quantity : " + inserted);
  }

  public BadQuantityException(int requested, int existing) {
    super("Invalid quantity : " + requested + " (" + existing + " exist)");
  }

}
