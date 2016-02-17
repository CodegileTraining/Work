package com.codegile.week1.day3.problem2;

public class ProductCount implements Comparable<ProductCount> {

  Product p;
  int c;

  public ProductCount(Product p, int c) {
    this.p = p;
    this.c = c;
  }

  @Override
  public int compareTo(ProductCount o) {
    return p.compareTo(o.p);
  }

}
