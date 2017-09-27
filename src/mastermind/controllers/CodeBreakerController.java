package mastermind.controllers;

import mastermind.models.Code;
import mastermind.models.Game;
import mastermind.utils.LimitedCodeOption;

public class CodeBreakerController extends CodeController {
	
	private Code codeBreaker;
	
	private String title;
	
	protected CodeBreakerController(Game game) {
		super(game);
		title = "Intento? [cuatro letras de entre A-amarillo, "
				+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ";
	}
	
	@Override
	public void place() {
		LimitedCodeOption colors = new LimitedCodeOption(title);
		codeBreaker = new Code(colors.read());
	}
	
	@Override
	public void set() {
		this.setCodeBreaker(codeBreaker);
	}
}
