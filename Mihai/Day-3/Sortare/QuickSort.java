
public class QuickSort implements Runnable {

	int[] a;

	public QuickSort(int[] a) {
		this.a = a;
	}

	public int partition(int[] a, int left, int right) {

		int i = left;
		int j = right;
		int pivot = a[(left + right) / 2];
		while (i <= j) {
			while (a[i] < pivot)
				i++;
			while (a[j] > pivot)
				j--;
			if (i <= j) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	public void quicksort(int[] a, int left, int right) {
		int index = partition(a, left, right);
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (left < index - 1)
			quicksort(a, left, index - 1);
		if (right > index)
			quicksort(a, index, right);
	}

	@Override
	public void run() {
		quicksort(a, 0, 9);

	}
}
