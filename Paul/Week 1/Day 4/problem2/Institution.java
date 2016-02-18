package com.codegile.week1.day4.problem2;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Institution {

  private static Institution instance;
  private List<Perk> accordedPerks = new ArrayList<>();

  private Institution() {
  }

  public static Institution getInstance() {
    if (instance == null) {
      instance = new Institution();
    }
    return instance;
  }

  public void accordPerkToEmployee(Perk p, Employee e) {
    p.isAccordedToEmployee(e);
    accordedPerks.add(p);
  }

  private Map<Month, List<Perk>> getPerksByMonth(int year) {
    Map<Month, List<Perk>> perksByMonth = new HashMap<>();

    for (Perk p : accordedPerks) {
      if (p.getYear() == year) {
        List<Perk> current = perksByMonth.get(p.getMonth());

        if (current == null) {
          current = new ArrayList<>();
        }

        current.add(p);
        perksByMonth.put(p.getMonth(), current);
      }
    }

    return perksByMonth;
  }

  public void printPerkReportForYear(int year) {
    Map<Month, List<Perk>> perksByMonth = getPerksByMonth(year);

    System.out.println("Report for year " + year);
    System.out.println();

    for (Month m : Month.values()) {
      List<Perk> current = perksByMonth.get(m);

      if (current == null) {
        continue;
      }

      System.out.println(m);
      for (Perk p : current) {
        System.out.println(p);
      }

      System.out.println();
    }

    System.out.println();
  }

}
