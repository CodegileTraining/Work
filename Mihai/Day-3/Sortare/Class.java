import java.util.Random;

public class Class {

	static int[] a = new int[10];
	static int[] b = new int[10];

	public static void fillArray() {
		Random rd = new Random();
		for (int i = 0; i < 10; i++) {

			a[i] = rd.nextInt(1001);
		}
	}

	public static void main(String[] args) {

		fillArray();
		System.arraycopy(a, 0, b, 0, 10);
		QuickSort s = new QuickSort(b);
		Thread d = new Thread(s);
		synchronized (d) {
			d.start();
		}
		boolean ok = true;
		while (ok) {
			ok = false;

			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					int aux = a[j];
					a[j] = a[j+1];
					a[j+1] = aux;
					ok = true;
				}
			}

			for (int l = 0; l < 10; l++)
				System.out.print(a[l] + " ");

			System.out.println();
			System.out.println();
			System.out.println();

			for (int l = 0; l < 10; l++)
				System.out.print(b[l] + " ");
			System.out.println();
			System.out.println();
			System.out.println();
			synchronized (s) {
				s.notifyAll();
			}
		}

	}

}
