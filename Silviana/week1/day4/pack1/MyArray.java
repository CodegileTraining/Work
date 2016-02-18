package pack1;

import java.util.ArrayList;
import java.util.Iterator;


public class MyArray<T> extends ArrayList<T> {

	private static final long serialVersionUID = 1L;
	private static Iterator<Integer> it1;
	private static Iterator<Integer> it2;
	private static Iterator<Integer> it;

	public Iterator<T> normalIterator() {
		return new NormalIterator<>(0, this);
	}

	public Iterator<T> twoIterator() {
		return new TwoIterator<>(0, this);
	}

	public Iterator<T> firstLastIterator() {
		return new FirstLastIterator<>(0, this.size(), this);
	}

	public static void main(String[] args) {
		MyArray<Integer> array = new MyArray<>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
		array.add(6);

		it = array.normalIterator();
		System.out.print("After normal iterations: ");
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();

		it1 = array.twoIterator();
		System.out.print("After two by two iterations: ");
		while (it1.hasNext())
			System.out.print(it1.next() + " ");
		System.out.println();

		it2 = array.firstLastIterator();
		System.out.print("After first last iterations: ");
		while (it2.hasNext())
			System.out.print(it2.next() + " ");
		System.out.println();

	}

}
