package mastermind.controllers;

import java.util.HashMap;

import mastermind.models.Color;
import mastermind.models.Game;
import mastermind.models.Mode;
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
	
	public void setCode(String codeAsString) {
		assert this.getState() == State.IN_GAME;
		
		this.codeController.define(codeAsString);
		this.codeController.set();
		
	} 
	
	public void processControl() {
		if (this.complete()) 
			this.setState(State.FINAL);
		else
			this.advance();
	}
	
	public void setStateGame(State state) {
		this.setState(state);
	}
//	
//	public void control() {
//		assert this.getState() == State.IN_GAME;
//				
//		this.codeController.define();
//		this.codeController.set();
//		this.write();
//		
//		IO io = new IO();
//		if (this.existsMasterMind()) {
//			io.writeln("4 muertos!!!! Victoria");
//			this.setState(State.FINAL);
//		} else if (this.complete()) {
//			this.setState(State.FINAL);
//		} else
//			this.advance();
//	}
	
	public boolean existsMasterMindGame() {
		return this.existsMasterMind();
	}
	
	public HashMap<Color, Integer> getBlacksAndWhitesGame() {
		return this.getBlacksAndWhites();
	}
	
	public CodeController getCodeController() {
		return codeController;
	}
	
	
}
