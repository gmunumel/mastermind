package mastermind;

import mastermind.utils.IO;

public class Board {
	
//	private Game game;
	
	private Code codeMaker;
	
	private Code codeBreaker;
	
	public Board() {
//		game = Game.PARTIDA;
		codeMaker = new Code();
		codeBreaker = new Code();
	}
	
	public void writeOptions() {
		IO io = new IO();
		io.writeln("1. Partida");
		io.writeln("2. Demo");
	}
	
	public void write() {
		IO io = new IO();
		if (!existsMasterMind())
			io.writeln(getBlacksOrWhites(Color.NEGRO) + " muertos y "
				 + getBlacksOrWhites(Color.BLANCO) + " heridos");
	}
	
	public boolean existsMasterMind() {
		if (getBlacksOrWhites(Color.NEGRO) == Code.NUM_PEGS) {
			return true;
		}
		return false;
	}
	
//	public void setGame(Game game) {
//		assert game != null;
//		this.game = game;
//	}
	
	public void setCodeMaker(Code codeMaker) {
		assert codeMaker != null;
		this.codeMaker = codeMaker;
	}
	
	public void setCodeBreaker(Code codeBreaker) {
		assert codeBreaker != null;
		this.codeBreaker = codeBreaker;
	}
	
	private int getBlacksOrWhites(Color type) {
		assert type != null;
		return codeBreaker.getBlacksAndWhites(codeMaker).get(type);
	}
}
