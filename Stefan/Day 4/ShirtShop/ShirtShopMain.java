import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Main class
 * @author Stefan
 *
 */
public class ShirtShopMain {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		ShirtCRUD list;

		list = openFile(); // initializare tricouri

		HashMap<Integer, Shirt> map = new HashMap<Integer, Shirt>();

		for (Shirt s : list.shirtList) // tricouri->hashmap
			map.put(s.getID(), s);

		TranzCRUD tranz;
		//tranz.map = map; // hashmapul din tranzitii ptr verificare
		
		tranz = tranzFile(map);// citesc tranzactiile

		

		int k = 0; // contor ptr nr de tranzactii efectuate
		int q = 3; // dupa q tranzactii se afiseaza rapoartele
		
		for (Transaction t: tranz.tranzList)
			System.out.println(t);
		
		System.out.println();
		System.out.println();
		System.out.println();

		for (Transaction t : tranz.tranzList) {

			try {

				t.process(map);
				k++;
			} catch (Exception e) {
				//e.printStackTrace();
			}

			if (k % q == 0 && k!=0) {
				list.shirtList.sort(new ComparatorA());
				for (Shirt s : list.shirtList)
					System.out.println(s);

				Collections.sort(list.shirtList);
				for (Shirt s : list.shirtList)
					System.out.println(s);

			}
		}

	}

	public static ShirtCRUD openFile() throws FileNotFoundException {

		Scanner input = new Scanner(System.in);
		File file = new File("tricouri.txt");
		Scanner scanner = input = new Scanner(file);

		ShirtCRUD shirt = new ShirtCRUD();

		while (input.hasNextLine()) {

			shirt.create(shirt.read(input));
		}
		input.close();
		return shirt;
	}

	public static TranzCRUD tranzFile(HashMap <Integer, Shirt> map) throws FileNotFoundException {

		Scanner input = new Scanner(System.in);
		File file = new File("tranzactii.txt");
		input = new Scanner(file);
		TranzCRUD aux = new TranzCRUD();
		while (input.hasNextLine()) {

			try {
				Transaction t = aux.read(input,map);
				aux.create(t);
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
		input.close();
		return aux;
	}
}
