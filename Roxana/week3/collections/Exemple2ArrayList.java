package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Exemple2ArrayList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("ana");
		list.add("ion");
		list.add("ana");
		list.add("andrei");
		list.add("ion");
		list.add("ion");
		System.out.println("HashSet");
		Set<String> set = new HashSet<>(list);
		Iterator<String> it = set.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		
		System.out.println("HashMap");
		HashMap<String, String> map = new HashMap<String, String>();
		for (String s : list) 
		  map.put( s, s );
		
		for(Map.Entry<String,String> entry : map.entrySet())
			System.out.println(entry.getValue());
	}

}
