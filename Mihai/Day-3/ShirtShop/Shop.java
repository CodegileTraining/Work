
//Inca nu e gata



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Shop {

	static HashMap<String, Shirt> map = new HashMap<String, Shirt>();

	public static void fillShop() {
		try {
			Scanner sc = new Scanner(new java.io.File("fis.in"));
			while (sc.hasNextLine()) {
				Shirt ob = new Shirt(sc.next(), sc.next(), sc.next(), sc.next());
				map.put(ob.getID(), ob);
			}
			sc.close();
		} catch (Exception e) {

		}
	}

	public static void buyShirt(String id) {
		Shirt ob = map.get(id);
		int number = ob.getNumber();
		int c;
		System.out.println("how many shirts do you want to buy");
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		if (c < 0) {
			System.out.println("We are the one who sells Shirts");
		} else if (c == 0)
			System.out.println("So are you going to buy?");
		else if (c > number)
			System.out.println("We don't have tso much shirts");
		else {
			number = number - c;
			ob.setNumber(number);
			map.put(ob.getID(), ob);
		}
		sc.close();
	}

	public static void sellShirt(String id) {

		Shirt ob = map.get(id);
		int number = ob.getNumber();
		int c;
		System.out.println("how many shirts do you want to sell");
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		if (c < 0) {
			System.out.println("This is not the place to buy shirts");
		} else if (c == 0)
			System.out.println("So are you going to sell?");
		else {
			number = number + c;
			ob.setNumber(number);
			map.put(ob.getID(), ob);
		}
		sc.close();
	}

	public static void sortAfterName() {
		List<Shirt> list = new ArrayList<Shirt>(map.values());
		Collections.sort(list);
		System.out.println(list);
	}

	public static void sortAfterNumber() {
		List<Shirt> list = new ArrayList<Shirt>(map.values());
		Collections.sort(list, new CustomComparator());
		System.out.println(list);
	}

	public static void main(String[] args) {
		fillShop();
		int n;
		Scanner sc = new Scanner(System.in);
		String id;
		while (true) {
			System.out.println("What do you want to do?\n1.Buy Shirts\n2.Sell Shirt\n3.Get a Report");
			n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("Introduce Shirt's ID");
				id = sc.next();
				buyShirt(id);
				break;
			case 2:
				System.out.println("Introduce Shirt's ID");
				id = sc.next();
				sellShirt(id);
				break;
			case 3:
				System.out.println("What kind of report do you want?\n1.After Name\n2.After Number\n");
				int z = sc.nextInt();
				switch (z) {
				case 1:
					sortAfterName();
					break;
				case 2:
					sortAfterNumber();
					break;
				default:
					break;
				}
			default:
				System.exit(0);
				break;
			}
		}
	}
}
