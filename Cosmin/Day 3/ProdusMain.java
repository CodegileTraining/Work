package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class ProdusMain {

	static List<Produs>  prodList=new ArrayList<Produs>();
	static HashMap<Produs, Integer> map=new HashMap<>();

	static void getProdusFromFile(String fileName){

		File file=new File("produs.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);

			while(sc.hasNextLine()){
				String line=sc.nextLine();
				String[] splitLine=line.split("/");
				Produs p=new Produs(splitLine[1], splitLine[0]);
				if(splitLine[1]!=null){
					prodList.add(p);
					if(map.containsKey(p))
						map.put(p, map.get(p)+1);
					else
						map.put(p, 1);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getProdusFromFile("produs.txt");

		List<ProdComp> orderedProd=new ArrayList<ProdComp>();
		for (Map.Entry<Produs, Integer> entry : map.entrySet()) {
			orderedProd.add(new ProdComp(entry.getKey(), entry.getValue()));
		}

		orderedProd.sort(new ProdComp());
		Collections.sort(orderedProd);
		for(int i=0;i<orderedProd.size();i++)
			System.out.println(orderedProd.get(i));



	}

}
