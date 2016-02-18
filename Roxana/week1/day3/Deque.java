package pack3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Deque {

	private static Scanner sc;

	public static int verify(String s){
		ArrayDeque<String> deque = new ArrayDeque<String>();
		
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i) == '('){
				deque.push(new String());				
			}
			if(s.charAt(i) == ')'){
				if(deque.isEmpty())
					return 0;
				deque.pop();
			}
		}
		if(deque.isEmpty())
			return 1;
		return 0;
	}
	public static void main(String []args){
		
		
		sc = new Scanner(System.in);
		String s;
		System.out.println("Introduceti un sir de caractere: ");
		s=sc.nextLine();
		
		if(verify(s)==1)
			System.out.println("Este corect!");
		else
			System.out.println("Este incorect!");
			
	
		
	}
}
