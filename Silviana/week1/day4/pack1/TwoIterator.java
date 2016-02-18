package pack1;

import java.util.Iterator;

public class TwoIterator<T> implements Iterator<T> {
	private int next;
	private MyArray<T> array;

	public TwoIterator(int next, MyArray<T> array) {
		this.next = next;
		this.array = array;
	}

	public boolean hasNext() {

		if (next<array.size()-1)
			return true;
		else
			return false;
	}

	public T next() {
       int i=next;
       next+=2;
		return array.get(i);
	}

	public void remove() {
		System.out.println("Remove is not necessary.");

	}

}
