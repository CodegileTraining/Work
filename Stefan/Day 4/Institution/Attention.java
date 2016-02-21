/**
 * Structure for attentions
 * Contains value , IDemployee and month
 * @author Stefan
 *
 */
public class Attention {

	private int value;
	private int IDemployee;
	private String month;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getIDemployee() {
		return IDemployee;
	}

	public void setIDemployee(int iDemployee) {
		IDemployee = iDemployee;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Attention [value=" + value + ", IDemployee=" + IDemployee + ", month=" + month + "]";
	}

	public Attention(int value, int iDemployee, String month) {
		
		this.value = value;
		IDemployee = iDemployee;
		this.month = month;
	}
	
}
