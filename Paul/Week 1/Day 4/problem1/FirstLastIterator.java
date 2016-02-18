package com.codegile.week1.day4.problem1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FirstLastIterator<T> implements Iterator<T> {

  private int i;
  private int j;
  private Switch sw = new Switch();
  private ArrayList<T> array;

  private class Switch {
    boolean flag = true;

    void flip() {
      flag = (flag == false ? true : false);
    }
  }

  public FirstLastIterator(ArrayList<T> array) {
    this.array = array;
    i = 0;
    j = array.size() - 1;
  }

  @Override
  public boolean hasNext() {
    return i <= j;
  }

  @Override
  public T next() {
    try {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
    }
    catch (NoSuchElementException e) {
      e.printStackTrace();
    }

    sw.flip();
    return !sw.flag ? array.get(i++) : array.get(j--);
  }
}
