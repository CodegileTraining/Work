package com.codegile.week1.day3.homework.problem1;

import java.util.Comparator;

public class ComparatorByDescript implements Comparator<ShirtCount> {

  @Override
  public int compare(ShirtCount o1, ShirtCount o2) {
    return o1.s.getDescript().compareTo(o2.s.getDescript());
  }

}
