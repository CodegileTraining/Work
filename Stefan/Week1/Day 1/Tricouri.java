import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Tricouri {

	private int ID;
	private String descriere;
	private String culoare;
	private String size;
	private static String[] words;
	private static int index;
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		List<Tricouri> ShirtList;
		ShirtList=citire();
		System.out.println("ShirtList:");
		for(int i=0;i<ShirtList.size();i++){
			ShirtList.get(i).afisare();
			System.out.println();
		}
		
		if (ShirtList.get(0).equals(ShirtList.get(2))) 
			System.out.println("egale");
		else
			System.out.println("neegale");
	}

	@Override
	public String toString() {
		return "Tricouri [ID=" + ID + ", descriere=" + descriere + ", culoare=" + culoare + ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((culoare == null) ? 0 : culoare.hashCode());
		result = prime * result + ((descriere == null) ? 0 : descriere.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tricouri other = (Tricouri) obj;
		if (ID != other.ID)
			return false;
		if (culoare == null) {
			if (other.culoare != null)
				return false;
		} else if (!culoare.equals(other.culoare))
			return false;
		if (descriere == null) {
			if (other.descriere != null)
				return false;
		} else if (!descriere.equals(other.descriere))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public String getCuloare() {
		return culoare;
	}

	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public void afisare(){
		System.out.println("ID: "+ ID);
		System.out.println("Descriere: "+ descriere);
		System.out.println("culoare: "+ culoare);
		System.out.println("Size: "+ size);
		System.out.println("HashCode: "+ this.hashCode());
	}
	
    public void setAll(String w1,String w2,String w3,String w4){
    	ID=Integer.parseInt(w1);
    	descriere=w2;
    	culoare=w3;
    	size=w4;
    }
	public static List<Tricouri> citire() throws FileNotFoundException{
		
		List<Tricouri> shirtList=new ArrayList<Tricouri>();
		
		Scanner input = new Scanner(System.in);
		File file = new File("tricouri.txt");
		input = new Scanner(file);
		
	
		String myLine=input.nextLine();
		String[] words=myLine.split(",");
		
		index = 0;
		for (int i=0;i<words.length;i+=4){
			Tricouri object=new Tricouri();
		object.setAll(words[i],words[i+1],words[i+2],words[i+3]);
		shirtList.add(object);
		index++;
		}
		input.close();
		return shirtList;
	}
	
}
