package com.codegile.week1.extra.problem1;

import java.util.*;

public class FindDuplicates {

  public static void main(String[] args) {
    SortedSet<String> s = new TreeSet<String>(new CaseInsensitiveComparator());

    for (String a : args) {
      if (!s.add(a.toLowerCase())) {
        System.out.println("Duplicate detected: " + a);
      }
    }

    System.out.println(s.size() + " distinct words: " + s);
  }

}