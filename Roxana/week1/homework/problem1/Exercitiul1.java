package pack1;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Exercitiul1 {

	public static void main(String[] args) {

		SortedSet<String> s = new TreeSet<String>();
		for (String a : args) 
			if (!s.add(a))		
			   System.out.println("Duplicate deleted  " + a);
		Iterator<String> it = s.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		

	}
}
