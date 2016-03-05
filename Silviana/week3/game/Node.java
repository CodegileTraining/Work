package game;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private State state;
	private Node parent;
	private Action action;
	private int cost;
	private List<State> next=new ArrayList<>();

	public Node(State state, Node parent,  int cost) {
		super();
		this.state = state;
		this.parent = parent;
		this.cost = cost;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public List<State> getNext() {
		return next;
	}

	public void setNext(List<State> nextStates) {
		this.next = nextStates;
	}

	public void calculateNext(int i, int j) {
		if (i > 0) {
			State newState1 = moveUp(i, j);
			next.add(newState1);
		}
		if (i < state.getN() - 1) {
			State newState2 = moveDown(i, j);
			next.add(newState2);
		}
		if (j > 0) {
			State newState3 = moveLeft(i, j);
			next.add(newState3);
		}
		if (j < state.getN() - 1) {
			State newState4 = moveRight(i, j);
			next.add(newState4);
		}

	}

	public State moveUp(int i, int j) {
		State copyState = new State(state);
		int[][] newMatrix = copyState.getConfig();
		int aux;
		aux = newMatrix[i - 1][j];
		newMatrix[i - 1][j] = newMatrix[i][j];
		newMatrix[i][j] = aux;

		copyState.setConfig(newMatrix);

		return copyState;
	}

	public State moveDown(int i, int j) {
		State copyState = new State(state);
		int[][] newMatrix = copyState.getConfig();
		int aux;
		aux = newMatrix[i + 1][j];
		newMatrix[i + 1][j] = newMatrix[i][j];
		newMatrix[i][j] = aux;

		copyState.setConfig(newMatrix);

		return copyState;
	}

	public State moveLeft(int i, int j) {
		State copyState = new State(state);
		int[][] newMatrix = copyState.getConfig();
		int aux;
		aux = newMatrix[i][j - 1];
		newMatrix[i][j - 1] = newMatrix[i][j];
		newMatrix[i][j] = aux;

		copyState.setConfig(newMatrix);

		return copyState;
	}

	public State moveRight(int i, int j) {
		State copyState = new State(state);
		int[][] newMatrix = copyState.getConfig();
		int aux;
		aux = newMatrix[i][j + 1];
		newMatrix[i][j + 1] = newMatrix[i][j];
		newMatrix[i][j] = aux;

		copyState.setConfig(newMatrix);

		return copyState;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Node other = (Node) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [ state=\n" + state + ", parent=" + parent + ", action=" + action + ", cost=" + cost + "]";
	}

}
