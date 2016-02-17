
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Class {

	public static HashMap<String, Tshirt> map = new HashMap<String, Tshirt>();

	public static void readList() {
		try {
			Scanner sc = new Scanner(new java.io.File("fis.in"));
			while (sc.hasNextLine()) {
				String n = sc.next();
				n = n + " " + sc.next();
				String c = sc.next();
				if (map.containsKey(c) == false) {
					Tshirt ob = new Tshirt(n);
					map.put(c, ob);
				} else {
					Tshirt ob = map.get(c);
					int x = ob.getQ();
					x++;
					ob.setQ(x);
					map.put(c, ob);
				}

			}

			sc.close();
		} catch (Exception e) {

		}
	}

	public static void showList() {
		List<Tshirt> list = new ArrayList<Tshirt>(map.values());
		Collections.sort(list);
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
	}

	public static void main(String[] args) {

		readList();
		showList();

	}

}
