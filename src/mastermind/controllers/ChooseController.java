package mastermind.controllers;

import mastermind.models.Board;
import mastermind.models.Code;
import mastermind.models.Game;
import mastermind.models.Mode;
import mastermind.models.Round;
import mastermind.models.State;
import mastermind.utils.IO;
import mastermind.utils.LimitedCodeOption;
import mastermind.utils.LimitedModeOption;

public class ChooseController extends CycleController {
	
//	private Round round;
//	
//	private Board board;
	
	private CodeController codeController;
	
//		private Mode mode;
	
	protected ChooseController(Game game, 
			CodeController codeController) {
		super(game);
		assert codeController != null;
		this.codeController = codeController;
		
	}
	
	public void control() {
		assert this.getState() == State.IN_GAME;
		
		
//		this.choose();
//		this.set();
		
//		if (this.getBoard().existsMasterMind())
//			io.writeln("4 muertos!!!! Victoria");
//		else
//			this.getRound().advance();
		
		this.codeController.place();
//		codeController.displayMessage();
//		this. control();
		this.codeController.set();
		this.getBoard().write();
		
		IO io = new IO();
		if (this.getBoard().existsMasterMind()) {
			io.writeln("4 muertos!!!! Victoria");
			this.setState(State.FINAL);
		} else if (this.getRound().complete()) {
			this.setState(State.FINAL);
		} else
			this.getRound().advance();
	}
	
//	public abstract Code get();
//	
//	public abstract void displayMessage();
	
	//public abstract void set();
	
//	public Code getCode() {
//		return code;
//	}
	
//	public void pickGame() {
//		mode = new LimitedModeOption("Opcion? ").read();
//	}
	
	
	
	//++++++++++++++++++++++++++++++++++++++++++++
	
//	public void pickCodeMaker() {
//		Code newCode = new Code();
//		newCode = buildRandomCode("Secreto: ", true);	
//		board.setCodeMaker(newCode);
//	}
//	
//	public void pickCodeBreaker() {
//		IO io = new IO();
//		Code newCode = new Cowde();
//		if (mode == Mode.PARTIDA)
//			newCode = buildCode("Intento? [cuato letras de entre A-amarillo, "
//									+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ");
//		if (mode == Mode.DEMO) 
//			newCode = buildRandomCode("Intento? [cuato letras de entre A-amarillo, "
//									+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ", false);
//		
//		board.setCodeBreaker(newCode);
//		
//		if (board.existsMasterMind())
//			io.writeln("4 muertos!!!! Victoria");
//		else
//			round.advance();
//	}
//	
//	private Code buildCode(String title) {
//		assert title != "";
//		LimitedCodeOption colors = new LimitedCodeOption(title);
//		Code newCode = new Code(colors.read());
//		return newCode;
//	}
//	
//	private Code buildRandomCode(String title, boolean isSecret) {
//		assert title != "";
//		IO io = new IO();
//		Code newCode = new Code().random();
//		io.write(title);
//		io.writeln(isSecret ? "****" + newCode.toString() : newCode.toString());
//		return newCode;
//	}
}
