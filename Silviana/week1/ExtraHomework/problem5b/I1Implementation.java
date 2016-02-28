package problem5b;

import problem5a.I1;

/**
 * The methods in the interface I1 are public because they can be seen from
 * another package and implemented there.
 * 
 * @author Silviana
 *
 */
public class I1Implementation implements I1 {

	@Override
	public void print1() {
		System.out.println("First print");

	}

	@Override
	public void print2() {
		System.out.println("Second print");

	}

	@Override
	public void print3() {
		System.out.println("Third print");

	}

}
