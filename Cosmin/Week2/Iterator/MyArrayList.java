package Iterator;

import java.util.ArrayList;

/**
 * This class specifies a custom array list
 * 
 * @author Margarit
 *
 * @param <T>
 */
public class MyArrayList<T> extends ArrayList<T> {

	private static final long serialVersionUID = 1L;
	ArrayList<T> array;

	/**
	 * This is the main function which builds an array of type MyArraylist and
	 * then tests each iterator.
	 */
	public static void main(String[] args) {
		MyArrayList<Integer> array = new MyArrayList<>();
		for (int i = 0; i < 21; i++)
			array.add(i);

		System.out.println("myArray:");
		for (int i : array)
			System.out.print(i + " ");
		System.out.println();

		System.out.println("Iterator1x1:");
		Iterator1x1<Integer> it = new Iterator1x1<>(array);
		it.print();

		System.out.println("Iterator2x2:");
		Iterator2x2<Integer> it2 = new Iterator2x2<>(array);
		it2.print();

		System.out.println("IteratorFirstxLast:");
		IteratorFirstxLast<Integer> it3 = new IteratorFirstxLast<>(array);
		it3.print();
	}
}
