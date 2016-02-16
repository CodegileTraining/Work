import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SirCaractere {
	private static Scanner sc;
	private static ArrayList<String> list = new ArrayList<String>();

	public static void citire() {
		File file = new File("fisier.txt");
		String string;
		String[] stringSplit;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				string = sc.nextLine();
				stringSplit = string.split("[,\\.?\\s\\n]+");
				for (int i = 0; i < stringSplit.length; i++) {
					list.add(stringSplit[i]);
				}

			}
			Collections.sort(list);
			System.out.println(list);
		} catch (FileNotFoundException e) {
			System.out.println("Fisier inexistent!");
		}

	}

	public static void rep() {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).matches("^[aeiouAEIOU].*")) {
					list.set(i, String.valueOf(list.get(i).length()));
			}
		}
		System.out.println(list);
	}

	public static void main(String[] args) {

		citire();
		rep();
		
	}

}
