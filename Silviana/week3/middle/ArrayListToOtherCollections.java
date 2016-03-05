package middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ArrayListToOtherCollections {
	static List<String> array = new ArrayList<String>();

	public static void initializeArray() {
		array.add("Maria");
		array.add("Ana");
		array.add("Ana");
		array.add("Ion");
		array.add("Ana");
		array.add("Vanessa");
		array.add("Laura");
		array.add("Maria");

	}

	public static void arrayListToHashSet() {

		Set<String> hs = new HashSet<>();

		for (String s : array)
			hs.add(s);
		System.out.println(hs);
	}

	public static void arrayListToSortedSet() {
		SortedSet<String> ss = new TreeSet<>();

		for (String s : array)
			ss.add(s);
		System.out.println(ss);
	}

	public static void main(String[] args) {
		initializeArray();
		System.out.println("Array to HashSet: ");
		arrayListToHashSet();
		System.out.println("Array to SortedSet: ");
		arrayListToSortedSet();
	}

}
