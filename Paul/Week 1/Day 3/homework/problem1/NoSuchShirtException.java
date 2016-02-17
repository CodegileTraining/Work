package com.codegile.week1.day3.homework.problem1;

public class NoSuchShirtException extends Exception {
  private static final long serialVersionUID = 1L;

  public NoSuchShirtException(int id) {
    super("No shirt exists with id : " + id);
  }

}
