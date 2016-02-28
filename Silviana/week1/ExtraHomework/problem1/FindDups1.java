package problem1;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class FindDups1 {
	public static void main(String[] args) {
		SortedSet<String> set = new TreeSet<String>();
		for (String a : args)
			if (!set.add(a))
				System.out.println("duplicate detected: " + a);
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

}
