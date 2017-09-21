package mastermind;

public class MasterMind {
	
	private Round round;

	private Board board;

	private ChooseController chooseController;

	public MasterMind() {
		round = new Round();
		board = new Board();
		chooseController = new ChooseController(round, board);
	}

	public void play() {
		board.writeOptions();
		chooseController.pickGame();
		chooseController.pickCodeMaker();
		do {
			chooseController.pickCodeBreaker();
			board.write();
		} while (!board.existsMasterMind() && !round.complete());
	}

	public static void main(String[] args) {
		new MasterMind().play();
	}
}
