package com.codegile.week1.day3.homework.problem1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codegile.week1.day3.res.StringReader;

public class Database {

  private HashMap<Shirt, Integer> shirts = new HashMap<>();

  public void addShirts(Shirt shirt, Integer quantity) throws BadQuantityException {
    if (quantity <= 0) {
      throw new BadQuantityException(quantity);
    }

    Integer newQ = shirts.get(shirt);
    newQ = (newQ == null ? quantity : quantity + newQ);
    shirts.put(shirt, newQ);
  }

  public Shirt getShirtById(int id) throws NoSuchShirtException {
    for (Shirt shirt : shirts.keySet()) {
      if (shirt.hasId(id)) {
        return shirt;
      }
    }
    throw new NoSuchShirtException(id);
  }

  public void removeAllShirts(Shirt shirt) {
    shirts.remove(shirt);
  }

  public void removeShirts(Shirt shirt, Integer quantity) throws BadQuantityException {
    Integer oldQ = shirts.get(shirt);

    if (quantity <= 0) {
      throw new BadQuantityException(quantity);
    }
    if (oldQ == null) {
      throw new BadQuantityException(quantity, 0);
    }
    else if (oldQ < quantity) {
      throw new BadQuantityException(quantity, oldQ);
    }
    else if (oldQ == quantity) {
      removeAllShirts(shirt);
    }
    else {
      shirts.put(shirt, oldQ - quantity);
    }
  }

  public void importShirtsFromFile(String path) {
    String[] lines = StringReader.getLines(path);

    for (String line : lines) {
      String[] components = line.split(", ");
      String descript = components[0];
      Color color = Color.valueOf(components[1]);
      Size size = Size.valueOf(components[2]);
      Integer quantity = Integer.parseInt(components[3]);

      Shirt shirt = new Shirt(descript, color, size);

      try {
        addShirts(shirt, quantity);
      }
      catch (BadQuantityException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public void printReport() {
    printReport(null);
  }

  public void printReport(Comparator<ShirtCount> comp) {
    List<ShirtCount> count = new ArrayList<>();

    for (Map.Entry<Shirt, Integer> entry : shirts.entrySet()) {
      count.add(new ShirtCount(entry.getKey(), entry.getValue()));
    }
    count.sort(comp);

    for (ShirtCount sc : count) {
      System.out.println(sc.s + " : " + sc.c + " on stock.");
    }
  }

}
