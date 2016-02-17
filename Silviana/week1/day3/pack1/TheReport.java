package pack1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TheReport {

	private static ArrayList<Product> products;
	private static Scanner sc;
	private static ArrayList<Product> report;

	public static void read(ArrayList<Product> products) throws FileNotFoundException {
		String newcode;
		String newdescription;
		File in = new File("fisier.txt");
		sc = new Scanner(in);

		int n, m;
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			newcode = sc.next();
			products.add(new Product(newcode, null, 0));
		}

		m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			sc.next();
			newdescription = sc.nextLine();
			for (int j = 0; j < n; j++) {
				if (newdescription.contains(products.get(j).getCode())) {
					String[] parts = newdescription.split("-");
					products.get(j).setDescription("tricou"+parts[0]);
				}
			}

		}

	}

	public static void viewProducts(ArrayList<Product> products) {
		for (int i = 0; i < products.size(); i++)
			System.out.println(products.get(i));
		System.out.println();
	}

	public static ArrayList<Product> createReport(ArrayList<Product> products) {
		ArrayList<Product> report = new ArrayList<Product>();
		for (Product p : products) {
			report.add(p);

		}
		for (Product q : report) {

			for (Product p : products)
				if (q.getCode().equals(p.getCode())) {
					p.setNumAparitions(p.getNumAparitions() + 1);
				}
		}

		for (int i = 0; i < report.size(); i++)
			if (report.get(i).getNumAparitions() > 1) {
				report.remove(i);
			}
		viewProducts(report);
		return report;

	}

	public static void main(String[] args) throws FileNotFoundException {
		products = new ArrayList<Product>();
		report = new ArrayList<Product>();
		read(products);
		viewProducts(products);

		report = createReport(products);
		Collections.sort(report, new ComparatorLetters());
		viewProducts(report);

	}
}
