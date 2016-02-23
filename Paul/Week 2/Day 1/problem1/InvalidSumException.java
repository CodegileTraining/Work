package com.codegile.week2.day1.problem1;

public class InvalidSumException extends BankException {
  private static final long serialVersionUID = 1L;

  public InvalidSumException(double sum) {
    super("Invalid sum : " + sum);
  }

}
