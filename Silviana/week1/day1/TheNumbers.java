package pack1;

import java.util.Scanner;

public class TheNumbers {

	private static Scanner sc;

	public static void afisare(int nrint, int nreal)
	{
		System.out.println("Numarul de nr intregi: " + nrint);
		System.out.println("Numarul de nr reale: " + nreal);
	}
	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int n, i = 0;
		n = sc.nextInt();
		double[] v = new double[n];
		while (i != n) {
			try {

				v[i++] = Double.parseDouble(sc.next());

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}

		int nrint = 0, nreal = 0;
		for (int j = 0; j < i; j++) {
			if (v[j] == (int) v[j])
				nrint++;
			else
				nreal++;
		}
	
		afisare(nrint,nreal);
	}

}
