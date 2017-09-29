package mastermind.views;

import java.util.HashMap;

import mastermind.models.Color;
import mastermind.utils.IO;

public class BoardView {
	
	private IO io;
	
	public BoardView() { 
		io = new IO();
	}
	
	public void writeOptions() {
		io.writeln("1. Partida");
		io.writeln("2. Demo");
	}
	
	public void write(HashMap<Color, Integer> blacksAndWhites) {
		io.writeln(blacksAndWhites.get(Color.NEGRO) + " muertos y "
				 + blacksAndWhites.get(Color.BLANCO) + " heridos");
	}
	
	public void writeWinner() {
		io.writeln("4 muertos!!!! Victoria");
	}

}
