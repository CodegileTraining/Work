package Day3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BubbleQuick {

	static Random rand = new Random();
	static int n = rand.nextInt(200);
	static Queue<QuickSortStep> qsSteps=new LinkedList<QuickSortStep>();

	public static void  writeVector(int[] vector){
		for (int i = 0; i < vector.length; i++)
			System.out.print(vector[i] + " ");
		System.out.println();
	}
	public static boolean bubbleSort(int[] vector) {
		boolean ok = true;
		for (int i = 0; i < vector.length - 1; i++) {
			if (vector[i] > vector[i + 1]) {
				int aux = vector[i];
				vector[i] = vector[i + 1];
				vector[i + 1] = aux;
				ok = false;
			}
		}
		return ok;
	}

	public static boolean quickSort(QuickSortStep step) {
		int[] vector=step.getVector();
		int left=step.getLeft();
		int right=step.getRight();

		if (vector == null || vector.length == 0 || vector.length == 1)
			return true;
		if (left >= right)
			return true;

		int i = left;
		int j = right;
		int pivot = vector[(left + right) / 2];

		while (i <= j) {
			while (vector[i] < pivot)
				i++;
			while (vector[j] > pivot)
				j--;

			if (i <= j) {
				int aux = vector[i];
				vector[i] = vector[j];
				vector[j] = aux;
				i++;
				j--;
			}
		}
		if(left<i-1)
			qsSteps.add(new QuickSortStep(vector, left, i-1));
		if(i<right)
			qsSteps.add(new QuickSortStep(vector, i, right));
		return false;

	}

	public static void main(String[] args) {

		Random rand = new Random();
		int n =rand.nextInt(200);
		int[] bubbleVect = new int[n];
		int[] quickVect = new int[n];
		for (int i = 0; i < n; i++) {
			bubbleVect[i] = rand.nextInt(1000) + 1;
			quickVect[i] = bubbleVect[i];
		}
		boolean bubbleOK = false;
		boolean quickOK=false;
		qsSteps.add(new QuickSortStep(quickVect, 0, quickVect.length-1));

		while (!(bubbleOK && quickOK)) {

			if(!bubbleOK){
				bubbleOK = bubbleSort(bubbleVect);
			}
			if(!quickOK){
				if(!qsSteps.isEmpty())
					quickOK=quickSort(qsSteps.poll());
				else
					quickOK=true;
			}

		}
		System.out.println("Bubble Vect: ");
		writeVector(bubbleVect);
		System.out.println("Quick Vect: ");
		writeVector(quickVect);
	}
}