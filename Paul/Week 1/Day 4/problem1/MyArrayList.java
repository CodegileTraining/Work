package com.codegile.week1.day4.problem1;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList<T> extends ArrayList<T> {
  private static final long serialVersionUID = 1L;

  public Iterator<T> simpleIterator() {
    return new SimpleIterator<>(this);
  }

  public Iterator<T> twoByTwoIterator() {
    return new TwoByTwoIterator<>(this);
  }

  public Iterator<T> firstLastIterator() {
    return new FirstLastIterator<>(this);
  }

  private static void print(Iterator<?> it) {
    while (it.hasNext()) {
      System.out.print(it.next() + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    MyArrayList<Integer> array = new MyArrayList<>();

    array.add(1);
    array.add(2);
    array.add(3);
    array.add(4);
    array.add(5);
    array.add(6);
    array.add(7);
    array.add(8);
    array.add(9);
    array.add(10);

    Iterator<Integer> it = array.simpleIterator();
    print(it);

    System.out.println();

    // Even number of elements
    it = array.twoByTwoIterator();
    print(it);

    it = array.firstLastIterator();
    print(it);

    System.out.println();

    // Odd number of elements
    array.add(11);

    it = array.twoByTwoIterator();
    print(it);

    it = array.firstLastIterator();
    print(it);
  }

}
