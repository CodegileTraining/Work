package pack1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class MyClass {

	public static void main(String[] args) {

		List<Integer> list = new ClassList<Integer>();
		list.add(3);
		list.add(4);
		list.add(3);
		list.add(5);
		System.out.println("List:");
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		System.out.println();
		list.remove(3);
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");

		System.out.println();

		System.out.println("Set:");
		Set<Integer> set = new ClassSet<Integer>();
		set.add(1);
		set.add(4);
		set.add(2);
		set.add(1);
		Iterator it = set.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		set.remove(2);
		System.out.println();
		it = set.iterator();

		while (it.hasNext())
			System.out.print(it.next() + " ");

		System.out.println();

		System.out.println("Queue:");
		Queue<Integer> queue = new ClassQueue<Integer>();

		queue.add(2);
		queue.add(1);
		queue.add(8);
		queue.add(5);
		System.out.println(queue.size());
		it = queue.iterator();
		while (it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();

		System.out.println("Map:");
		Map<Integer, ArrayList<Integer>> map = new ClassMap<Integer, ArrayList<Integer>>();
		ArrayList <Integer>l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		map.put(1, l);
		for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue()+ " ");

		}

	}
}
