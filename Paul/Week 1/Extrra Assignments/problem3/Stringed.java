package com.codegile.week1.extra.problem3;

public class Stringed implements Instrument {

  @Override
  public void play() {
    System.out.println("String instrument played.");
  }

  @Override
  public String what() {
    return "Stringed instrument";
  }

  @Override
  public void adjust() {
    System.out.println("Adjusted stringed instrument.");
  }

}
