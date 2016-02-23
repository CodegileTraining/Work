package com.codegile.week2.day1.problem1;

import java.time.LocalDate;
import java.util.*;

public class Bank {

  private List<Account> accounts = new ArrayList<>();
  private Set<Client> clients = new HashSet<>();

  public void addAccount(Account a) {
    accounts.add(a);
    Client c = a.getOwner();
    c.addAccount(a);
    clients.add(c);
  }

  public void printClientReport() {
    for (Client c : clients) {
      System.out.println("CLIENT " + c + "\n");
      List<Account> clAccounts = c.getAccounts();
      for (Account a : clAccounts) {
        a.printReport();
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Bank bank = new Bank();

    Client c0 = new Client("Mark");
    Client c1 = new Client("Angela");
    Client c2 = new Client("Dwight");

    Account a0 = new SavingsAccount(c0, 400, 800);
    Account a1 = new CheckingAccount(c1, 25, 2000);
    Account a2 = new CheckingAccount(c2, 23, 1600);
    Account a3 = new SavingsAccount(c2, 800, 1500);

    bank.addAccount(a0);
    bank.addAccount(a1);
    bank.addAccount(a2);
    bank.addAccount(a3);

    a1.overrideCreationDate(LocalDate.of(2016, 1, 22));
    a1.printReport();

    a0.withdraw(400);
    a0.withdraw(500);
    a0.printReport();

    a1.withdraw(500);
    a1.printReport();

    a2.withdraw(800);
    a2.printReport();

    a3.withdraw(800);
    a3.withdraw(800);
    a3.printReport();

    System.out.println();
    bank.printClientReport();
  }

}
