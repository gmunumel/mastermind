package mastermind.controllers;

import mastermind.models.Game;

public class Dispatcher {

	private Game game;
	
	private ChooseControllerBuilder chooseControllerBuilder; 

	private StartController startController;

	private ContinueController continueController;

	public Dispatcher() {
		game = new Game();
		chooseControllerBuilder = new ChooseControllerBuilder(game);
		startController = new StartController(game, chooseControllerBuilder);
		continueController = new ContinueController(game);
	}

	public CycleController getController() {
		switch (game.getState()){
		case INITIAL:
			return startController;
		case IN_GAME:
			return chooseControllerBuilder.getChooseController();
		case FINAL:
			return continueController;
		case EXIT:
		default:
			return null;
		}
	}
}
