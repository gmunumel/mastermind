package mastermind.controllers;

import mastermind.models.Code;
import mastermind.models.Game;

public class CodeBreakerController extends CodeController {
	
	private Code codeBreaker;
	
	protected CodeBreakerController(Game game) {
		super(game);
	}
	
	@Override
	public void define(String value) {
		codeBreaker = new Code(value);
	}
	
	@Override
	public void set() {
		this.setCodeBreaker(codeBreaker);
	}
}
