package com.codegile.week1.extra.problem2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CustomSet<T> implements Set<T> {

  private List<T> array = new ArrayList<>();

  @Override
  public int size() {
    return array.size();
  }

  @Override
  public boolean isEmpty() {
    return array.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return array.contains(o);
  }

  @Override
  public Iterator<T> iterator() {
    return array.iterator();
  }

  @Override
  public Object[] toArray() {
    return array.toArray();
  }

  @Override
  public <E> E[] toArray(E[] a) {
    return array.toArray(a);
  }

  @Override
  public boolean add(T e) {
    if (array.contains(e)) {
      return false;
    }

    array.add(e);
    return true;
  }

  @Override
  public boolean remove(Object o) {
    if (!array.contains(o)) {
      return false;
    }

    array.remove(o);
    return true;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return array.containsAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    return array.addAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return array.retainAll(c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return array.removeAll(c);
  }

  @Override
  public void clear() {
    array.clear();
  }

  @Override
  public String toString() {
    return array.toString();
  }

}
