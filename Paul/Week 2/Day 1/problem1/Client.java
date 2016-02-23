package com.codegile.week2.day1.problem1;

import java.util.*;

public class Client {

  private String name;
  private List<Account> accounts = new ArrayList<>();

  public Client(String name) {
    this.name = name;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  @Override
  public String toString() {
    return name;
  }

  public void addAccount(Account a) {
    accounts.add(a);
  }

}
