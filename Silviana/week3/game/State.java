package game;

import java.util.Arrays;

public class State {

	private int n;
	private int[][] config;

	public State(int n, int[][] config) {
		this.n = n;
		this.config = new int[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(config[i], 0, this.config[i], 0, n);
		}
	}

	public State(State state) {
		this.n = state.getN();
		config = new int[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(state.getConfig()[i], 0, config[i], 0, n);
		}
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int[][] getConfig() {
		return config;
	}

	public void setConfig(int[][] config) {
		this.config = config;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(config);
		result = prime * result + n;
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
		if (!Arrays.deepEquals(config, other.config))
			return false;
		if (n != other.n)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String text = "";

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (config[i][j] == 999999) {
					text += " ";
				} else
					text += config[i][j];
				text += " ";
			}
			text += "\n";
		}
		return text;
	}

}
