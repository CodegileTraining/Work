import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problema2 {

	private static Scanner input;

	public static int valid(String s) {

		if (!Character.isUpperCase(s.charAt(0)))
			return 0;

		for (int i = 1; i < s.length(); i++)
			if (!Character.isAlphabetic(s.charAt(i)))
				return 0;
		return 1;

	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		int numeValide = 0;

		input = new Scanner(System.in);
		File file = new File("test.txt");
		input = new Scanner(file);

		String myLine = null;

		while (input.hasNextLine()) {

			myLine = input.nextLine();

			String[] words = myLine.split(" ");
			if (words.length == 2)
				if (valid(words[0]) == 1 && valid(words[1]) == 1) {

					System.out.println(myLine);
					numeValide++;
				}

		}

		System.out.println(numeValide);
		input.close();
	}

}
