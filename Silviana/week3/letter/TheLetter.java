package letter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TheLetter {
	private Scanner sc;
	private BufferedWriter writer;
	private Scanner sc1;
	private FileWriter file;

	public void createFiles() {
		File fileNames = new File("names.txt");

		try {
			sc = new Scanner(fileNames);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			String cat = sc.nextLine();

			try {
				file = new FileWriter(cat + ".txt");
				writer = new BufferedWriter(file);

				File letter = new File("letter.txt");
				sc1 = new Scanner(letter);

				String line;
				while (sc1.hasNextLine()) {
					line = sc1.nextLine();
					writer.write(line.replace("?", cat));
					writer.newLine();
				}
				sc1.close();
				writer.close();
				file.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
