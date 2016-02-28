import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Problema2 {

	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		ProdusCRUD object=new ProdusCRUD();
		
		Scanner input = new Scanner(System.in);
		File file = new File("Produs.txt");
		input = new Scanner(file);
		
		while(input.hasNextLine()){
			
			Produs obj=object.read(input);
			object.create(obj);
		}
		input .close();
		
		for (int i=0;i<object.productList.size();i++){
			System.out.println(object.productList.get(i));
		}
		
		Scanner input2 = new Scanner(System.in);
		File file2= new File("ProdList");
		input2 = new Scanner(file2);
		
		String [] codes=new String [100] ;
		int k=0;
	
		while(input2.hasNextLine()){
			
			codes[k]=input2.nextLine();
			k++;
		}
		input2.close();
		
		
		//HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, ProdusPlusApar> map2 = new HashMap<String, ProdusPlusApar>();
		
		for (int i=0;i<object.productList.size();i++){
			ProdusPlusApar x=new ProdusPlusApar();
			x.produs=object.productList.get(i);
			x.nraparitii=0;
		//map.put(object.productList.get(i).getCode(),object.productList.get(i).getCode());
		map2.put(object.productList.get(i).getCode(), x);
		}
		
		for (int i=0;i<codes.length;i++){
			if (map2.containsKey(codes[i])){
				ProdusPlusApar aux=map2.get(codes[i]);
				map2.remove(codes[i]);
				aux.nraparitii++;
				map2.put(codes[i], aux);
			}
		}
			
		object.productList.sort(new ComparatorS());
		for (int i=0;i<object.productList.size();i++){
			
			String cod=object.productList.get(i).getCode();
			System.out.print(object.productList.get(i).getDescriere()+ " ");
			System.out.println(map2.get(cod).nraparitii);
		}
	}

}
