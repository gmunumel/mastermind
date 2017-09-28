package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.Mode;
import mastermind.models.State;

public class StartController extends CycleController {

	private CodeMakerController codeMakerController;
	
	private ChooseControllerBuilder chooseControllerBuilder;

	protected StartController(Game game, ChooseControllerBuilder chooseControllerBuilder) {
		super(game);
		this.chooseControllerBuilder = chooseControllerBuilder;
	}
	
	public void setModeGame(Mode mode) {
		assert this.getState() == State.INITIAL;
		assert mode != null;
		this.setMode(mode);
	}
	
	public void processCodeMaker() {
		codeMakerController = 
				new CodeMakerController(this.getGame());
		codeMakerController.define("");
		codeMakerController.set();
	}
	
	public void processStart() {
		chooseControllerBuilder.build();
		this.setState(State.IN_GAME);
	}
	
	public CodeMakerController getCodeMakerController() {
		return codeMakerController;
	}
	
	@Override
	public void accept(CycleControllerVisitor cycleControllerVisitor) {
		cycleControllerVisitor.visit(this);		
	}
}
