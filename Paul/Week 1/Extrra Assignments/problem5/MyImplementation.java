package com.codegile.week1.extra.problem5;

import com.codegile.week1.extra.problem5.interfacepack.MyInterface;

public class MyImplementation implements MyInterface {

  @Override
  public void method1() {
    System.out.println("Method 1");
  }

  @Override
  public void method2() {
    System.out.println("Method 2");
  }

  @Override
  public void method3() { // Failure to mark implemented methods as public results in compiler error
    System.out.println("Method 3");
  }

  public static void main(String[] args) {
    MyInterface i = new MyImplementation();

    // Methods are obviously public

    i.method1();
    i.method2();
    i.method3();
  }

}
