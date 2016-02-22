package com.codegile.week1.extra.problem3;

public class Percussion implements Instrument {

  @Override
  public void play() {
    System.out.println("Percussion instrument played.");
  }

  @Override
  public String what() {
    return "Percussion instrument";
  }

  @Override
  public void adjust() {
    System.out.println("Adjusted percussion instrument.");
  }

}
