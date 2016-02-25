package Iterator;

import java.util.Iterator;

/**
 * This class implements a normal iterator.
 * 
 * @author Margarit
 *
 */
public class Iterator1x1<T> implements Iterator<T> {

	private MyArrayList<T> myArray;
	private int index;

	public Iterator1x1(MyArrayList<T> myArray) {
		this.myArray = myArray;
		index = 0;
	}

	@Override
	public boolean hasNext() {
		return index < (myArray.size());
	}

	@Override
	public T next() {

		return myArray.get(index++);
	}

	public void print() {
		while (hasNext()) {
			System.out.print(next() + " ");
		}

		System.out.println();
	}
}
