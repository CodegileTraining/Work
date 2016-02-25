
public class Produs {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((culoare == null) ? 0 : culoare.hashCode());
		result = prime * result + ((descriere == null) ? 0 : descriere.hashCode());
		result = prime * result + ((dimensiune == null) ? 0 : dimensiune.hashCode());
		result = prime * result + id;
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
		Produs other = (Produs) obj;
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
		if (dimensiune == null) {
			if (other.dimensiune != null)
				return false;
		} else if (!dimensiune.equals(other.dimensiune))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	private int id;
	@Override
	public String toString() {
		return "Produs [id=" + id + ", descriere=" + descriere + ", culoare=" + culoare + ", dimensiune=" + dimensiune
				+ "]";
	}
	private String descriere;
	private String culoare;
	private String dimensiune;
	
	public Produs(int id, String descriere, String culoare, String dimensiune) {
		this.id = id;
		this.descriere = descriere;
		this.culoare = culoare;
		this.dimensiune = dimensiune;
	}
	
	

	public Produs() {
		super();
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDimensiune() {
		return dimensiune;
	}
	public void setDimensiune(String dimensiune) {
		this.dimensiune = dimensiune;
	}
	
	
	
}
