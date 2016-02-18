import java.util.Iterator;

public class Iterator3<T> implements Iterator<T> {

	private MyArrayList<T> list;
	private int i;
	private int j;
	private int ok = 1;

	public Iterator3(MyArrayList<T> list) {
		this.list = list;
		this.i = 0;
		this.j = list.size() - 1;
	}

	@Override
	public boolean hasNext() {

		return i <= j;

	}

	@Override
	public T next() {

		if (ok == 1) {
			ok = 0;
			return list.get(i++);

		} else {
			ok = 1;
			return list.get(j--);

		}
	}

	@Override
	public void remove() {

	}
}