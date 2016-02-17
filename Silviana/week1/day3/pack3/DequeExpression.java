package pack3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class DequeExpression {

	private static Scanner sc;
	private static String s;
	private static ArrayDeque<String> deque;

	public static boolean verifyExpression(String s) {
		deque = new ArrayDeque<String>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				deque.push(new String());
			if (s.charAt(i) == ')'){
				if(deque.isEmpty())
					return false;
				deque.pop();
			}
		}
		if(deque.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("fisier2.txt");
		sc = new Scanner(in);
		while (sc.hasNextLine()) {
			s = sc.nextLine();
			boolean ok=verifyExpression(s);
			if(ok)
				System.out.println("Expresia: "+s+" este valida!");
			else
			System.out.println("Expresia: "+s+" nu este valida!");

		}
	}
}
