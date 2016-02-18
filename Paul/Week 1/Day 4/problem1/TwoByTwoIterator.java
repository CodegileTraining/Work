package com.codegile.week1.day4.problem1;

import java.util.ArrayList;
import java.util.Iterator;

public class TwoByTwoIterator<T> implements Iterator<T> {

  private int i = 0;
  private ArrayList<T> array;

  public TwoByTwoIterator(ArrayList<T> array) {
    this.array = array;
  }

  @Override
  public boolean hasNext() {
    return i <= array.size() - 1;
  }

  @Override
  public T next() {
    T t = array.get(i);
    i += 2;
    return t;
  }

}
