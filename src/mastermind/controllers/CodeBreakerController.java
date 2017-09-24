package mastermind.controllers;

import mastermind.models.Code;
import mastermind.models.Game;
import mastermind.models.State;
import mastermind.utils.IO;
import mastermind.utils.LimitedCodeOption;

public class CodeBreakerController extends CodeController {
	
	private Code codeBreaker;
	
	private String title;
	
	protected CodeBreakerController(Game game) {
		super(game);
		this.title = "Intento? [cuato letras de entre A-amarillo, "
						+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ";
	}
	
	@Override
	public void place() {
		LimitedCodeOption colors = new LimitedCodeOption(title);
//		return new Code(colors.read());
		codeBreaker = new Code(colors.read());
//		return codeBreaker;
	}
	
//	@Override
//	public void displayMessage() {
//		
//	}
	
	@Override
	public void set() {
		this.getBoard().setCodeBreaker(codeBreaker);
	}
	
	
//	@Override
//	public void displayMessage() {
//		IO io = new IO();
//		io.write(title);
//		io.writeln(this.getState() == State.INITIAL ? 
//					"****" + code.toString() : 
//						code.toString());
//	}
	
//	@Override
//	protected void choose() {
//		IO io = new IO();
//		codeBreaker = new Code();
//		if (this.getMode() == Mode.VERSUS) {
//			
//		}
//		if (this.getMode() == Mode.DEMO) {
//			this.choose();
//		}
//		if (this.getBoard().existsMasterMind())
//			io.writeln("4 muertos!!!! Victoria");
//		else
//			this.getRound().advance();
//	}
	
//	@Override
//	protected void message() {
//		if (this.getMode() == Mode.DEMO) {
//			codeBreaker = this.getCode();
//			IO io = new IO();
//			io.write(codeBreaker.toString());
//		}
//	}
	
//	@Override
//	protected void set() {
//		this.getBoard().setCodeBreaker(codeBreaker);
//	}
}
