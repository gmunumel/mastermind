package mastermind.controllers;

import mastermind.models.Code;
import mastermind.models.Game;

public class CodeMakerController extends CodeController {

	private String title;

	private Code code;
	
	protected CodeMakerController(Game game) {
		super(game);
		this.title = "Secreto: ";
	}
	
	@Override
	public void define(String value) {
		code = new Code(value).random();
	}
	
	@Override
	public void set() {
		this.setCodeMaker(code);
	}
	
	public String getTitle() {
		return title;
	}
	
	public Code getCode() {
		return code;
	}
}
