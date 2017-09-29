package mastermind.controllers;

import mastermind.models.Code;
import mastermind.models.Game;

public class RandomCodeController extends CodeController {

	private String title;

	private Code code;
	
	protected RandomCodeController(Game game) {
		super(game);
		title = "Intento? [cuatro letras de entre A-amarillo, "
					+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ";
	}
	
	@Override
	public void define(String value) {
		code = new Code(value).random();
	}
	
	@Override
	public void set() {
		this.setCodeBreaker(code);
	}
	
	public String getTitle() {
		return title;
	}
	
	public Code getCode() {
		return code;
	}
}
