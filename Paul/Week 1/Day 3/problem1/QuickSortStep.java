package com.codegile.week1.day3.problem1;

import java.util.ArrayList;
import java.util.List;

public class QuickSortStep {

  private int[] currentNumbers;
  private int left;
  private int right;

  public QuickSortStep(int[] currentNumbers, int left, int right) {
    this.currentNumbers = currentNumbers;
    this.left = left;
    this.right = right;
  }

  public List<QuickSortStep> executeStep() {
    int i = left;
    int j = right;
    int pivot = currentNumbers[(left + right) / 2];

    while (i <= j) {
      while (currentNumbers[i] < pivot)
        i++;
      while (currentNumbers[j] > pivot)
        j--;
      if (i <= j) {
        int aux = currentNumbers[i];
        currentNumbers[i] = currentNumbers[j];
        currentNumbers[j] = aux;
        i++;
        j--;
      }
    }

    List<QuickSortStep> nextSteps = new ArrayList<>();
    if (left < i - 1) {
      nextSteps.add(new QuickSortStep(currentNumbers, left, i - 1));
    }
    if (i < right) {
      nextSteps.add(new QuickSortStep(currentNumbers, i, right));
    }

    return nextSteps;
  }
}
