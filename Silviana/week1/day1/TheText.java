package pack1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TheText {

	private static Scanner sc;

	public static void sort(ArrayList<String> sortcuv) {
		Collections.sort(sortcuv);
	}

	public static void afis(ArrayList<String> sortcuv) {
		System.out.println(sortcuv);
	}

	public static ArrayList<String> citire() {
		try {
			File in = new File("fisier.txt");
			sc = new Scanner(in);
			String s = null;
			while (sc.hasNextLine()) {
				s = sc.nextLine();
			}

			String parts[] = s.split("[ \\.?!]+");

			ArrayList<String> sortcuv = new ArrayList<String>();

			for (int i = 0; i < parts.length; i++)
				sortcuv.add(parts[i]);
			return sortcuv;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}

	public static void main(String[] args)  {

		ArrayList<String> sortcuv=citire();
		sort(sortcuv);
		afis(sortcuv);

		for (int i = 0; i < sortcuv.size(); i++) {

			if (sortcuv.get(i).matches("^[aeiouAEIOU].*")) {
				sortcuv.set(i, String.valueOf(sortcuv.get(i).length()));

			}
		}
		afis(sortcuv);

	}

}
