package mastermind.controllers;

import mastermind.models.Board;
import mastermind.models.Game;
import mastermind.models.Mode;
import mastermind.models.Round;
import mastermind.models.State;

public abstract class BaseController {

	private Game game;

	protected BaseController(Game game) {
		assert game != null;
		this.game = game;
	}
	
	protected State getState(){
		return game.getState();
	}
	
	protected void setState(State state){
		assert state != null;
		game.setState(state);
	}
	
	protected Mode getMode() {
		return game.getMode();
	}
	
	protected void setMode(Mode mode){
		assert mode != null;
		game.setMode(mode);
	}
	
	protected Board getBoard() {
		return game.getBoard();
	}
	
	protected Round getRound() {
		return game.getRound();
	}
	
	protected Game getGame() {
		return game;
	}
	
	protected boolean existsMasterMind() {
		return getBoard().existsMasterMind();
	}
	
	protected boolean complete() {
		return getRound().complete();
	}
}
