package Day4;

/**
 * This class contains the main function.
 * 
 * @author Margarit
 *
 */
public class ShirtMain {

	public static void main(String[] args) {

		ShirtStorage shirtMap = new ShirtStorage();
		try {
			shirtMap.getShirtsFromFile("shirts.txt");
			shirtMap.print();

			Shirt test = new Shirt("Tricou polo", "alb", "XS", 5);
			System.out.println("Sorted by count:");
			shirtMap.remove(test, test.getId());
			shirtMap.printByComparator(new CountComparator());
			System.out.println("Sorted by description:");
			shirtMap.printByComparator(new DescriptioComparator());

			Tranzaction tranz = new Tranzaction();
			shirtMap.put(test);
			tranz.buy(shirtMap, 1, 50);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}

}
