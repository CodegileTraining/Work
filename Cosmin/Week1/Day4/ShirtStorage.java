package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * This class is used to store all the shirts in the shop at a given time.
 * 
 * @author Margarit
 *
 */
public class ShirtStorage {

	HashMap<Shirt, Integer> shirtMap = new HashMap<>();

	public void getShirtsFromFile(String fileName) throws MyException {

		File file = new File(fileName);
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] splitLine = line.split(",");
				String description = splitLine[0];
				String color = splitLine[1];
				String size = splitLine[2];
				int quantity = Integer.parseInt(splitLine[3]);

				Shirt sh = new Shirt(description, color, size, quantity);

				this.put(sh, sh.getQuantity());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Shirt shirtExists(int id) throws MyException {
		for (Shirt sh : shirtMap.keySet()) {
			if (sh.getId() == id)
				return sh;
		}
		throw new MyException("Shirt not found: " + id);
	}

	public void put(Shirt sh) throws MyException {

		if (sh.getQuantity() <= 0)
			throw new MyException("Ivalid quantity: " + sh.getQuantity());

		if (shirtMap.containsKey(sh)) {
			shirtMap.put(sh, shirtMap.get(sh) + sh.getQuantity());
		} else
			shirtMap.put(sh, sh.getQuantity());
	}

	public void put(Shirt sh, int quantity) throws MyException {

		if (quantity <= 0)
			throw new MyException("Ivalid quantity: " + quantity);

		if (shirtMap.containsKey(sh)) {
			shirtMap.put(sh, shirtMap.get(sh) + quantity);
		} else
			shirtMap.put(sh, quantity);
	}

	public void remove(Shirt sh, int quantity) throws MyException {

		int value = shirtMap.get(sh);
		if (quantity <= 0)
			throw new MyException("Ivalid quantity: " + quantity);
		if (quantity > value)
			throw new MyException("Ivalid quantity: " + quantity + "(Only " + value + " shirts available)");
		if (value == quantity)
			shirtMap.remove(sh);
		else
			shirtMap.put(sh, shirtMap.get(sh) - quantity);
	}

	public void print() {
		for (Shirt sh : shirtMap.keySet()) {
			System.out.println(sh);
		}
		System.out.println();

	}

	public void printByComparator(Comparator<ShirtComp> comp) {
		List<ShirtComp> shirtList = new ArrayList<>();
		for (Entry<Shirt, Integer> entry : shirtMap.entrySet()) {
			shirtList.add(new ShirtComp(entry.getKey(), entry.getValue()));
		}

		shirtList.sort(comp);
		for (ShirtComp sh : shirtList) {
			System.out.println(sh);
		}
		System.out.println();
	}

}
