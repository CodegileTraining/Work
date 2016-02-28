package Week2.Interfaces;

import Week2.MyListInterface.MyListInterface;

public class MyListInterface_Implem<T> implements MyListInterface<T> {

	@SuppressWarnings("unchecked")
	private T[] array = (T[]) new Object[0];

	@Override
	public boolean add(T e) {
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) new Object[array.length + 1];
		for (int i = 0; i < array.length; i++)
			aux[i] = array[i];
		aux[aux.length - 1] = e;
		array = aux;
		return true;
	}

	@Override
	public boolean remove(T e) {
		@SuppressWarnings("unchecked")
		T[] copy = (T[]) new Object[array.length - 1];
		if (this.contains(e)) {
			int index = this.indexOf(e);
			int i = 0;
			for (i = 0; i < index; i++)
				copy[i] = array[i];
			for (int j = index + 1; j < array.length; j++)
				copy[i++] = array[j];
			array = copy;
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (array.length == 0)
			return true;
		return false;
	}

	@Override
	public boolean contains(T e) {
		for (T elem : array)
			if (elem.equals(e))
				return true;
		return false;
	}

	@Override
	public int indexOf(T e) {
		for (int i = 0; i < array.length; i++)
			if (array[i].equals(e))
				return i;
		return -1;
	}

	@SuppressWarnings("null")
	public static void main(String[] s) {
		MyListInterface<Integer> i = null;
		// Metodele sunt publice in interfata!!!
		i.add(3);
	}

	public void setX() {
		// Interfaces field is final!!!
		// this.x=2;
	}

}
