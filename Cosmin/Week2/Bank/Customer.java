package Week2.Bank;

public class Customer {

	private String cnp;
	private String name;

	public Customer(String cnp, String name) {
		super();
		this.cnp = cnp;
		this.name = name;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	@Override
	public String toString() {
		return "Customer [cnp=" + cnp + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
