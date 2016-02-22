package com.codegile.week1.extra.problem3;

public class Woodwind extends Wind {

  @Override
  public void play() {
    System.out.println("Played woodwind instrument.");
  }

  @Override
  public String what() {
    return "Woodwind instrument";
  }

}
