package pack2;

import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {

	private static Scanner sc;

	public static void randomGeneration(int[] v, int n) {
		Random rand = new Random();
		for (int i = 0; i < n; i++)
			v[i] = rand.nextInt(1000);
	}

	public static void transferElements(int[] v, int[] u, int n) {
		for (int i = 0; i < n; i++)
			u[i] = v[i];
	}

	public static void bubbleSort(int[] v, int n) {
		for (int i = 0; i < n - 1; i++)
			for (int j = i; j < n; j++)
				if (v[i] > v[j]) {

					int aux = v[i];
					v[i] = v[j];
					v[j] = aux;
				}

	}

	public static int partition(int u[], int left, int right) {
		int i = left, j = right;
		int aux;
		int pivot = u[(left + right) / 2];

		while (i <= j) {
			while (u[i] < pivot)
				i++;
			while (u[j] > pivot)
				j--;
			if (i <= j) {
				aux = u[i];
				u[i] = u[j];
				u[j] = aux;
				i++;
				j--;
			}
		}

		return i;
	}

	public static void quickSort(int u[], int left, int right) {
		int index = partition(u, left, right);
		if (left < index - 1)
			quickSort(u, left, index - 1);
		if (index < right)
			quickSort(u, index, right);
	}

	public static void viewVectors(int[] v, int[] u, int n) {
		System.out.println();
		System.out.print("Sirul v: ");
		for (int i = 0; i < n; i++)
			System.out.print(v[i] + " ");
		System.out.println();
		System.out.print("Sirul u: ");
		for (int i = 0; i < n; i++)
			System.out.print(u[i] + " ");
	}

	public static void main(String[] args) {

		int v[], n, u[];
		sc = new Scanner(System.in);
		n = sc.nextInt();
		v = new int[n];
		u = new int[n];

		randomGeneration(v, n);
		transferElements(v, u, n);

		bubbleSort(v, n);
		viewVectors(v, u, n);

		quickSort(u, 0, n - 1);
		viewVectors(v, u, n);

	}
}
