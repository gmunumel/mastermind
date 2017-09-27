package mastermind.controllers;

import mastermind.models.Code;
import mastermind.models.Game;
import mastermind.utils.IO;

public class RandomCodeController extends CodeController {

	private String title;

	private Code code;
	
	protected RandomCodeController(Game game) {
		super(game);
		title = "Intento? [cuatro letras de entre A-amarillo, "
					+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ";
	}
	
	@Override
	public void place() {
		code = new Code().random();
		IO io = new IO();
		io.write(title);
		io.writeln(code.toString());
	}
	
	@Override
	public void set() {
		this.getBoard().setCodeBreaker(code);
	}
}
