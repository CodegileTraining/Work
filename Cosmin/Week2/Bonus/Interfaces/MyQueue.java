package Week2.Interfaces;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MyQueue<E> implements Queue<E> {

	@SuppressWarnings("unchecked")
	private E[] array = (E[]) new Object[20];
	private int size = 0;

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		array = (E[]) new Object[20];

	}

	@Override
	public boolean contains(Object o) {
		for (Object elem : array)
			if (elem.equals(o))
				return true;
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object elem : array)
			if (!contains(elem))
				return false;
		return true;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
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

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		return (T[]) array;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(E e) {
		if (size == array.length) {
			@SuppressWarnings("unchecked")
			E[] aux = (E[]) new Object[array.length * 2];
			for (int i = 0; i < size; i++)
				aux[i] = array[i];
			aux[size++] = e;
			array = aux;
		} else
			array[size++] = e;
		return true;
	}

	@Override
	public E peek() {
		if (array != null)
			return array[0];
		else
			return null;
	}

	@Override
	public E poll() {
		E first = this.peek();
		if (first != null) {
			for (int i = 0; i < size - 1; i++)
				array[i] = array[i + 1];
			size--;
		}
		return first;
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

}
