package com.codegile.week1.day3.problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QuickSorter {

  private static int[] numbers;
  private static Queue<List<QuickSortStep>> steps = new LinkedList<>();

  public QuickSorter(int[] array) {
    numbers = array;
    List<QuickSortStep> initial = new ArrayList<>();

    initial.add(new QuickSortStep(numbers, 0, numbers.length - 1));
    steps.offer(initial);
  }

  public boolean isComplete() {
    return steps.isEmpty();
  }

  public void nextStep() {
    List<QuickSortStep> currentStep = steps.poll();
    List<QuickSortStep> nextStep = new ArrayList<>();
    for (QuickSortStep step : currentStep) {
      nextStep.addAll(step.executeStep());
    }
    if (!nextStep.isEmpty()) {
      steps.offer(nextStep);
    }
  }
}
