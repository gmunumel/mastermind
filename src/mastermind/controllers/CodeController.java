package mastermind.controllers;

import mastermind.models.Code;
import mastermind.models.Game;

public abstract class CodeController extends BaseController {
	
	protected CodeController(Game game) {
		super(game);
		
	}
	
	//public void control() {
		//assert this.getState() == State.IN_GAME;
//		this.choose();
//		this.set();
		
//		IO io = new IO();
//		if (this.getBoard().existsMasterMind())
//			io.writeln("4 muertos!!!! Victoria");
//		else
//			this.getRound().advance();
	//}
	
	public abstract void place();
	
//	public abstract void displayMessage();
	
	public abstract void set();

}
