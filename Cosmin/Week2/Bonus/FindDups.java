package Bonus;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class FindDups implements Comparator<String>{

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		for (String a : args) {
			if (!(s.add(a)))
				System.out.println("Duplicate detected: " + a);
		}
		System.out.println(s.size() + "Distinct words:" + s);

		System.out.println("Sorted Set:");
		SortedSet<String> ss = new TreeSet<>(new FindDups());
		for (String a : args) {
			if (!(ss.add(a)))
				System.out.println("Duplicate detected: " + a);
		}
		System.out.println(ss.size() + "Distinct words" + ss);
	}

	@Override
	public int compare(String o1, String o2) {
		
		return o1.toLowerCase().compareTo(o2.toLowerCase());
	}
}
