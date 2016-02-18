package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class Paranteze {

	static boolean checkString(String line){
		
		Deque<Character> stiva=new ArrayDeque<Character>();
		for(int i=0;i<line.length();i++){
			if(line.charAt(i)=='(')
				stiva.push('(');
			else
				if(line.charAt(i)==')')
					{
					if(stiva.isEmpty())
						return false;
					stiva.pop();
					}
		}
		if(stiva.isEmpty())
			return true;
		else return false;
	}
	
	
	
	public static void main(String[] args)  {

		File file=new java.io.File("paranteze.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			while (sc.hasNext()) {
				String line = sc.nextLine();
				System.out.println(line+"  -->"+ checkString(line));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
