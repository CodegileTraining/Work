package pack1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TheNames {

	private static Scanner sc;

	public static void main(String[] args) {
		try {
			File in = new File("fisier.txt");
			sc = new Scanner(in);

			int n, nrvalid = 0, ok;
			n = sc.nextInt();

			sc.nextLine();
			ArrayList<String> str = new ArrayList<String>(n);
			for (int i = 0; i < n; i++) {
				String fullname = sc.nextLine();
				str.add(fullname);
			}

			for (String s : str) {
				String parts[] = s.split(" ");

				ok = 1;

				String cuv = parts[0];

				if (cuv.isEmpty()) {
					ok = 0;
					break;
				}

				if (cuv.length() < 1) {
					ok = 0;
					break;
				}

				if (Character.isLowerCase(cuv.charAt(0))) {
					ok = 0;
					break;
				}

				for (int k = 1; k < cuv.length(); k++)
					if (Character.isUpperCase(cuv.charAt(k))) {
						ok = 0;
						break;
					}

				cuv = parts[1];

				if (cuv.isEmpty()) {
					ok = 0;
					break;
				}

				if (cuv.length() < 1) {
					ok = 0;
					break;
				}

				if (Character.isLowerCase(cuv.charAt(0))) {
					ok = 0;
					break;
				}

				for (int k = 1; k < cuv.length(); k++)
					if (Character.isUpperCase(cuv.charAt(k))) {
						ok = 0;
						break;
					}

				if (ok == 1)
					nrvalid++;
			}

			System.out.println("Nr de nume valide: " + nrvalid);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StringIndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}

	}
}
