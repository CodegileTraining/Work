/**
 * Class Shirt
 * Contains ID,Descriere,Culoare, Marime,nrBucati
 * @author Stefan
 *
 */
public class Shirt implements Comparable<Shirt> {

	private int ID;
	private String Descriere;
	private String Culoare;
	private String Marime;
	private int nrBucati;

	public int getNrBucati() {
		return nrBucati;
	}

	public void setNrBucati(int nrBucati) {
		this.nrBucati = nrBucati;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDescriere() {
		return Descriere;
	}

	public void setDescriere(String descriere) {
		Descriere = descriere;
	}

	public String getCuloare() {
		return Culoare;
	}

	public void setCuloare(String culoare) {
		Culoare = culoare;
	}

	public String getMarime() {
		return Marime;
	}

	public void setMarime(String marime) {
		Marime = marime;
	}

	@Override
	public String toString() {
		return "Shirt [ID=" + ID + ", Descriere=" + Descriere + ", Culoare=" + Culoare + ", Marime=" + Marime
				+ ", nrBucati=" + nrBucati + "]";
	}

	public Shirt(int iD, String descriere, String culoare, String marime, int nrBucati) {
		ID = iD;
		Descriere = descriere;
		Culoare = culoare;
		Marime = marime;
		this.nrBucati = nrBucati;
	}

	@Override
	/**
	 * Put shirts in lexicographic  order
	 */
	public int compareTo(Shirt o) {
		// TODO Auto-generated method stub
		return this.Descriere.compareTo(o.getDescriere());
	}

}
