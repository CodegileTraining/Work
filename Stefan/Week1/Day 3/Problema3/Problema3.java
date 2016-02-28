import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Problema3 {

	private static Scanner scanner;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		ArrayList<String> expres=new ArrayList<String>();
 		
		
		expres=openFile();  //citeste expresiile din fisier
		
		for(String item: expres){
			System.out.println(item+corect(item)); //afisare
		}
				
	}
	public static String corect(String expresie){
		
		Deque dequeA = new LinkedList();
		
		for (int i=0;i<expresie.length();i++)
			if (expresie.charAt(i)=='(') 
				dequeA.add("1");
			else if (expresie.charAt(i)==')')
				if (dequeA.isEmpty()) return "   nu e bun";
				else dequeA.remove();
		if (dequeA.isEmpty()) return "    e bun";
		else return "   nu e bun";
	}
	
	public static ArrayList<String> openFile() throws FileNotFoundException{
		ArrayList<String> expres=new ArrayList<String>();
 		Scanner input=new Scanner(System.in);
		File file=new File("expresie.txt");
		scanner = input=new Scanner(file);
		
		while(input.hasNextLine()){
			expres.add(input.nextLine());
		}
		
		input.close();
		return expres;
	}
}
