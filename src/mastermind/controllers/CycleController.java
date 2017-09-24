package mastermind.controllers;

import mastermind.models.Game;

public abstract class CycleController extends BaseController {

	protected CycleController(Game game) {
		super(game);
	}

	public abstract void control();
	
}