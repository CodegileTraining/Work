package shirtshop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Shop {
	static HashMap<String, Shirt> shirts = InitShirts.theExistingShirts();
	private static Scanner sc;

	public static void buyProduct(String newidShirt, int newnrpieces) throws MyException {

		if (newnrpieces <= 0)
			throw new MyException("The quantity isn't correct!");
		
		
		if(!(shirts.keySet().contains(newidShirt)))
			throw new MyException("This shirt doesn't exist!");

		Shirt s = shirts.get(newidShirt);
		s.setNrpieces(s.getNrpieces() + newnrpieces);
		shirts.put(newidShirt, s);
	}

	public static void sellProduct(String newidShirt, int newnrpieces) throws MyException {

		if (newnrpieces <= 0)
			throw new MyException("The quantity isn't correct!");

		if (newnrpieces > shirts.get(newidShirt).getNrpieces())
			throw new MyException("The quantity is incorrect!");

		if(!(shirts.keySet().contains(newidShirt)))
			throw new MyException("This shirt doesn't exist!");

		Shirt s = shirts.get(newidShirt);
		s.setNrpieces(s.getNrpieces() - newnrpieces);
		shirts.put(newidShirt, s);

	}

	public static void nrPiecesReport() {
		List<Shirt> report = new ArrayList<Shirt>(shirts.values());
		Collections.sort(report, new ComparatorPieces());
		System.out.println("The nr pieces report: ");
		print(report);
	}

	public static void descriptionReport() {

		List<Shirt> report = new ArrayList<Shirt>(shirts.values());
		System.out.println("The description report: ");
		Collections.sort(report);
		print(report);

	}

	public static void print(List<Shirt> report) {
		for (int i = 0; i < report.size(); i++)
			System.out.println(report.get(i));
		System.out.println();
	}

	public static void menu() {
		System.out.println("1. Buy Product");
		System.out.println("2. Sell Product");
		System.out.println("3. Create report after nrpieces");
		System.out.println("4. Create report after description");
		System.out.println("5. Exit");
	}

	public static void main(String[] args) {
		String newidShirt;
		int newnrpieces;
		sc = new Scanner(System.in);
		menu();
		int choice;
   do{
	   choice=sc.nextInt();
		switch (choice) {
		case 1:
			System.out.print("Id: ");
			newidShirt = sc.next();
			System.out.print("NrPieces: ");
			newnrpieces = sc.nextInt();
			try {
				buyProduct(newidShirt, newnrpieces);
			} catch (MyException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.print("Id: ");
			newidShirt = sc.next();
			System.out.print("NrPieces: ");
			newnrpieces = sc.nextInt();
			try {
				sellProduct(newidShirt, newnrpieces);
			} catch (MyException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			nrPiecesReport();
			break;
		case 4:
			descriptionReport();
			break;
		case 0:
		    menu();
		    break;

		}
   }while (choice != 5);
	}
}
