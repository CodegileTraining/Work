package com.codegile.week1.extra.problem3;

public class Wind implements Instrument {

  @Override
  public void play() {
    System.out.println("Wind instrument played.");
  }

  @Override
  public String what() {
    return "Wind instrument";
  }

  @Override
  public void adjust() {
    System.out.println("Adjusted wind instrument.");
  }

}
