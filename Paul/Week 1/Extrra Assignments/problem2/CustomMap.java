package com.codegile.week1.extra.problem2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomMap<K, V> implements Map<K, V> {

  private Set<K> keys = new LinkedHashSet<>();
  private List<V> values = new ArrayList<>();

  @Override
  public int size() {
    return keys.size();
  }

  @Override
  public boolean isEmpty() {
    return keys.isEmpty();
  }

  @Override
  public boolean containsKey(Object key) {
    return keys.contains(key);
  }

  @Override
  public boolean containsValue(Object value) {
    return values.contains(value);
  }

  @Override
  public V get(Object key) {
    if (!keys.contains(key)) {
      return null;
    }

    Object[] k = keys.toArray();

    for (int i = 0; i < k.length; i++) {
      if (k[i].equals(key)) {
        return values.get(i);
      }
    }

    return null;
  }

  @Override
  public V put(K key, V value) {
    Object[] k = keys.toArray();
    V oldValue = null;

    for (int i = 0; i < k.length; i++) {
      if (k[i].equals(key)) {
        oldValue = values.get(i);
        values.set(i, value);
        break;
      }
    }

    if (oldValue == null) {
      keys.add(key);
      values.add(value);
    }

    return oldValue;
  }

  @Override
  public V remove(Object key) {
    Object[] k = keys.toArray();
    V oldValue = null;

    for (int i = 0; i < k.length; i++) {
      if (k[i].equals(key)) {
        keys.remove(key);
        oldValue = values.remove(i);
        break;
      }
    }

    return oldValue;
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
    for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
      put(entry.getKey(), entry.getValue());
    }
  }

  @Override
  public void clear() {
    keys.clear();
    values.clear();
  }

  @Override
  public Set<K> keySet() {
    return keys;
  }

  @Override
  public Collection<V> values() {
    return values;
  }

  @Override
  public Set<java.util.Map.Entry<K, V>> entrySet() {
    Map<K, V> map = new HashMap<>(this);

    return map.entrySet();
  }

}
