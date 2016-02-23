package com.codegile.week2.day1.problem1;

public class SavingsAccount extends Account {

  private final double withdrawLimit;

  public SavingsAccount(Client owner, double withdrawLimit) {
    super(owner);
    this.withdrawLimit = withdrawLimit;
  }

  public SavingsAccount(Client owner, double withdrawLimit, double initialBalance) {
    super(owner, initialBalance);
    this.withdrawLimit = withdrawLimit;
  }

  @Override
  public void deposit(double sum) {
    increaseBalance(sum);
  }

  @Override
  public void withdraw(double sum) {
    try {
      if (sum > withdrawLimit) {
        throw new WithdrawLimitExceededException(withdrawLimit, sum);
      }
      decreaseBalance(sum);
    }
    catch (WithdrawLimitExceededException e) {
      System.err.println(e.getMessage());
    }
  }

  @Override
  public void printReport() {
    System.out.println("Savings Account");
    System.out.println("Withdraw Limit : " + withdrawLimit);
    System.out.println(super.toString());
    System.out.println();
  }

}
