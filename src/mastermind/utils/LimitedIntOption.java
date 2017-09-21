package mastermind.utils;

import java.util.Arrays;

import mastermind.Game;

public class LimitedIntOption {
	
	private String title;
	
	public LimitedIntOption(String title) {
		assert title != "";
		this.title = title;
	}
	
	public Game read(){
		IO io = new IO();
		int value;
		boolean ok;
		do {
			value = io.readInt(title);
			ok = value == 1 || value == 2 ? true : false; 
			if (!ok) {
				io.writeln("El valor debe ser " + Arrays.asList(Game.values()));
			}
		} while (!ok);
		return Game.getGame(value);
	}
}
