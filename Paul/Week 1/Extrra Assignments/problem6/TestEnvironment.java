package com.codegile.week1.extra.problem6;

public class TestEnvironment {

  static void startWalking(Walker w) {
    w.walk();
  }

  static void startRunning(Runner r) {
    r.run();
  }

  static void startFlying(Flyer f) {
    f.fly();
  }

  static void startMoving(HighlyMobile hm) {
    hm.move();
  }

  public static void main(String[] args) {
    MythicalCreature m = new MythicalCreature("Icarus");

    startWalking(m);

    startRunning(m);

    startFlying(m);

    startMoving(m);
  }

}
