package pack2;

import pack1.Shape;

public class Square implements Shape {

	@Override
	public void arie() {
		System.out.println("square.arie()");
		
	}

	@Override
	public void perim() {
		System.out.println("square.perim()");
		
	}

	@Override
	public void what() {
		System.out.println("Acesta este un patrat.");
		
	}

}
