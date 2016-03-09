package pack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Letter {

	static Scanner names = null;
	static Scanner letter = null;
	static FileWriter fw;
	static BufferedWriter bw;

	

	public static void initLetter() {
		File nume = new File("nume");
		try {
			names = new Scanner(nume);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (names.hasNext()) {

			String name;
			name = names.nextLine();
			try {
				File letter = new File(name + ".txt");
			    fw = new FileWriter(letter);
			    
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bw = new BufferedWriter(fw);
			File scrisoare = new File("scrisoare");
			try {
				letter = new Scanner(scrisoare);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			while(letter.hasNextLine()){
				String line = letter.nextLine();
				line = line.replace("X", name);
				System.out.println(line);
				try {
					bw.write(line);
					bw.newLine();
					bw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	public static void main(String[] args) {
		initLetter();
		
	}

}
