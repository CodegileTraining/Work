package com.codegile.week1.day4.problem1;

import java.util.ArrayList;
import java.util.Iterator;

public class SimpleIterator<T> implements Iterator<T> {

  private int i = 0;
  private ArrayList<T> array;

  public SimpleIterator(ArrayList<T> array) {
    this.array = array;
  }

  @Override
  public boolean hasNext() {
    return i < array.size();
  }

  @Override
  public T next() {
    return array.get(i++);
  }

}
