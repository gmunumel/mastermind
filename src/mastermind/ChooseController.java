package mastermind;

import mastermind.utils.IO;
import mastermind.utils.LimitedColorOption;
import mastermind.utils.LimitedIntOption;

public class ChooseController {
	
	private Round round;
	
	private Board board;
	
	private Game game;
	
	public ChooseController(Round round, Board board) {
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
		Code newCode = new Code();
		if (game == Game.PARTIDA)
			newCode = buildCode("Secreto: ");
		if (game == Game.DEMO)
			newCode = demo("Secreto: ");
		
		board.setCodeMaker(newCode);
	}
	
	public void pickCodeBreaker() {
		IO io = new IO();
		Code newCode = new Code();
		if (game == Game.PARTIDA)
			newCode = buildCode("Intento? [cuato letras de entre A-amarillo, "
									+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ");
		if (game == Game.DEMO) 
			newCode = demo("Intento? [cuato letras de entre A-amarillo, "
									+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ");
		
		board.setCodeBreaker(newCode);
		
		if (board.existsMasterMind())
			io.writeln("4 muertos!!!! Victoria");
		else
			round.advance();
	}
	
	private Code buildCode(String title) {
		assert title != "";
		LimitedColorOption colors = new LimitedColorOption(title);
		Code newCode = new Code();
		for(char c : colors.read().toCharArray()) {
			newCode.getCode().add(new Peg(c));
		}
		return newCode;
	}
	
	private Code demo(String title) {
		IO io = new IO();
		Code newCode = new Code().random();
		io.write(title);
		io.writeln(newCode.toString());
		return newCode;
	}
}
