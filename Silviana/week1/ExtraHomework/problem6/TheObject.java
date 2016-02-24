package problem6;
/**
 * This is the main class
 * @author Silviana
 *
 */
public class TheObject {

	private int dimension;
	private String color;

	public TheObject(int dimension, String color) {
		super();
		this.dimension = dimension;
		this.color = color;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
