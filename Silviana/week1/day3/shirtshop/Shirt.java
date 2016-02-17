package shirtshop;

public class Shirt implements Comparable<Shirt>{
	private String id;
	private String description;
	private String color;
	private int size;
	private int nrpieces;
	public Shirt(String id, String description, String color, int size, int nrpieces) {
		
		this.id = id;
		this.description = description;
		this.color = color;
		this.size = size;
		this.nrpieces = nrpieces;
	}

	public String getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public String getColor() {
		return color;
	}
	public int getSize() {
		return size;
	}
	public int getNrpieces() {
		return nrpieces;
	}
	public void setNrpieces(int nrpieces) {
		this.nrpieces = nrpieces;
	}
	@Override
	public String toString() {
		return "Shirt [id=" + id + ", description=" + description + ", color=" + color + ", size=" + size
				+ ", nrpieces=" + nrpieces + "]";
	}
	
	  public int compareTo(Shirt other){
	      
	        int desc = this.description.compareTo(other.description);
	        return desc;
	    }
	
	

}
