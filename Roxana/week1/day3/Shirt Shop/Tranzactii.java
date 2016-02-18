import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tranzactii {

	private static HashMap<String, Tricou> tricouri = new HashMap<String, Tricou>();

	private static Scanner sc = new Scanner(System.in);

	public static void initTricouri() {

		File file = new File("fisier.txt");
		Scanner fsc = null;
		try {
			fsc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		while (fsc.hasNextLine()) {
			String line = fsc.nextLine();
			String[] comp = line.split(", ");
			Tricou t = new Tricou(comp[0], comp[1], comp[2], comp[3], Integer.parseInt(comp[4]));
			tricouri.put(t.getCod(), t);
		}

	}

	public static void achizitionare(String cod) {

		int cantitate = 0;
		System.out.println("Introduceti cantitate: ");
		

		Tricou t = tricouri.get(cod);
		if (t != null) {
			try {
				cantitate = sc.nextInt();
				sc.nextLine();

				if (cantitate < 0) {
					throw new Exception("Introduceti cantitatea >0.");
				}
				if (cantitate == 0)
					throw new Exception("Introduceti cantitatea !=0.");

				t.setStoc(t.getStoc() + cantitate);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			String descriere;
			String culoare;
			String marime;
			try {
				cantitate = sc.nextInt();
				sc.nextLine();

				if (cantitate < 0) {
					throw new Exception("Introduceti cantitatea >0.");
				}
				if (cantitate == 0)
					throw new Exception("Introduceti cantitatea !=0.");

				t.setStoc(t.getStoc() + cantitate);
				System.out.println("Introduceti descrierea:");
				descriere = sc.nextLine();
				System.out.println("Introduceti culoare:");
				culoare = sc.nextLine();
				System.out.println("Introduceti marimea:");
				marime = sc.nextLine();
				Tricou tricou = new Tricou(cod, descriere, culoare, marime, cantitate);
				tricouri.put(cod, tricou);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}

	public static void vanzare(String cod) {
		int cantitate;
		System.out.println("Introduceti cantitatea: ");

		cantitate = sc.nextInt();
		sc.nextLine();
		Tricou t = tricouri.get(cod);
		try {

			if (cantitate < 0) {
				throw new Exception("Introduceti cantitatea >0.");
			}
			if (cantitate == 0) {
				throw new Exception("Introduceti cantitatea !=0.");
			}

			if (cantitate > t.getStoc()) {
				throw new Exception("Cantitatea introdusa este indisponibila!");

			}
			t.setStoc(t.getStoc() - cantitate);
			if (t.getStoc() == 0) {
				tricouri.remove(t.getCod());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static void print() {
		System.out.println("Produsele existente sunt: ");
		for (Map.Entry<String, Tricou> entry : tricouri.entrySet()) {
			System.out.println(entry.getValue());

		}
		System.out.println();
	}

	public static void sortDupaDescriere() {
		ArrayList<Tricou> lista = new ArrayList<Tricou>();
		lista.addAll(tricouri.values());
		Collections.sort(lista, new ComparatorD());
		System.out.println("Produsele existente sunt: ");
		for (Tricou t : lista)
			System.out.println(t);
		System.out.println();

	}

	public static void sortDupaCantitate() {
		ArrayList<Tricou> lista = new ArrayList<Tricou>();
		lista.addAll(tricouri.values());
		Collections.sort(lista);
		System.out.println("Produsele existente sunt: ");
		for (Tricou t : lista)
			System.out.println(t);
		System.out.println();
	}

	public static void mainMenu() {
		System.out.println("1.Achizitionare produs.");
		System.out.println("2.Vanzare produs.");
		System.out.println("3.Raport ordine descrescatoare nr. de bucati.");
		System.out.println("4.Raport sortare alfabetica dupa descriere.");

		int i = sc.nextInt();
		sc.nextLine();
		String cod;
		switch (i) {

		case 1:
			System.out.println("Introduceti codul: ");
			cod = sc.nextLine();
			achizitionare(cod);
			print();
			mainMenu();
			break;
		case 2:
			System.out.println("Introduceti codul: ");
			cod = sc.nextLine();
			vanzare(cod);
			print();
			mainMenu();

			break;
		case 3:
			sortDupaCantitate();
			mainMenu();
			break;
		case 4:
			sortDupaDescriere();
			mainMenu();

			break;
		default:
		}

	}

	public static void main(String[] args) throws FileNotFoundException {

		initTricouri();
		mainMenu();

	}
}
