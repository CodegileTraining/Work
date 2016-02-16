package pack2;

public class Employee {
	private int id;
	private String name;
	private String surname;
	private String ssn;

	public Employee(int id, String name, String surname, String ssn) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.ssn = ssn;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getSsn() {
		return ssn;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getYear(String ssn) {
		int year = 1 * 1000 + 9 * 100 + ssn.charAt(1) * 10 + ssn.charAt(2);
		return year;
	}

	public int getAge() {
		int year = 1 * 1000 + 9 * 100 + ssn.charAt(1) * 10 + ssn.charAt(2);
		return 2016 - year;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", ssn=" + ssn + "]";
	}

}
