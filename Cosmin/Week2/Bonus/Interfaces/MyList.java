package Week2.Interfaces;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;;

public class MyList<T> implements List<T> {

	private int size = 0;
	@SuppressWarnings("unchecked")
	private T[] array = (T[]) new Object[20];

	@Override
	public boolean add(T e) {

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

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for (T elem : c)
			this.add(elem);
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.array = (T[]) new Object[20];
		this.size = 0;
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
	public T get(int index) {
		if (index > 0 && index < size)
			return this.array[index];
		return null;
	}

	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < size; i++)
			if (array[i].equals(o))
				return i;
		return -1;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public Iterator<T> iterator() {

		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = -1;
		for (int i = 0; i <size; i++)
			if (array[i].equals(o))
				index = i;
		return index;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		
		if (this.contains(o)) {
			int index = this.indexOf(o);
			for(int i=index;i<size-1;i++)
				array[i]=array[i+1];
			size--;
			return true;
		}
		return false;
	}

	@Override
	public T remove(int index) {
		this.remove(array[index]);
		return null;
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
	public T set(int index, T element) {

		if (index >= 0 && index < size) {
			T elem = array[index];
			array[index] = element;
			return elem;
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		if ((fromIndex > 0 && fromIndex < size) && (toIndex > 0 && toIndex < size)) {
			List<T> subList = new MyList<>();
			for (int i = fromIndex; i < toIndex; i++)
				subList.add(array[i]);
			return subList;
		}
		return null;
	}

	@Override
	public Object[] toArray() {
		return (Object[]) array;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	@Override
	public <T> T[] toArray(T[] a) {
		return (T[]) array;

	}
}
