package com.codegile.week2.day1.problem1;

public class WithdrawLimitExceededException extends BankException {
  private static final long serialVersionUID = 1L;

  public WithdrawLimitExceededException(double limit, double sum) {
    super("Exceeded withdraw limit : " + limit + ". Requested : " + sum);
  }

}
