package mastermind.controllers;

import mastermind.models.Code;
import mastermind.models.Game;
import mastermind.utils.LimitedCodeOption;

public class CodeBreakerController extends CodeController {
	
	private Code codeBreaker;
	
//	private String codeAsString;
	
	protected CodeBreakerController(Game game) {
		super(game);
//		title = "Intento? [cuatro letras de entre A-amarillo, "
//				+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ";
//		codeAsString = "";
	}
	
	@Override
	public void define(String value) {
//		LimitedCodeOption colors = new LimitedCodeOption(title);
//		codeBreaker = new Code(colors.read());
		//LimitedCodeOption colors = new LimitedCodeOption(title);
		codeBreaker = new Code(value);
	}
	
	@Override
	public void set() {
		this.setCodeBreaker(codeBreaker);
	}
	
//	public void setCodeAsString(String codeAsString) {
//		assert codeAsString != null;
//		this.codeAsString = codeAsString;
//	}
}
