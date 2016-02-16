import java.util.Scanner;

public class Numere {

	private static Scanner sc;

	public static void main(String[] args) {

		int n;
		int nrInt = 0;
		int nrRe = 0;
		sc = new Scanner(System.in);

		System.out.println("Introduceti n = ");
		n = sc.nextInt();

		double[] num = new double[n];

		for (int i = 0; i < n; i++) {

			System.out.print("num[" + i + "]= ");
			num[i] = Double.parseDouble(sc.next());

		}
		System.out.println();

		
		for (int i = 0; i < n; i++)
			if (num[i] == (int) num[i])
				nrInt++;

		nrRe = n - nrInt;
		System.out.println("Numere Intregi:" + nrInt);
		System.out.println("Numere Reale:" + nrRe);
	}
}
