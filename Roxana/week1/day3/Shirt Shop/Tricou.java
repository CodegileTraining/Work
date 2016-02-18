
public class Tricou implements Comparable<Tricou> {

	private String cod;
	private String descriere;
	private String culoare;
	private String marime;
	private int stoc;

	public Tricou(String cod, String descriere, String culoare, String marime, int stoc) {

		this.cod = cod;
		this.descriere = descriere;
		this.culoare = culoare;
		this.marime = marime;
		this.stoc = stoc;

	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
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

	public String getMarime() {
		return marime;
	}

	public void setMarime(String marime) {
		this.marime = marime;
	}

	public int getStoc() {
		return stoc;
	}

	public void setStoc(int stoc) {
		this.stoc = stoc;
	}

	@Override
	public String toString() {
		return cod + " " + descriere + " " + culoare + " " + marime + " " + stoc;
	}

	@Override
	public int compareTo(Tricou o) {
		return o.stoc - stoc;
	}

}
