package com.codegile.week1.day3.homework.problem1;

/*
 * Fie un magazin de tricouri. Fiecare tricou este caracterizat prin culoare, descriere, id, marime, nr de bucati.
 * Tricourile intra (se achizitioneaza) sau ies (se vand din magazin). Dorim sa facem un inventar al tricourilor
 * si sa tiparim la consola raportul rezultat dupa un anumit numar de tranzactii.
 * Fiecare tranzactie este caracterizata prin id-ul tricoului, tipul tranzactiei si numar bucati tranzactionate.
 * Dorim doua rapoarte, unul in ordine crescatoare a numarului de bucati, altul in ordine alfabetica a descrierii.
 * Observatii :
 * Se doreste implementare cat mai eficienta d.p.d.v. al colectiilor;
 * Se doreste tratarea exceptiilor (la nivel minimal).
 */

public class ShirtShop {

  public static void main(String[] args) {
    Database myDatabase = new Database();
    myDatabase.importShirtsFromFile("shirts.in");
    myDatabase.printReport();
    System.out.println();

    // Valid
    new Transaction(myDatabase, 10, TransactionType.SALE, 8);
    new Transaction(myDatabase, 8, TransactionType.RESTOCK, 10);

    // Invalid
    new Transaction(myDatabase, 25, TransactionType.SALE, 10);
    new Transaction(myDatabase, 25, TransactionType.RESTOCK, 10);
    new Transaction(myDatabase, 7, TransactionType.SALE, 50);
    new Transaction(myDatabase, 7, TransactionType.SALE, -50);
    new Transaction(myDatabase, 7, TransactionType.RESTOCK, -50);
    System.out.println();

    myDatabase.printReport(new ComparatorByCount());
    System.out.println();

    myDatabase.printReport(new ComparatorByDescript());
  }

}
