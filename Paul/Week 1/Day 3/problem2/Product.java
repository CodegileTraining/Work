package com.codegile.week1.day3.problem2;

public class Product implements Comparable<Product> {

  private String code;
  private String descript;

  public Product(String code, String descript) {
    this.code = code;
    this.descript = descript;
  }

  public boolean hasCode(String code) {
    return this.code.equals(code);
  }

  public String getCode() {
    return code;
  }

  public String getDescript() {
    return descript;
  }

  @Override
  public String toString() {
    return "Product [" + descript + " (" + code + ")]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((code == null) ? 0 : code.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (code == null) {
      if (other.code != null)
        return false;
    }
    else if (!code.equals(other.code))
      return false;
    return true;
  }

  @Override
  public int compareTo(Product o) {
    return descript.compareTo(o.descript);
  }

}
