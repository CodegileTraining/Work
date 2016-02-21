package pack2;
/**
 * 		Contains all informations for a gift offered to an {@Employee}.
 * @author Silviana
 *
 */
public class Bonus {
	private int pieces;
	private String description;
	private String data;
	private Employee owner;

	public Bonus(int pieces, String data) {
		this.pieces = pieces;
		this.data = data;
	}

	public Bonus() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String d) {
		description = d;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Bonus [pieces=" + pieces + ", data=" + data + "]";
	}

}
