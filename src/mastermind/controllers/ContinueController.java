package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;

public class ContinueController extends CycleController {

	public ContinueController(Game game) {
		super(game);
	}
	
	public void setContinue(boolean another){
		assert this.getState() == State.FINAL;
		if (another) {
			this.clearBoard();
			this.clearRound();
			this.setState(State.INITIAL);
		} else {
			this.setState(State.EXIT);
		}
	}
}
