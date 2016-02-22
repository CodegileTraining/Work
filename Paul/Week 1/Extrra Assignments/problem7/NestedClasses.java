package com.codegile.week1.extra.problem7;

public class NestedClasses {

  private String outField = "Outer class private field";

  class InnerClass {

    private String inField = "Inner class private field";

    void foo() {
      System.out.println(outField); // Access granted
    }

  }

  void bar() {
    InnerClass c = new InnerClass();

    System.out.println(c.inField); // Access granted

    c.foo();
  }

  public static void main(String[] args) {
    new NestedClasses().bar();
  }

}
