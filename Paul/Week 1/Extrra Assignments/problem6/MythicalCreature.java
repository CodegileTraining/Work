package com.codegile.week1.extra.problem6;

import java.util.Random;

public class MythicalCreature extends Creature implements HighlyMobile {

  public MythicalCreature(String name) {
    super(name);
  }

  @Override
  public void walk() {
    System.out.println(myName() + " walking");
  }

  @Override
  public void step() {
    System.out.println(myName() + " taking a step");
  }

  @Override
  public void run() {
    System.out.println(myName() + " running");
  }

  @Override
  public void sprint() {
    System.out.println(myName() + " sprinting");
  }

  @Override
  public void fly() {
    System.out.println(myName() + " flying");
    land();
  }

  @Override
  public void land() {
    System.out.println(myName() + " landed");
  }

  @Override
  public void move() {
    Random rand = new Random();

    int move = rand.nextInt(5);

    switch (move) {
    default:
    case 0:
      walk();
      break;
    case 1:
      step();
      break;
    case 2:
      run();
      break;
    case 3:
      sprint();
      break;
    case 4:
      fly();
      break;
    }
  }

}
