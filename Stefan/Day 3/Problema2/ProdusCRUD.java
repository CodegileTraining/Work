import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdusCRUD implements CRUD{

	public List<Produs> productList=new ArrayList<Produs>();

	@Override
	public void create(Produs p) {
		// TODO Auto-generated method stub
		productList.add(p);
	}

	@Override
	public Produs read(Scanner input) {
		// TODO Auto-generated method stub
		String myLine=input.nextLine();
		String[] words=myLine.split(",");
		Produs obj=new Produs();
		obj.setDescriere(words[0]);
		obj.setCode(words[1]);
		return obj;
	}

	@Override
	public void update(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		productList.remove(index);
	}
	
}
