package com.codegile.week1.extra.problem2;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CustomImplementationTest {

  public static void main(String[] args) {

    System.out.println("Testing custom Set\n");

    Set<Integer> mySet = new CustomSet<>();

    mySet.add(1);
    mySet.add(2);
    System.out.println(mySet.add(1));
    System.out.println(mySet);
    System.out.println();

    System.out.println("Testing custom Map\n");

    Map<Integer, String> myMap = new CustomMap<>();

    myMap.put(1, "One");
    myMap.put(2, "Two");
    myMap.put(1, "One again");
    System.out.println(myMap.get(1));
    myMap.remove(1);
    System.out.println(myMap.get(1));
    System.out.println();

    System.out.println("Testing custom List\n");

    List<String> myList = new CustomList<>();

    myList.add("First string");
    myList.add("Second string");
    myList.add("Third string");
    System.out.println(myList);
    myList.remove(0);
    myList.remove("Third string");
    System.out.println(myList.get(0));
    System.out.println();

    System.out.println("Testing custom Queue\n");

    Queue<Integer> myQueue = new CustomQueue<>();

    myQueue.offer(1);
    myQueue.offer(2);
    myQueue.offer(3);
    myQueue.offer(4);
    System.out.println(myQueue.poll() + " " + myQueue.poll());
    System.out.println(myQueue);
  }

}
