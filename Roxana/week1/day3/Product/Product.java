
public class Product implements Comparable<Product> {

	private String code;
	private String description;
	private int nr = 0;

	public int getNr() {
		return nr;
	}

	public Product(String description, String code) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int compareTo(Product o) {
		return this.description.compareTo(o.description);

	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description + ", nr= " + nr + "]";
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

}
