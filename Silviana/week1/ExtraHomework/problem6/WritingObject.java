package problem6;

/**
 * This is the class which extends the "bigclass" @TheObject and implements the
 * interface @WritingUtensil
 * 
 * @author Silviana
 *
 */
public class WritingObject extends TheObject implements WritingUtensil {

	private int thickness;

	public WritingObject(int dimension, String color) {
		super(dimension, color);
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	@Override
	public void namePen() {
		System.out.println("thePen");

	}

	@Override
	public void stockpilePen() {
		System.out.println("thePen has gel");

	}

	@Override
	public void namePencil() {
		System.out.println("thePencil");

	}

	@Override
	public void stockpilePencil() {
		System.out.println("thePencil has mine");

	}

	@Override
	public void nameStick() {
		System.out.println("theStick");

	}

	@Override
	public void stockpileStick() {
		System.out.println("theStick has ink");

	}

	@Override
	public void resistence() {
		System.out.println("all have resistence");

	}

	public void penMethod(Pen p) {
		System.out.println("begin of penMethod: ");
		p.namePen();
		p.stockpilePen();
		System.out.println("end of penMethod");
	}

	public void pencilMethod(Pencil pc) {
		System.out.println("begin of pencilMethod: ");
		pc.namePencil();
		pc.stockpilePencil();
		System.out.println("end of pencilMethod");
	}

	public void stickMethod(Stick s) {
		System.out.println("begin of stickMethod: ");
		s.nameStick();
		s.stockpileStick();
		System.out.println("end of stickMethod");
	}

	public void writingUtensilMethod(WritingUtensil u) {
		System.out.println("begin of writingUtensilMethod: ");
		u.resistence();
		u.namePen();
		u.namePencil();
		u.nameStick();
		System.out.println("end of writingUtensilMethod");
	}

}
