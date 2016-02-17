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
    
    /*
    * "shirts.in" contents
    * format : description, color, size, quantity
    *
    * sport time, Blue, S, 15
    * sport time, Blue, L, 4
    * sport time, Blue, XXL, 5
    * easy summer breeze, Black, L, 8
    * easy summer breeze, Gray, S, 20
    * easy summer breeze, Gray, XXL, 11
    * easy summer breeze, Gray, XXL, 4
    * comfortable wear, Red, XL, 15
    * comfortable wear, Yellow, XXL, 20
    * comfortable wear, Black, L, 10
    * nice casual, Green, L, 10
    * nice casual, Orange, L, 10
    * nice casual, Orange, XL, 10
    */

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
