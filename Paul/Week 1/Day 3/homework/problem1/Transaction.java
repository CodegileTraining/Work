package com.codegile.week1.day3.homework.problem1;

public class Transaction {

  private Database db;
  private int shirtId;
  private TransactionType type;
  private int quantity;

  public Transaction(Database db, int shirtId, TransactionType type, int quantity) {
    this.db = db;
    this.shirtId = shirtId;
    this.type = type;
    this.quantity = quantity;

    executeTransaction();
  }

  private void executeTransaction() {
    switch (type) {
    default:

    case RESTOCK:
      try {
        db.addShirts(db.getShirtById(shirtId), quantity);
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
      }
      break;

    case SALE:
      try {
        db.removeShirts(db.getShirtById(shirtId), quantity);
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
      }
      break;
    }
  }

}
