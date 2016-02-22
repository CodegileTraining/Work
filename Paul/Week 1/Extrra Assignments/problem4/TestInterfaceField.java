package com.codegile.week1.extra.problem4;

public class TestInterfaceField {

  public static void main(String[] args) {

    // Static

    @SuppressWarnings("unused")
    String s = MyInterface.field;

    // Final

    // MyInterface.field = new String(); // Illegal

  }

}
