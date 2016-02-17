
public class Tshirt implements Comparable<Tshirt> {
	
	String name;
	int q;
	public Tshirt(String name){
		q=1;
		this.name=name;	
	}
	public String getName(){
		return name;
	}
	public int getQ(){
		return q;
	}
	public void setQ(int q){
		this.q=q;
	}
	public String toString(){
		return name+" "+q+"\n";
	}
	public int compareTo(Tshirt o) {
		return this.name.compareTo(o.getName());
	}
}
