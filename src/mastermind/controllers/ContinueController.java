package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.utils.IO;

public class ContinueController extends CycleController {

	public ContinueController(Game game) {
		super(game);
	}

	@Override
	public void control() {
		assert this.getState() == State.FINAL;
		IO io = new IO();
		char answer;
		do {
			answer = io.readChar("Desea continuar? (s/n): ");
		} while (answer != 's' && answer != 'S' && answer != 'n'
				&& answer != 'N');
		if (answer == 's') {
			this.getBoard().clear();
			this.getRound().clear();
			this.setState(State.INITIAL);
		} else {
			this.setState(State.EXIT);
		}
	}
}
