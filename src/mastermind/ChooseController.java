package mastermind;

import mastermind.utils.IO;
import mastermind.utils.LimitedColorOption;

public class ChooseController {
	
	private Round round;
	
	private Board board;
	
	public ChooseController(Round round, Board board) {
		assert round != null;
		assert board != null;
		this.round = round;
		this.board = board;
	}
	
	public void pick(String type) {
		assert type != "";
		IO io = new IO();
		Code newCode;
		if (type.compareTo("codemaker") == 0) {
			newCode = buildCode("Introduzca pieza codemaker: ");
			board.setCodeMaker(newCode);
		}
		if (type.compareTo("codebreaker") == 0) {
			newCode = buildCode("Introduzca pieza codebreaker: ");
			board.setCodeBreaker(round, newCode);
			
			if (board.existsMasterMind())
				io.writeln("Victoria!!!!!");
			else
				round.advance();
		}
	}
	
	private Code buildCode(String title) {
		assert title != "";
		LimitedColorOption color = new LimitedColorOption(title);
		Code newCode = new Code();
		for(int i = 0; i < Code.NUM_PEGS; i++) {
			newCode.setPegInPosition(i, color.read());
		}
		return newCode;
	}
}
