package com.codegile.week1.extra.problem3;

public class InstrumentTesting {

  public static void main(String[] args) {
    Instrument i;

    i = new Percussion();

    System.out.println("Testing a " + i.what());
    i.adjust();
    i.play();

    i = new Woodwind();
    Wind w = (Wind) i;
    System.out.println("Testing a " + w.what());
    w.adjust();
    w.play();

    w = new Brass();
    System.out.println("Testing a " + w.what());
    w.adjust();
    w.play();

  }

}
