package pack1;

import java.util.Iterator;

public class FirstLastIterator<T> implements Iterator<T> {
	private int first, last;
	private MyArray<T> array;
	private static int ok = 1;

	public FirstLastIterator(int first, int last, MyArray<T> array) {
		this.first = first;
		this.last = last;
		this.array = array;
	}

	public boolean hasNext() {

		if (first<last)
			return true;
		else
			return false;
	}

	public T next() {
	

		if (ok == 1){
			ok=0;
			return array.get(first++);
		}
			
		else
		{
			ok=1;
			int x=last-1;
			last--;
			return array.get(x);
		}
		
	}

	public void remove() {
		System.out.println("Remove is not necessary.");

	}

}
