package mastermind.controllers;

import mastermind.models.Game;
import mastermind.views.MasterMindView;

public abstract class CycleController extends BaseController {

	protected CycleController(Game game) {
		super(game);
	}
	
	public abstract void accept(MasterMindView masterMindView);
	
}