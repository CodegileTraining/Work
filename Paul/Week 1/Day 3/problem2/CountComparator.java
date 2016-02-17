package com.codegile.week1.day3.problem2;

import java.util.Comparator;

public class CountComparator implements Comparator<ProductCount> {

  @Override
  public int compare(ProductCount o1, ProductCount o2) {
    return o1.p.compareTo(o2.p);
  }

}
