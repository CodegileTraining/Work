package pack.puzzle;

import java.util.Arrays;

public class State {

	private int n;
	private int[][] config = new int[n][n];
	private int i0;
	private int j0;

	public State(int[][] config, int n) {
		this.n = n;
		this.setConfig(config);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (config[i][j] == n * n) {
					i0 = i;
					j0 = j;
				}
		config[i0][j0] = n*n;
	}

	public void printMat() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(config[i][j] + " ");
			System.out.println();
		}
	}

	public boolean isFinal() {
		return this.equals(Algorithm.finalState);
	}

	public State cloneSanatate() {
		int[][] aux = new int[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(config[i], 0, aux[i], 0, n);
		}
		State s = new State(aux, n);
		return s;
	}

	public State move(Action ac) {
		switch (ac) {
		case L: {
			if (j0 > 0)
				return moveLeft();
			break;
		}
		case R: {
			if (j0 < n - 1)
				return moveRight();
			break;
		}

		case U: {
			if (i0 > 0)
				return moveUp();
			break;
		}
		case D: {
			if (i0 < n - 1)
				return moveDown();
			break;

		}

		default:
			return null;
		}
		return null;

	}

	State moveDown() {

		State s = cloneSanatate();
		int[][] aux = s.config;

		aux[i0][j0] = aux[i0 + 1][j0];
		aux[i0 + 1][j0] = n * n;
		s.i0++;

		return new State(aux, n);
	}

	private State moveUp() {
		State s = cloneSanatate();
		int[][] aux = s.config;

		aux[i0][j0] = aux[i0 - 1][j0];
		aux[i0 - 1][j0] = n * n;
		s.i0--;
		return new State(aux, n);
	}

	private State moveLeft() {
		State s = cloneSanatate();
		int[][] aux = s.config;

		aux[i0][j0] = aux[i0][j0 - 1];
		aux[i0][j0 - 1] = n * n;
		s.j0--;
		return new State(aux, n);
	}

	private State moveRight() {
		State s = cloneSanatate();
		int[][] aux = s.config;

		aux[i0][j0] = aux[i0][j0 + 1];
		aux[i0][j0 + 1] = n * n;

		s.j0++;
		return new State(aux, n);
	}

	public int[][] getConfig() {
		return config;
	}

	public void setConfig(int[][] config) {
		this.config = config;
	}

	public int getI0() {
		return i0;
	}

	public void setI0(int i0) {
		this.i0 = i0;
	}

	public int getJ0() {
		return j0;
	}

	public void setJ0(int j0) {
		this.j0 = j0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(config);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		
		if(!Arrays.deepEquals(config, other.config))
			return false;

		return true;
	}

	@Override
	public String toString() {
		String text = "";

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				 if (i == i0 && j == j0) {
				 text += "  ";
				 } else {
				text += config[i][j] + " ";
				 }
			}
			text += "\n";
		}

		return text;
	}
}
