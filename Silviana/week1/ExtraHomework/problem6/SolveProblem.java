package problem6;

public class SolveProblem {
	public static void main(String[] args) {

		WritingObject ob = new WritingObject(2, "red");
		ob.namePen();
		ob.stockpilePen();
		ob.namePencil();
		ob.stockpilePencil();
		ob.nameStick();
		ob.stockpileStick();

		ob.setThickness(5);
		System.out.println();

		ob.penMethod(ob);
		System.out.println();

		ob.pencilMethod(ob);
		System.out.println();

		ob.stickMethod(ob);
		System.out.println();

		ob.writingUtensilMethod(ob);
		System.out.println();

		System.out.println("The object has " + ob.getDimension() + " cm in length , is " + ob.getColor()
				+ " and has thickness = " + ob.getThickness());

	}
}
