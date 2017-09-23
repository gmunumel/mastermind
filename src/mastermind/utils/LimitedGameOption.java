package mastermind.utils;

import java.util.Arrays;

import mastermind.Color;
import mastermind.Game;

public class LimitedGameOption {
	
	private String title;
	
	public LimitedGameOption(String title) {
		assert title != "";
		this.title = title;
	}
	
	public Game read(){
		IO io = new IO();
		int value;
		boolean ok;
		do {
			value = io.readInt(title);
			ok = Game.includes(value);
			if (!ok) {
				io.writeln("El valor debe ser " + Arrays.asList(Game.values()));
			}
		} while (!ok);
		return Game.getGame(value);
	}
}
