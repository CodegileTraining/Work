package Day4;
/**
 * This Class defines the structure of a shirt
 * @author Margarit
 *
 */
public class Shirt {

	private static int idCount = 1;
	private int id;
	private String description;
	private String color;
	private String size;
	private int quantity;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int q) {
		this.quantity = q;
	}

	public Shirt(String description, String color, String size, int quantity) {
		this.id = idCount++;
		this.description = description;
		this.color = color;
		this.size = size;
		this.quantity = quantity;

	}

	@Override
	public String toString() {
		return "Shirt [id=" + id + ", description=" + description + ", color=" + color + ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Shirt other = (Shirt) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

}
