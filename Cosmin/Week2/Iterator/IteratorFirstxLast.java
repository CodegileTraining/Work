package Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorFirstxLast<T> implements Iterator<T> {

	private static int ok = 0;
	private int first;
	private int last;
	private MyArrayList<T> myArray;

	public IteratorFirstxLast(MyArrayList<T> myArray) {
		this.first = 0;
		this.last = myArray.size() - 1;
		this.myArray = myArray;
	}

	@Override
	public boolean hasNext() {
		return first <= last;
	}

	@Override
	public T next() {
		T t = null;
		if (hasNext()) {
			switch (ok) {
			case 0:
				ok = 1 - ok;
				t = myArray.get(first++);
				break;
			case 1:
				t = myArray.get(last--);
				ok = 1 - ok;
				break;
			}
		}
		if (t != null)
			return t;
		else
			throw new NoSuchElementException("There are no more elements!");
	}

	public void print() {
		while (hasNext())
			System.out.print(next() + " ");
		System.out.println();
	}
}
