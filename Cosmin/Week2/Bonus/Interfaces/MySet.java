package Week2.Interfaces;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet<T> implements Set<T> {

	private int size = 0;
	@SuppressWarnings("unchecked")
	private T[] array = (T[]) new Object[20];

	@Override
	public boolean add(T e) {

		if (!this.contains(e)) {
			if (size == array.length) {
				@SuppressWarnings("unchecked")
				T[] aux = (T[]) new Object[array.length * 2];
				for (int i = 0; i < size; i++)
					aux[i] = array[i];
				aux[size++] = e;
				array = aux;
			} else
				array[size++] = e;
			return true;
		}
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for (T elem : c)
			this.add(elem);
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		array = (T[]) new Object[20];

	}

	@Override
	public boolean contains(Object o) {
		for (T elem : array)
			if (elem.equals(o))
				return true;
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object elem : c)
			if (!this.contains(elem))
				return false;
		return true;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public int indexOf(Object o) {
		for (int i = 0; i < size; i++)
			if (array[i].equals(o))
				return i;
		return -1;
	}

	@Override
	public boolean remove(Object o) {

		if (this.contains(o)) {
			int index = this.indexOf(o);
			for (int i = index; i < size - 1; i++)
				array[i] = array[i + 1];
			size--;
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for (Object elem : c)
			remove(elem);
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		return array;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	@Override
	public <T> T[] toArray(T[] a) {
		return (T[]) array;
	}

}
