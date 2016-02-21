import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Contains a list of Shirt objects
 * @author Stefan
 *
 */
public class ShirtCRUD implements CRUD {

	public List<Shirt> shirtList = new ArrayList<Shirt>();

	@Override
	public void create(Shirt s) {
		// TODO Auto-generated method stub
		shirtList.add(s);
	}

	@Override
	public Shirt read(Scanner input) {
		// TODO Auto-generated method stub
		String myLine = input.nextLine();
		String[] words = myLine.split(",");

		Shirt myShirt = new Shirt(Integer.parseInt(words[0]), words[1], words[2], words[3], Integer.parseInt(words[4]));

		return myShirt;
	}

	@Override
	public void update(int index, int nrBucati) {
		// TODO Auto-generated method stub
		shirtList.get(index).setNrBucati(nrBucati);

	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		shirtList.remove(index);
	}

}
