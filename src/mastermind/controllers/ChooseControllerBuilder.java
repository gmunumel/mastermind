package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.Mode;

public class ChooseControllerBuilder {
	
	private ChooseController[] chooseControllerArray; 
	
	private Game game;
	
	public ChooseControllerBuilder(Game game) {
		assert game != null;
		this.game = game;
		chooseControllerArray = new ChooseController[game.getNumPlayers() + 1];
	}
	
	public void build() {
		CodeController[] codeController = new CodeController[2];
		for (int i = 0; i <= game.getNumPlayers(); i++) {
			if (game.getMode() == Mode.ONEPLAYER) {
				codeController[i] = new CodeBreakerController(game);
			} else {
				codeController[i] = new RandomCodeController(game);
			}
		}
		for (int i = 0; i <= game.getNumPlayers(); i++) {
			chooseControllerArray[i] = new ChooseController(
					game, codeController[i]);
		}
	}
	
	public ChooseController getChooseController() {
		return chooseControllerArray[game.getNumPlayers()];
	}
}
