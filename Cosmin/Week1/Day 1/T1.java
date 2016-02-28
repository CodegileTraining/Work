import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class T1 {


	private static Scanner sc;

	public static void ap1()
	{
		int n;
		sc = new Scanner(System.in);
		int intreg=0;
		int real=0;
		System.out.println("size: ");
		try
		{
			n=sc.nextInt();
			double[] number=new double[n];
			for(int i=0;i<n;i++)
			{
				number[i]=sc.nextDouble();
			}

			for(int i=0;i<n;i++)
			{
				if(number[i]-(int)number[i]==0)
					intreg++;
				else real++;
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Intregi:"+intreg+"  Reale: "+real);	
		}


	}

	public static void ap2(){

		File file=new File("ap2.txt");
		try {
			sc=new Scanner(file);
			String line;
			while(sc.hasNextLine())
			{
				line=sc.nextLine();

				System.out.println(line);
				String[] splitString=line.split(" ");
				//Minim o litera
				if(splitString.length<2) throw new MyException("Minim o litera");
				//Litera mica
				if(splitString[0].charAt(0)<'A' || splitString[0].charAt(0)>'Z' || 
						splitString[1].charAt(0)<'A' || splitString[1].charAt(0)>'Z') throw new MyException("Litera mica");
				//Toate litere mici inafara de prima
				for(int i=1;i<splitString[0].length();i++)
				{
					if(Character.isUpperCase(splitString[0].charAt(i))) throw new MyException("Litera mica inafara de prima");
				}
				for(int i=1;i<splitString[1].length();i++)
				{
					if(Character.isUpperCase(splitString[1].charAt(i))) throw new MyException("Litera mica inafara de prima");
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(MyException e){

			JOptionPane.showMessageDialog(null, e);
		}
	}


	public static void ap3()
	{
		File file=new File("ap3.txt");
		try {
			sc=new Scanner(file);
			String line;
			ArrayList<String> words=new ArrayList<>();
			while(sc.hasNextLine())
			{
				line=sc.nextLine();

				System.out.println(line);
				String[] splitString=line.split("[,\\s\\.\\n!?]+");
				
				for(int i=0;i<splitString.length;i++){
					words.add(splitString[i]);
				}

			}
	   System.out.println(words);
		words.sort(null);
		System.out.println(words);
		
		
		for(int i=0;i<words.size();i++)
		{
			String w=words.get(i).toLowerCase();
			char c= w.charAt(0);
			if(w.matches("[aeiou].*"))
				words.set(i,Integer.toString(w.length()));
//			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
//				words.set(i,Integer.toString(w.length()));
//			}
		}
		System.out.println(words);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]){

		ap3();

	}

}
