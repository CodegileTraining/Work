package com.codegile.week1.day3.homework.problem1;

public class Shirt {

  private static int nextId = 1;

  private int id;
  private String descript;
  private Color color;
  private Size size;

  public Shirt(String descript, Color color, Size size) {
    id = nextId++;
    this.descript = descript;
    this.color = color;
    this.size = size;
  }

  public Integer getId() {
    return id;
  }

  public String getDescript() {
    return descript;
  }

  @Override
  public String toString() {
    String text = "";

    text += "[" + id + "] " + descript + " - " + color + " (" + size + ")";

    return text;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((color == null) ? 0 : color.hashCode());
    result = prime * result + ((descript == null) ? 0 : descript.hashCode());
    result = prime * result + ((size == null) ? 0 : size.hashCode());
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
    Shirt other = (Shirt) obj;
    if (color != other.color)
      return false;
    if (descript == null) {
      if (other.descript != null)
        return false;
    }
    else if (!descript.equals(other.descript))
      return false;
    if (size != other.size)
      return false;
    return true;
  }

  public boolean hasId(int id) {
    return this.id == id;
  }

}
