package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapToArrayList {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "Mara");
		map.put(2, "Gina");
		map.put(3, "Laura");
		map.put(4, "George");

		Set<Entry<Integer, String>> set = map.entrySet();
		Iterator<Entry<Integer, String>> it = set.iterator();

		List<Map.Entry<Integer, String>> array = new ArrayList<Map.Entry<Integer, String>>();

		while (it.hasNext()) {
			Map.Entry<Integer, String> nm = (Entry<Integer, String>) it.next();
			array.add(nm);
			System.out.println(nm);
		}

	}
}
