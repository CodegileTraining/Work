package middle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterateArrayList {

	static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {

		list.add("ana");
		list.add("mara");
		list.add("ion");
		list.add("tata");
		list.add("gigi");

		System.out.println("Method 1: ");
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		System.out.println();

		System.out.println("Method 2: ");
		for (String s : list)
			System.out.print(s + " ");
		System.out.println();

		System.out.println("Method 3: ");
		Iterator<String> it = list.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();

		System.out.println("Method 4: ");
		int i = 0;
		while (i != list.size()) {
			System.out.print(list.get(i) + " ");
			i++;
		}
		System.out.println();

		System.out.println("Method 5: ");
		list.forEach((s) -> {
			System.out.print(s + " ");
		});
		System.out.println();

	}

}
