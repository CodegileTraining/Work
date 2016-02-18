import java.util.Iterator;

public class MyIterator<Type> implements Iterable<Type> {

	Type[] arraylist;
	int size;

	public MyIterator(Type[] arrayList) {
		this.arraylist = arrayList;
		this.size = arrayList.length;
	}

	public Iterator<Type> iterator() {
		Iterator<Type> it = new Iterator<Type>() {

			int index = 0;

			public boolean hasNext() {
				return index < size;
			}

			public Type next() {

				return arraylist[index++];
			}

		};
		return it;

	}

	public Iterator<Type> iterator(int x) {
		Iterator<Type> it = new Iterator<Type>() {

			int index = 0;

			public boolean hasNext() {
				return index < size;
			}

			@Override
			public Type next() {
				int returnIndex = index;
				index += 2;
				return arraylist[returnIndex];
			}

		};
		return it;
	}

	public Iterator<Type> iterator(String x) {
		Iterator<Type> it = new Iterator<Type>() {

			int indexFirst = 0;
			int ok = 0;
			int indexLast = size - 1;

			public boolean hasNext() {
				if (indexFirst > indexLast)
					return false;
				return true;
			}

			@Override
			public Type next() {

				if (ok == 0) {
					ok = 1;
					return arraylist[indexFirst++];
				} else {
					ok = 0;
					return arraylist[indexLast--];
				}
			}

		};
		return it;

	}

	public static void main(String[] arg) {
		Integer numbers[] = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		MyIterator<Integer> ob = new MyIterator<Integer>(numbers);
		Iterator<Integer> it = ob.iterator("something");
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}

	}
}
