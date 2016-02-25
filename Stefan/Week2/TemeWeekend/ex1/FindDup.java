package Fisier;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class FindDup {

	public static void main(String[] args) {

		Set<String> s = new HashSet<String>();
		for (String a : args) {
			if (!s.add(a))
				System.out.println("Duplicate detected: " + a);

			System.out.println(s.size() + "distinct words: " + s);
		}

		SortedSet<String> sortedS = new TreeSet<String>(new ComparatorCase());

		for (String a : args) {
			if (!sortedS.add(a))
				System.out.println("Duplicate detected: " + a);

			System.out.println(sortedS.size() + "distinct words: " + sortedS);
		}

	}

}
