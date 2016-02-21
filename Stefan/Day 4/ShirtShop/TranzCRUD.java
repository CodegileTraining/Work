import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/** 
 * Contains a list of Transaction objects
 * @author Stefan
 *
 */
public class TranzCRUD implements CRUDtran {

	List<Transaction> tranzList = new ArrayList<Transaction>();
	private String[] verifTran = { "vinde", "cumpara" };


	@Override
	public void create(Transaction t) {
		// TODO Auto-generated method stub
		tranzList.add(t);
	}

	@Override
	public Transaction read(Scanner input, HashMap<Integer, Shirt> map) throws Exception {
		// TODO Auto-generated method stub
		String[] words = input.nextLine().split(",");
		if (!map.containsKey(Integer.parseInt(words[0])))
			throw new Exception("This shirt does not exist!");

		/*
		 * if (!(words[1].equals("cumpara") || words[1].equals("vinde"))) throw
		 * new Exception("This is not a valid transaction");
		 */

		int q = 0;
		for (int i = 0; i < verifTran.length; i++)
			if (verifTran[i].equals(words[1]))
				q = 1;
		if (q == 0)
			throw new Exception("This is not a valid transaction");

		if (Integer.parseInt(words[2]) <= 0)
			throw new Exception("This transaction doesn't make sense");

		// if
		// (map.get(Integer.parseInt(words[0])).getNrBucati()-Integer.parseInt(words[2])<0
		// && words[1].equals("vinde"))
		// throw new Exception ("You cannot sell more than you have");

		Transaction t = new Transaction(Integer.parseInt(words[0]), words[1], Integer.parseInt(words[2]));
		return t;
	}

	@Override
	public void update(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		tranzList.remove(index);
	}

}
