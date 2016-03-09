package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ExampleHashMap {

	public static void main(String[] args) {
		
		Map<Integer,String> map = new HashMap<>();
		
		map.put(1, "Ana");
		map.put(2, "Andrei");
		map.put(3, "Ion");
		
		List<Map.Entry<Integer,String>> list= new ArrayList<Map.Entry<Integer,String>>(map.entrySet());
		for(Map.Entry<Integer, String> e: list)
			System.out.println(e);
	}
}
