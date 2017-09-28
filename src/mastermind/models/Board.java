package mastermind.models;

import java.util.HashMap;

import mastermind.utils.IO;

public class Board {
	
	private Code codeMaker;
	
	private Code codeBreaker;
	
	public Board() {
		codeMaker = new Code();
		codeBreaker = new Code();
	}
	
//	public void writeOptions() {
//		IO io = new IO();
//		io.writeln("1. Partida");
//		io.writeln("2. Demo");
//	}
	
//	public void write() {
//		IO io = new IO();
//		if (!existsMasterMind()) {
//			HashMap<Color, Integer> getBlacksOrWhites = getBlacksAndWhites();
//			io.writeln(getBlacksOrWhites.get(Color.NEGRO) + " muertos y "
//				 + getBlacksOrWhites.get(Color.BLANCO) + " heridos");
//		}
//	}
	
	public boolean existsMasterMind() {
		if (getBlacksAndWhites().get(Color.NEGRO) == Code.NUM_PEGS) {
			return true;
		}
		return false;
	}
	
	public void setCodeMaker(Code codeMaker) {
		assert codeMaker != null;
		this.codeMaker = codeMaker;
	}
	
	public void setCodeBreaker(Code codeBreaker) {
		assert codeBreaker != null;
		this.codeBreaker = codeBreaker;
	}
	
	public HashMap<Color, Integer> getBlacksAndWhites() {
		return codeBreaker.getBlacksAndWhites(codeMaker);
	}
	
	public void clear() {
		codeMaker = new Code();
		codeBreaker = new Code();
	}
}
