package pack1;

public class Product {
	private String code;
	private String description;
	private int numAparitions;
	public Product(String code, String description, int numAparitions) {
		super();
		this.code = code;
		this.description = description;
		this.numAparitions = numAparitions;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumAparitions() {
		return numAparitions;
	}
	public void setNumAparitions(int numAparitions) {
		this.numAparitions = numAparitions;
	}
	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description + ", numAparitions=" + numAparitions + "]";
	}
	
	

}
