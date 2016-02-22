package com.codegile.week1.extra.problem2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomList<E> implements List<E> {

  @SuppressWarnings("unchecked")
  private E[] array = (E[]) new Object[0];

  @Override
  public int size() {
    return array.length;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public boolean contains(Object o) {
    for (Object o1 : array) {
      if (o1.equals(o)) {
        return true;
      }
    }
    return false;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Iterator<E> iterator() {
    List<E> list = new ArrayList<>();

    for (Object o : array) {
      list.add((E) o);
    }

    return list.iterator();
  }

  @Override
  public Object[] toArray() {
    return array;
  }

  @Override
  public <T> T[] toArray(T[] a) {
    // TODO
    return null;
  }

  @Override
  public boolean add(E e) {
    @SuppressWarnings("unchecked")
    E[] array2 = (E[]) new Object[array.length + 1];

    System.arraycopy(array, 0, array2, 0, array.length);
    array2[array.length] = e;
    array = array2;
    return true;
  }

  @Override
  public boolean remove(Object o) {
    for (int i = 0; i < array.length; i++) {
      if (array[i].equals(o)) {
        @SuppressWarnings("unchecked")
        E[] array2 = (E[]) new Object[array.length - 1];

        System.arraycopy(array, 0, array2, 0, i);
        System.arraycopy(array, i + 1, array2, i, array.length - i - 1);
        array = array2;
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    for (Object o : c) {
      if (!contains(o)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    for (E e : c) {
      add(e);
    }
    return true;
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> c) {
    // TODO
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    for (Object o : c) {
      remove(o);
    }
    return true;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void clear() {
    array = (E[]) new Object[0];
  }

  @Override
  public E get(int index) {
    return array[index];
  }

  @Override
  public E set(int index, E element) {
    E oldE = array[index];
    array[index] = element;
    return oldE;
  }

  @Override
  public void add(int index, E element) {
    // TODO

  }

  @Override
  public E remove(int index) {
    E oldE = array[index];
    @SuppressWarnings("unchecked")
    E[] array2 = (E[]) new Object[array.length - 1];

    System.arraycopy(array, 0, array2, 0, index);
    System.arraycopy(array, index + 1, array2, index, array.length - index - 1);
    array = array2;

    return oldE;
  }

  @Override
  public int indexOf(Object o) {
    for (int i = 0; i < array.length; i++) {
      if (array[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    for (int i = array.length - 1; i >= 0; i++) {
      if (array[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public ListIterator<E> listIterator() {
    // TODO
    return null;
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    // TODO
    return null;
  }

  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    // TODO
    return null;
  }

  @Override
  public String toString() {
    String text = "";
    for (E e : array) {
      text += e + "\n";
    }
    return text;
  }

}
