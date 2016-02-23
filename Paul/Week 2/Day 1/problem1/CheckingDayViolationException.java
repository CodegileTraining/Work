package com.codegile.week2.day1.problem1;

public class CheckingDayViolationException extends BankException {
  private static final long serialVersionUID = 1L;

  public CheckingDayViolationException(int checkDay, int today) {
    super("Checking day violation : " + checkDay + ". Today is : " + today);
  }

}
