import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumePrenume {

	private static Scanner sc;

	public static void main(String[] args) {

		String name = null;
		File file = new File("fisier.txt");
		try {
			sc = new Scanner(file);

			while (sc.hasNextLine()) {
				name = sc.nextLine();

				String[] nameSplit = name.split(" ");
				String nume = nameSplit[0];
				String prenume = nameSplit[1];
				
				if (nume.length() < 1 || prenume.length() < 1)
					System.out.println(nume + prenume + "este invalid!");
				
				if (!Character.isUpperCase(nume.charAt(0)) || !Character.isUpperCase(prenume.charAt(0))) {
					System.out.println(nume + " " + prenume + " " +"este invalid!");

				}
				if (nume.isEmpty() || prenume.isEmpty()) {
					System.out.println(nume + " " + prenume + "este invalid!");
				}
				

			}
		} catch (FileNotFoundException e) {
			System.out.println("Fisier inexistent!");
		}

	}
}
