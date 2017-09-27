package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.utils.LimitedModeOption;

public class StartController extends CycleController {

	private ChooseControllerBuilder chooseControllerBuilder;

	protected StartController(Game game, ChooseControllerBuilder chooseControllerBuilder) {
		super(game);
		this.chooseControllerBuilder = chooseControllerBuilder;
	}
	
	@Override
	public void control() {
		assert this.getState() == State.INITIAL;
		this.writeOptions();
		this.setMode(new LimitedModeOption("Opcion? ").read());
		buildCodeMaker();
		chooseControllerBuilder.build();
		this.setState(State.IN_GAME);
	}
	
	private void buildCodeMaker() {
		CodeMakerController codeMaker = 
				new CodeMakerController(this.getGame());
		codeMaker.place();
		codeMaker.set();
	}
}
