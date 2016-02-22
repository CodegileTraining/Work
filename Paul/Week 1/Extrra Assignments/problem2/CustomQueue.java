package com.codegile.week1.extra.problem2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class CustomQueue<E> implements Queue<E> {

  @SuppressWarnings("unchecked")
  private E[] queue = (E[]) new Object[0];

  @Override
  public int size() {
    return queue.length;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public boolean contains(Object o) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object[] toArray() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> T[] toArray(T[] a) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean remove(Object o) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    // TODO Auto-generated method stub
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
  public void clear() {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean add(Object e) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean offer(E e) {
    @SuppressWarnings("unchecked")
    E[] queue2 = (E[]) new Object[queue.length + 1];

    System.arraycopy(queue, 0, queue2, 0, queue.length);
    queue2[queue.length] = e;
    queue = queue2;
    return true;
  }

  @Override
  public E remove() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public E poll() {
    E e = peek();
    @SuppressWarnings("unchecked")
    E[] queue2 = (E[]) new Object[queue.length - 1];

    System.arraycopy(queue, 1, queue2, 0, queue.length - 1);
    queue = queue2;

    return e;
  }

  @Override
  public E element() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      return null;
    }
    return queue[0];
  }

  @Override
  public String toString() {
    String text = "";
    for (E e : queue) {
      text += e + " ";
    }
    return text;
  }

}
