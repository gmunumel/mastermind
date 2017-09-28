package mastermind.controllers;

import java.util.HashMap;

import mastermind.models.Board;
import mastermind.models.Code;
import mastermind.models.Color;
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
		return game.getBoard().existsMasterMind();
	}
	
	protected boolean complete() {
		return game.getRound().complete();
	}
	
	protected void advance() {
		game.getRound().advance();
	}
	
//	protected void write() {
//		game.write();
//	}
	
	protected void clearRound() {
		game.getRound().clear();
	}
	
	protected void clearBoard() {
		game.getBoard().clear();
	}
	
//	protected void writeOptions() {
//		game.getBoard().writeOptions();
//	}
	
	protected void setCodeBreaker(Code code) {
		game.getBoard().setCodeBreaker(code);
	}
	
	protected void setCodeMaker(Code code) {
		game.getBoard().setCodeMaker(code);
	}
	
	protected HashMap<Color, Integer> getBlacksAndWhites() {
		return game.getBoard().getBlacksAndWhites();
	}
}
