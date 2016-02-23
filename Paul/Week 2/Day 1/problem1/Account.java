package com.codegile.week2.day1.problem1;

import java.text.DecimalFormat;
import java.time.LocalDate;

public abstract class Account {

  private double balance;
  private Client owner;
  private LocalDate creationDate;

  public Account(Client owner) {
    this.owner = owner;
    creationDate = LocalDate.now();
  }

  public Account(Client owner, double initialBalance) {
    this(owner);
    balance = initialBalance;
  }

  public Client getOwner() {
    return owner;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public double getBalance() {
    return balance;
  }

  public void overrideCreationDate(LocalDate d) {
    creationDate = d;
  }

  public void increaseBalance(double sum) {
    try {
      if (sum <= 0) {
        throw new InvalidSumException(sum);
      }
      balance += sum;
    }
    catch (InvalidSumException e) {
      System.err.println(e.getMessage());
    }
  }

  public void decreaseBalance(double sum) {
    try {
      if (sum <= 0 || sum > balance) {
        throw new InvalidSumException(sum);
      }
      balance -= sum;
    }
    catch (InvalidSumException e) {
      System.err.println(e.getMessage());
    }
  }

  @Override
  public String toString() {
    String text = "Owner : " + owner + "\n";
    text += "Creation date : " + creationDate + "\n";
    text += "Current balance : " + new DecimalFormat("$##.##").format(balance);
    return text;
  }

  public abstract void deposit(double sum);

  public abstract void withdraw(double sum);

  public abstract void printReport();

}
