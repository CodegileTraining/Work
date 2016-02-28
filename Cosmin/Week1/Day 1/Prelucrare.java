import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prelucrare {

	private static Scanner sc;

	public static void main(String[] args) {

		File file=new File("produse.txt");
		ArrayList<Produs> produse=new ArrayList<Produs>();
		try {
			sc=new Scanner(file);
			String line;
			int j=0;
			int id=0;
			String descriere=null;
			String culoare=null;
			while(sc.hasNextLine())
			{
				
				line=sc.nextLine();
				String[] splitString=line.split(",");
				
				for(int i=0;i<splitString.length;i++)
				{
					
					j++;
					if(j==1)  id=Integer.parseInt(splitString[i]);
					if(j==2) descriere=splitString[i];
					if(j==3) culoare=splitString[i];
					if(j==4){
						Produs p=new Produs(id, descriere, culoare, splitString[i]);
						produse.add(p);
						j=0;
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		for(int i=0;i<produse.size();i++)
		{
			System.out.println(produse.get(i));
		}
	}
}

