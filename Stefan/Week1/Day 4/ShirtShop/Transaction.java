import java.util.ArrayList;
import java.util.HashMap;
/**
 * Class Transaction
 * Contains ID, tipTranz, ntBuc
 * @author Stefan
 *
 */
public class Transaction {

	private int ID;
	private String tipTranz;
	private int nrBuc;

	public Transaction(int iD, String tipTranz, int nrBuc) {
		super();
		ID = iD;
		this.tipTranz = tipTranz;
		this.nrBuc = nrBuc;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTipTranz() {
		return tipTranz;
	}

	public void setTipTranz(String tipTranz) {
		this.tipTranz = tipTranz;
	}

	public int getNrBuc() {
		return nrBuc;
	}

	public void setNrBuc(int nrBuc) {
		this.nrBuc = nrBuc;
	}
/**
 * Process a transaction , if possible
 * @param map
 * @throws Exception
 */
	public void process(HashMap<Integer, Shirt> map) throws Exception {

		Shirt s = map.get(this.ID);

		if (this.getTipTranz().equals("vinde") && s.getNrBucati() - this.nrBuc < 0)
			throw new Exception("You cannot sell more than you have");

		if (tipTranz.equals("vinde"))
			s.setNrBucati(s.getNrBucati() - this.nrBuc);
		else if (tipTranz.equals("cumpara"))
			s.setNrBucati(s.getNrBucati() + this.nrBuc);
		// System.out.println(s.getNrBucati());
		map.remove(this.ID);
		map.put(this.ID, s);
	}

	@Override
	public String toString() {
		return "Transaction [ID=" + ID + ", tipTranz=" + tipTranz + ", nrBuc=" + nrBuc + "]";
	}
}
