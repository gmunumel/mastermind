package mastermind.controllers;

import mastermind.models.Game;

public abstract class CodeController extends BaseController {
	
	protected CodeController(Game game) {
		super(game);
	}
	
	public abstract void define(String value);
	
	public abstract void set();
}
