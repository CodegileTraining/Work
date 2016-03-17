package pack.puzzle;

import java.util.*;

public class Node {

	private State state;
	private Node parentNode;
	private int cost;
	private List<Node> nextNodes = new ArrayList<>();

	public Node(State state, Node parentNode, int cost) {
		setState(state);
		setParentNode(parentNode);
		setCost(cost);
	}

	private void calculateNextNodes() {
		for (Action a : Action.values()) {
			State s = state.move(a);

			if (s != null) {
				nextNodes.add(new Node(s, this, cost + 1));
			}
		}
	}

	public boolean isFinal() {
		return state.isFinal();
	}

	public List<Node> getNextNodes() {
		calculateNextNodes();
		return nextNodes;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Node getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		return state.hashCode();
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
		return state.toString();
	}

}
