package pack.puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Algorithm {
	static Queue<Node> fringe = new LinkedList<>();
	private static Set<State> closed = new HashSet<>();
	static Node first;
	static int n = 0;
	static int[][] mat;

	static int[][] SOLUTION;
	static State finalState;

	public static void read() {

		File file = new File("fisier.txt");

		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(file);
			n = sc.nextInt();
			sc.nextLine();

			mat = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					mat[i][j] = sc.nextInt();
				}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void initSolution() {

		SOLUTION = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				SOLUTION[i][j] = i * n + j + 1;
			}
		}

		finalState = new State(SOLUTION, n);
	}

	public static void solvePuzzle() {

		first = new Node(new State(mat, n), null, 0);

		fringe.offer(first);
		System.out.println(fringe.peek());

		if (first.isFinal()) {
			System.out.println(first);
			return;
		}
		closed.add(fringe.peek().getState());
		System.out.println();
		while (fringe.peek() != null) {
			Node current = fringe.poll();
			for (Node n : current.getNextNodes()) {
				if (n.getState().isFinal()) {
					printSteps(n);
					return;
				}
				System.out.println();

				if (closed.add(n.getState()) == true) {
					fringe.offer(n);
				}
			}

		}

	}

	private static void printSteps(Node n) {
		List<Node> nodes = new ArrayList<>();
		
		do {
		nodes.add(n);
		n = n.getParentNode();
		} while (n != null);
		
		for(int i = nodes.size() - 1; i >= 0; i--) {
			System.out.println(nodes.get(i));
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
		}
	}

	public static void main(String[] args) {
		read();
		initSolution();
		solvePuzzle();

	}
}
