package Iterator;

import java.util.Iterator;

/**
 * This class implements an iterator that steps every two elements
 * 
 * @author Margarit
 *
 */
public class Iterator2x2<T> implements Iterator<T> {

	private MyArrayList<T> myArray;
	private int index;

	public Iterator2x2(MyArrayList<T> myArray) {
		this.myArray = myArray;
		index = 0;
	}

	@Override
	public boolean hasNext() {
		return index < myArray.size();
	}

	@Override
	public T next() {
		T value = myArray.get(index);
		index += 2;
		return value;
	}

	public void print() {

		while (hasNext()) {
			System.out.print(next() + " ");
		}

		System.out.println();
	}
}
