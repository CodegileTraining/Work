package com.codegile.week1.day4.problem2;

import java.time.LocalDate;
import java.time.Month;

public abstract class Perk {

  private LocalDate date;
  protected String descript;
  private Employee accordedTo;

  Perk(LocalDate date) {
    this.date = date;
  }

  public Month getMonth() {
    return date.getMonth();
  }

  public int getYear() {
    return date.getYear();
  }

  public void isAccordedToEmployee(Employee e) {
    accordedTo = e;
  }

  @Override
  public String toString() {
    return descript + " accorded to " + accordedTo + " on " + date;
  }

}
