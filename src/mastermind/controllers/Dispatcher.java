package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.Mode;

public class Dispatcher {

	private Game game;

	private StartController startController;

	private ContinueController continueController;

	public Dispatcher() {
		game = new Game();
		startController = new StartController(game);
		continueController = new ContinueController(game);
	}

	public CycleController getController() {
		switch (game.getState()){
		case INITIAL:
			return startController;
		case IN_GAME:
			int player = game.getMode() == Mode.ONEPLAYER ? 1 : 0;
//			int colocate = !game.getBoard().complete()?0:1;
			return startController.getChooseControllerArray()[player];
		case FINAL:
			return continueController;
		case EXIT:
		default:
			return null;
		}
	}
}
