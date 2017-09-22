package mastermind;

public class MasterMind {
	
	private Round round;

	private Board board;

	private Player player;

	public MasterMind() {
		round = new Round();
		board = new Board();
		player = new Player(round, board);
	}

	public void play() {
		board.writeOptions();
		player.pickGame();
		player.pickCodeMaker();
		do {
			player.pickCodeBreaker();
			player.verifySolution();
			board.write();
		} while (!board.existsMasterMind() && !round.complete());
	}

	public static void main(String[] args) {
		new MasterMind().play();
	}
}
