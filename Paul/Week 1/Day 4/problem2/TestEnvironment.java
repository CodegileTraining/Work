package com.codegile.week1.day4.problem2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestEnvironment {

  public static void main(String[] args) {
    Institution institution = Institution.getInstance();
    List<Employee> employees = new ArrayList<>();

    employees.add(new Employee("Mark"));
    employees.add(new Employee("Paul"));
    employees.add(new Employee("Matt"));
    employees.add(new Employee("Julia"));
    employees.add(new Employee("Hannah"));
    employees.add(new Employee("George"));
    employees.add(new Employee("Maria"));

    institution.accordPerkToEmployee(new Coffee(LocalDate.of(2016, 2, 12)), employees.get(0));
    institution.accordPerkToEmployee(new GiftCard(LocalDate.of(2016, 2, 15)), employees.get(1));
    institution.accordPerkToEmployee(new Laptop(LocalDate.of(2016, 1, 10)), employees.get(2));
    institution.accordPerkToEmployee(new Laptop(LocalDate.of(2016, 1, 21)), employees.get(3));
    institution.accordPerkToEmployee(new GiftCard(LocalDate.of(2015, 12, 11)), employees.get(4));
    institution.accordPerkToEmployee(new Coffee(LocalDate.of(2015, 11, 30)), employees.get(5));
    institution.accordPerkToEmployee(new GiftCard(LocalDate.of(2015, 11, 9)), employees.get(6));
    institution.accordPerkToEmployee(new Coffee(LocalDate.of(2015, 10, 13)), employees.get(0));
    institution.accordPerkToEmployee(new Coffee(LocalDate.of(2014, 8, 12)), employees.get(3));
    institution.accordPerkToEmployee(new Laptop(LocalDate.of(2014, 8, 12)), employees.get(6));

    institution.printPerkReportForYear(2014);

    institution.printPerkReportForYear(2015);

    institution.printPerkReportForYear(2016);
  }

}
