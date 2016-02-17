package com.codegile.week1.day3.homework.problem1;

public class ShirtCount implements Comparable<ShirtCount> {

  public Shirt s;
  public Integer c;

  public ShirtCount(Shirt s, Integer c) {
    this.s = s;
    this.c = c;
  }

  @Override
  public int compareTo(ShirtCount o) {
    return s.getId().compareTo(o.s.getId());
  }

}
