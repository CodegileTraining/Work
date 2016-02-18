package pack1;

import java.util.Iterator;

public class NormalIterator<T> implements Iterator<T> {
	private int next;
	private MyArray<T> array;

	public NormalIterator(int next, MyArray<T> array) {
		this.next = next;
		this.array = array;
	}

	public boolean hasNext() {

		if (next<array.size())
			return true;
		else
			return false;
	}

	public T next() {

		return array.get(next++);
	}

	public void remove() {
		System.out.println("Remove is not necessary.");

	}

}
