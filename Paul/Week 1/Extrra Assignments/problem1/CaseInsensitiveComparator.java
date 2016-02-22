package com.codegile.week1.extra.problem1;

import java.util.Comparator;

public class CaseInsensitiveComparator implements Comparator<String> {

  @Override
  public int compare(String o1, String o2) {
    return o1.toLowerCase().compareTo(o2.toLowerCase());
  }

}
