package problem2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class SolveProblem {
	public static void main(String[] args) {

		Set<Integer> newSet = new SetClass<Integer>();
		newSet.add(1);
		newSet.add(2);
		newSet.add(3);
		newSet.add(4);
		System.out.println("The size of the newSet is: " + newSet.size());
		Iterator<Integer> it = newSet.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();

		List<Integer> newList = new ListClass<Integer>();
		newList.add(6);
		newList.add(7);
		newList.add(8);
		newList.add(9);
		System.out.println("The size of the newList is: " + newList.size());
		Iterator<Integer> it1 = newList.iterator();
		while (it1.hasNext())
			System.out.print(it1.next() + " ");
		System.out.println();

		Queue<Integer> newQueue = new QueueClass<Integer>();
		newQueue.add(10);
		newQueue.add(11);
		newQueue.add(12);
		newQueue.add(13);
		System.out.println("The size of the newQueue is: " + newQueue.size());
		Iterator<Integer> it2 = newQueue.iterator();
		while (it2.hasNext())
			System.out.print(it2.next() + " ");
		System.out.println();

		Map<Integer, ArrayList<Integer>> newMap = new MapClass<Integer, ArrayList<Integer>>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		newMap.put(1, array);
		System.out.println("The elements of the map: ");
		for (Entry<Integer, ArrayList<Integer>> entry : newMap.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}

	}

}
