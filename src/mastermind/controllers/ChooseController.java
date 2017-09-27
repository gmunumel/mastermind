package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.utils.IO;

public class ChooseController extends CycleController {
	
	private CodeController codeController;
	
	protected ChooseController(Game game, 
			CodeController codeController) {
		super(game);
		assert codeController != null;
		this.codeController = codeController;
		
	}
	
	public void control() {
		assert this.getState() == State.IN_GAME;
				
		this.codeController.place();
		this.codeController.set();
		this.write();
		
		IO io = new IO();
		if (this.existsMasterMind()) {
			io.writeln("4 muertos!!!! Victoria");
			this.setState(State.FINAL);
		} else if (this.complete()) {
			this.setState(State.FINAL);
		} else
			this.advance();
	}
}
