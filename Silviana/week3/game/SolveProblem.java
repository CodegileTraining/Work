package game;

public class SolveProblem {
	public static void main(String[] args) {
		Game game = new Game();
		game.initMatrix();
		Game.initValidMatrix();
		
		
		System.out.println(game.begin());

	}
}
