package Week2.Interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyMap<K, V> implements Map<K, V> {

	private Set<K> keys = new HashSet<>();
	private List<V> values = new ArrayList<>();

	@Override
	public void clear() {
		keys = new HashSet<K>();
		values = new ArrayList<V>();
	}

	@Override
	public boolean containsKey(Object key) {
		for (K elem : keys)
			if (elem.equals(key))
				return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean containsValue(Object value) {
		for (V elem : values)
			if (elem.equals((V) value))
				return true;
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Map<K, V> entryMap = new HashMap<>();
		return entryMap.entrySet();

	}

	@Override
	public V get(Object key) {
		Object[] keys = this.keys.toArray();
		for (int i = 0; i < keys.length; i++)
			if (keys[i].equals(key))
				return values.get(i);
		return null;
	}

	@Override
	public boolean isEmpty() {
		return keys.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return keys;
	}

	@Override
	public V put(K key, V value) {
		if (this.keys.contains(key)) {
			Object[] keys = this.keys.toArray();
			for (int i = 0; i < keys.length; i++)
				if (keys[i].equals(key))
					values.set(i, value);
		} else
			keys.add(key);
		values.add(value);
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (Map.Entry<? extends K, ? extends V> elem : m.entrySet()) {
			this.put(elem.getKey(), elem.getValue());
		}

	}

	@Override
	public V remove(Object key) {
		Object[] keys = this.keys.toArray();
		V oldValue=null;
		for (int i = 0; i < keys.length; i++)
			if (keys[i].equals(key)){
				this.keys.remove(keys[i]);
				oldValue=values.get(i);
				this.values.remove(i);
			}
		return oldValue;
	}

	@Override
	public int size() {
		return keys.size();
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
