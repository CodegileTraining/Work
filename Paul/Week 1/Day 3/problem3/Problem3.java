package com.codegile.week1.day3.problem3;

import java.util.Deque;
import java.util.LinkedList;

import com.codegile.week1.day3.res.StringReader;

/*
 * Se foloseste o structura de tipul Deque ca stiva pentru a testa ca parantezele rotunde se inchid corect
 * intr-o expresie data de un String. Se citesc mai multe expresii dintr-un fisier, considerate constante.
 */

public class Problem3 {

  private static String isValid(String exp) {
    Deque<Object> stack = new LinkedList<>();

    for (char c : exp.toCharArray()) {
      switch (c) {

      case '(':
        stack.push(new Object());
        break;

      case ')':
        if (stack.isEmpty()) {
          return "invalid";
        }
        stack.pop();
        break;

      default:
        continue;
      }
    }

    return stack.isEmpty() ? "valid" : "invalid";
  }

  public static void main(String[] args) {
    String[] expressions = StringReader.getLines("fisier3.in");

    for (String exp : expressions) {
      System.out.println(exp + " -> " + isValid(exp));
    }
  }

}
