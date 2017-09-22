package mastermind;

import mastermind.utils.IO;
import mastermind.utils.LimitedColorOption;
import mastermind.utils.LimitedIntOption;

public class Player {
	
	private Round round;
	
	private Board board;
	
	private Game game;
	
	public Player(Round round, Board board) {
		assert round != null;
		assert board != null;
		this.round = round;
		this.board = board;
	}
	
	public void pickGame() {
		LimitedIntOption option = new LimitedIntOption("Opcion? ");
		game = option.read();
	}
	
	public void pickCodeMaker() {
		Code newCode = buildRandomCode("Secreto: ", true);	
		board.setCodeMaker(newCode);
	}
	
	public void pickCodeBreaker() {
		Code newCode = new Code();
		if (game == Game.PARTIDA)
			newCode = buildCode("Intento? [cuato letras de entre A-amarillo, "
									+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ");
		if (game == Game.DEMO) 
			newCode = buildRandomCode("Intento? [cuato letras de entre A-amarillo, "
									+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ", false);
		
		board.setCodeBreaker(newCode);
	}
	
	public void verifySolution() {
		IO io = new IO();
		if (board.existsMasterMind())
			io.writeln("4 muertos!!!! Victoria");
		else
			round.advance();
	}
	
	private Code buildCode(String title) {
		assert title != "";
		LimitedColorOption colors = new LimitedColorOption(title);
		Code newCode = new Code();
		newCode.createCode(colors.read());
		return newCode;
	}
	
	private Code buildRandomCode(String title, boolean isSecret) {
		assert title != "";
		IO io = new IO();
		Code newCode = new Code().random();
		io.write(title);
		io.writeln(isSecret ? "****" : newCode.toString());
		return newCode;
	}
}
