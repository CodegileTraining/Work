package com.codegile.week2.day1.problem1;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class CheckingAccount extends Account {

  private final int checkingDay;
  private int increasePercent = 2;
  private LocalDate lastCheck;

  public CheckingAccount(Client owner, int checkingDay) {
    super(owner);
    this.checkingDay = checkingDay;
    lastCheck = LocalDate.now();
  }

  public CheckingAccount(Client owner, int checkingDay, double initialBalance) {
    super(owner, initialBalance);
    this.checkingDay = checkingDay;
    lastCheck = LocalDate.now();
  }

  @Override
  public void deposit(double sum) {
    checkAccount();
    increaseBalance(sum);
  }

  private void checkAccount() {
    LocalDate d = LocalDate.now();
    long daysSinceLast = ChronoUnit.DAYS.between(lastCheck, d);
    double multiply = ((double) increasePercent) / 100;

    for (int i = 0; i < daysSinceLast; i++) {
      increaseBalance(multiply * getBalance());
    }

    lastCheck = d;
  }

  @Override
  public void withdraw(double sum) {
    checkAccount();
    LocalDate d = LocalDate.now();
    try {
      if (d.getDayOfMonth() != checkingDay) {
        throw new CheckingDayViolationException(checkingDay, d.getDayOfMonth());
      }
      decreaseBalance(sum);
    }
    catch (CheckingDayViolationException e) {
      System.err.println(e.getMessage());
    }
  }

  @Override
  public void overrideCreationDate(LocalDate d) {
    lastCheck = d;
    super.overrideCreationDate(d);
  }

  @Override
  public void printReport() {
    checkAccount();
    System.out.println("Checking Account");
    System.out.println("Checking Day : " + checkingDay);
    System.out.println(super.toString());
    System.out.println();
  }

}
