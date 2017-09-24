package mastermind.controllers;

import mastermind.models.Code;
import mastermind.models.Game;
import mastermind.models.Mode;
import mastermind.models.State;
import mastermind.utils.IO;
import mastermind.utils.LimitedModeOption;

public class StartController extends CycleController {

	private ChooseController[] chooseControllerArray;

	protected StartController(Game game) {
		super(game);
		chooseControllerArray = new ChooseController[2];
	}
	
	@Override
	public void control() {
		assert this.getState() == State.INITIAL;
		this.getBoard().writeOptions();
		this.setMode(new LimitedModeOption("Opcion? ").read());
		Code codeMaker = buildRandomCode("Secreto: ");
		this.getBoard().setCodeMaker(codeMaker);
//		int player = this.getMode() == Mode.ONEPLAYER ? 1 : 0;
		CodeController[] codeController = new CodeController[2];
		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < 2; j++) {
				if (this.getMode() == Mode.ONEPLAYER) {
					codeController[i] = new CodeBreakerController(this.getGame());
				} else {
					codeController[i] = new CodeRandomController(this.getGame());
				}
//			}
		}
		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < 2; j++) {
				chooseControllerArray[i] = new ChooseController(
						this.getGame(), codeController[i]);
//			}
		}
		//this.getBoard().write();
		this.setState(State.IN_GAME);
	}
	
	public ChooseController[] getChooseControllerArray() {
		return chooseControllerArray;
	} 
	
	private Code buildRandomCode(String title) {
		assert title != null;
		IO io = new IO();
		Code newCode = new Code().random();
		io.write(title);
		io.writeln("****" + newCode.toString());
		return newCode;
	}
}
