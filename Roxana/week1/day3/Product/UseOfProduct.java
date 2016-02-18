import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UseOfProduct {

	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<String> codes = new ArrayList<String>();
		int n;
		String code;
		String description;

		File file = new File("fisier.txt");
		int i = 0;
		Scanner sc = new Scanner(file);

		n = sc.nextInt();
		while (i < n) {
			codes.add(sc.next());
			i++;
		}

		sc.nextLine();

		while (sc.hasNextLine()) {

			String product = sc.nextLine();
			String[] splitProduct = product.split("-");

			description = splitProduct[0];
			code = splitProduct[1];
			products.add(new Product(description, code));
		}

		System.out.println(codes);

		for (Product p : products) {
			int nr=1;
			for (String cod : codes) {
				if (cod.equals(p.getCode()))
					nr++;

			}
			p.setNr(nr);

		}

		for (Product p : products) {
			System.out.println(p);
		}

		
		System.out.println("Dupa sortare cu Comparator");
		Collections.sort(products, new ComparatorR());

		for (Product p : products) {

			System.out.println(p);
		}

	}

}
