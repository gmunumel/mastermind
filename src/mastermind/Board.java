package mastermind;

import java.util.ArrayList;
import java.util.List;
import mastermind.utils.IO;

public class Board {
	
	private List<Code> codeBreakers;
	
	private Code codeMaker;
	
	public Board() {
		codeBreakers = new ArrayList<Code>();
		codeMaker = new Code();
		for (int i = 0; i < Round.NUM_ROUNDS; i++) {
			codeBreakers.add(new Code(new Peg()));
		}
	}
	
	public void write() {
		IO io = new IO();
		io.writeln("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		io.writeln("M   A   S   T   E   R   M   I   N  D");
		io.writeln("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < Round.NUM_ROUNDS; i++) {
			io.write("|  W : " + getBlacksOrWhites(i, Color.WHITE) + " / B : " + getBlacksOrWhites(i, Color.BLACK) + "  |  ");
			for (int j = 0; j < Code.NUM_PEGS; j++) {
				io.write(getPegsRepresentation(i, j) + "  |  ");
			}
			io.writeln();
		}
	}
	
	public boolean existsMasterMind() {
		for (int i = 0; i < Round.NUM_ROUNDS; i++) {
			if (getBlacksOrWhites(i, Color.BLACK) == Code.NUM_PEGS) {
				return true;
			}
		}
		return false;
	}
	
	public void setCodeBreaker(Round round, Code codeBreaker) {
		assert round != null;
		assert codeBreaker != null;
		codeBreakers.add(Code.NUM_PEGS - round.get() - 1, codeBreaker);
		codeBreakers.remove(0);
	}
	
	public void setCodeMaker(Code codeMaker) {
		assert codeMaker != null;
		this.codeMaker = codeMaker;
	}
	
	private int getBlacksOrWhites(int x, Color type) {
		assert x > 0;
		assert type != null;
		Code codeBreaker = codeBreakers.get(x);
		return codeBreaker.getBlacksAndWhites(codeMaker).get(type);
	}
	
	private String getPegsRepresentation(int x, int y) {
		assert x > 0;
		assert y > 0;
		return codeBreakers.get(x).getCode().get(y).toString();
	}
}
