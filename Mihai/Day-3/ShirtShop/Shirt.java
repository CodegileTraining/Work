

public class Shirt implements Comparable<Shirt> {

	String name;
	String id;
	String color;
	String size;
	int number;

	public Shirt(String id, String name, String color, String size) {
		number = 1;
		this.name = name;
		this.id = id;
		this.color = color;
		this.size = size;
	}
	public String getID(){
		return id;
	}
	public void setNumber(int n) {
		this.number = n;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}
	public String toString(){
		return id+" "+name+" "+color+" "+size+" "+number+"\n";
	}
	@Override
	public int compareTo(Shirt o) {
		return name.compareTo(o.getName());
	}

}
