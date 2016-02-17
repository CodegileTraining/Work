package com.codegile.week1.day3.problem1;

import java.util.Random;

/*
 * Se genereaza un sir de nr intregi aleatoare intre 0 si 1000. Continutul acestui sir generat se copiaza intr-un alt sir.
 * Se sorteaza sirurile crescator, primul folosind algoritmul Bubble, al doilea algoritmul Quick (sortarea are loc cvasisimultan, adica
 * iteratia k a algoritmului Quick se executa imediat dupa iteratia k a algoritmului Bubble.
 */

public class Problem1 {

  static final int numOfNums = 1000;
  static final Random rand = new Random(17);

  static void print(int[] numbers) {
    for (int i = 1; i < numbers.length + 1; i++) {
      System.out.print(numbers[i - 1] + " ");
      if (i % 200 == 0) {
        System.out.println();
      }
    }
    System.out.println();

  }

  static boolean bubbleSortStep(int[] numbers) {
    boolean completed = true;

    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i] > numbers[i + 1]) {
        int aux = numbers[i];
        numbers[i] = numbers[i + 1];
        numbers[i + 1] = aux;
        completed = false;
      }
    }

    return completed;
  }

  public static void main(String[] args) {
    int[] bubbleNums = new int[numOfNums];
    int[] quickNums = new int[numOfNums];

    for (int i = 0; i < numOfNums; i++) {
      bubbleNums[i] = rand.nextInt(1001);
      quickNums[i] = bubbleNums[i];
    }

    System.out.println("Initial array :");
    print(bubbleNums);

    boolean bubbleComplete = false;
    QuickSorter qs = new QuickSorter(quickNums);

    while (!(bubbleComplete && qs.isComplete())) {
      if (!bubbleComplete) {
        bubbleComplete = bubbleSortStep(bubbleNums);
        System.out.print("b");
      }
      if (!qs.isComplete()) {
        qs.nextStep();
        System.out.print("q");
      }
    }
    System.out.println("\n");

    System.out.println("After bubble :");
    print(bubbleNums);

    System.out.println("After quick :");
    print(quickNums);

  }

}
