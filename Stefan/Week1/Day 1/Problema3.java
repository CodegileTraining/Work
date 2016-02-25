import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problema3 {

	private static Scanner input;
	private static String myLine;
	private static String[] words;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		List<String> myList = new ArrayList<String>();
		String vocal = "AEIOUaeiou";
		input = new Scanner(System.in);
		File file = new File("test.txt");
		input = new Scanner(file);

		myLine = null;

		while (input.hasNextLine()) {
			myLine = input.nextLine();
			 myLine=myLine.replace("<p>","<span>");
			 myLine=myLine.replace("</p>","</span>");
			// myLine.replace('!',' ');

			words = myLine.split("[\\s\\.!?]+");
			for (int i = 0; i < words.length; i++) {
				myList.add(words[i]);
			}

		}

		Collections.sort(myList);

		
		char lit1='a';
		char lit2='b';
		for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).matches("(a*ba*ba*)*|a*"))
            	System.out.println("cuvant format din "+lit1+lit2+ " " +myList.get(i) );
			char x = myList.get(i).charAt(0);
			if (vocal.indexOf(x) != -1)
				myList.set(i, String.valueOf(myList.get(i).length()));
			System.out.println(myList.get(i));
		}

	}

}
