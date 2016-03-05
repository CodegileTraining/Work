package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

	private HashSet<State> closed = new HashSet<>();
	private static Queue<Node> fringe = new LinkedList<>();
	private static Scanner sc;
	private static Scanner sc1;
	public static int matrix[][];
	public static int validMatrix[][];

	public HashSet<State> getClosed() {
		return closed;
	}

	public Queue<Node> getFringe() {
		return fringe;
	}

	public void initMatrix() {
		File file = new File("file.txt");
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int n;
		n = sc.nextInt();
		matrix = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt();
			}
	}

	public static void initValidMatrix() {
		File file = new File("fileValidMatrix");

		try {
			sc1 = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int n;
		n = sc1.nextInt();
		validMatrix = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				validMatrix[i][j] = sc1.nextInt();

	}

	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();

		}
	}

	public static int findI(Node node) throws Exception {
		for (int i = 0; i < node.getState().getN(); i++)
			for (int j = 0; j < node.getState().getN(); j++)
				if (node.getState().getConfig()[i][j] == 999999)
					return i;
		throw new Exception();
	}

	public static int findJ(Node node) throws Exception {
		for (int i = 0; i < node.getState().getN(); i++)
			for (int j = 0; j < node.getState().getN(); j++)
				if (node.getState().getConfig()[i][j] == 999999)
					return j;
		throw new Exception();
	}

	public static int isValid(Node firstNode) {
		if (Arrays.deepEquals(validMatrix, firstNode.getState().getConfig()))
			return 1;
		return 0;

	}

	public static void calculateChildren(Node node) {
		try {
			int i = findI(node);
			int j = findJ(node);
			node.calculateNext(i, j);
		} catch (Exception e) {
			System.out.println("UPS");
		}

	}

	public Node begin() {
		State ss = new State(matrix.length, matrix);
		Node firstNode = new Node(ss, null, 0);
		fringe.offer(firstNode);
		
		while (fringe.peek() != null) {
			Node node = fringe.poll();
			calculateChildren(node);
			for (State s : node.getNext()) {
				Node n = new Node(s, node, node.getCost() + 1);

				if (isValid(n) == 1) {
					System.out.println("We have the final state!");
					return n;
				}
				if (closed.add(n.getState())) {
					fringe.offer(n);
				}

			}
		}
		return null;
	}

}
