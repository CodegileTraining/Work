import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {

	private static Scanner sc;

	public static void afisare(int[] v) {
		for (int i = 0; i < v.length; i++)
			System.out.print(v[i] + " ");
		System.out.println();
	}

	public static void bubbleSort(int[] v) {

		int aux;

		for (int i = 0; i < v.length - 1; i++) {
			for (int j = i + 1; j < v.length; j++) {
				if (v[i] > v[j]) {
					aux = v[i];
					v[i] = v[j];
					v[j] = aux;

				}
			}

		}

	}

	

	public static int pivot(int[] x, int i, int j) {
		int piv = x[i];
		int aux;
		int k;
		while (i < j) {
			if (x[i] > x[j]) {
				aux = x[i];
				x[i] = x[j];
				x[j] = aux;
			}
			if (x[i] == piv)
				j--;
			else
				i++;
		}
		k = i;
		return k;
	}

	public static void quickSort(int v[], int i, int j) {
		int k;
		if (i < j) {
			k = pivot(v, i, j);
			quickSort(v, i, k - 1);
			quickSort(v, k + 1, j);

		}

	}

	public static void main(String[] args) {

		int n;
		int[] v;
		int[] copy;
		sc = new Scanner(System.in);

		System.out.println("Introduceti n = ");
		n = sc.nextInt();

		v = new int[n];

		Random rand = new Random();

		for (int i = 0; i < n; i++) {

			v[i] = rand.nextInt(1000);

		}

		copy = v.clone();

		System.out.println("Vectorul nesortat");
		afisare(v);

		int ok = 1;
		if (ok == 1)
			bubbleSort(v);
		afisare(v);

		quickSort(v, 0, v.length - 1);
		afisare(v);
	}

}
