package mastermind.controllers;

import mastermind.models.Code;
import mastermind.models.Game;
import mastermind.utils.IO;

public class CodeMakerController extends CodeController {

	private String title;

	private Code code;
	
	protected CodeMakerController(Game game, String title) {
		super(game);
		assert title != null;
		this.title = title;
	}
	
	@Override
	public void place() {
		code = new Code().random();
		IO io = new IO();
		io.write(title);
		io.writeln("****" + code.toString());
	}
	
	@Override
	public void set() {
		this.getBoard().setCodeMaker(code);
	}
}
