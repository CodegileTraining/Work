package com.codegile.week1.day3.problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codegile.week1.day3.res.StringReader;

/*
 * Se da o lista de coduri de produse (codurile sunt sub forma 1s01 1s02 1m01 etc) si o descriere a fiecarui cod sub forma "tricou albastru 1s01",
 * "tricou negru 1s02". Se creaza un program eficient pentru obtinerea unui raport ce cuprinde descrierea fiecarui produs si numarul de aparitii
 * in lista de coduri. Raportul este ordonat alfabetic dupa descriere (folosind Comparable si Comparator).
 */

public class Problem2 {

  static List<Product> products = new ArrayList<>();

  static void readProducts() {
    String[] lines = StringReader.getLines("fisier2.in");

    for (String line : lines) {
      String descript = line.substring(0, line.lastIndexOf(" "));
      String code = line.substring(line.lastIndexOf(" ") + 1);

      if (codeAvailable(code)) {
        products.add(new Product(code, descript));
      }
      else {
        System.out.println("Code unavailable!");
      }
    }
  }

  private static boolean codeAvailable(String code) {
    return productWithCode(code) == null;
  }

  private static Product productWithCode(String code) {
    for (Product p : products) {
      if (p.hasCode(code)) {
        return p;
      }
    }
    return null;
  }

  static void sort() {

  }

  static void printReport() {
    String[] lines = StringReader.getLines("fisier2b.in");
    HashMap<Product, Integer> database = new HashMap<>();

    for (String line : lines) {
      String[] codes = line.split(" ");
      for (String code : codes) {
        Product p = productWithCode(code);
        if (!database.containsKey(p)) {
          database.put(p, 1);
        }
        else {
          database.put(p, database.get(p) + 1);
        }
      }
    }

    List<ProductCount> productCount = new ArrayList<>();

    for (Map.Entry<Product, Integer> entry : database.entrySet()) {
      productCount.add(new ProductCount(entry.getKey(), entry.getValue()));
    }
    productCount.sort(new CountComparator());

    for (ProductCount pc : productCount) {
      System.out.println(pc.p + " -> " + pc.c + " times;");
    }
  }

  public static void main(String[] args) {
    readProducts();
    for (Product p : products) {
      System.out.println(p);
    }
    System.out.println();
    printReport();
  }

}
