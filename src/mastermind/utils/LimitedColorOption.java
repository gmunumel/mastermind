package mastermind.utils;

import java.util.Arrays;

import mastermind.Code;
import mastermind.Color;

public class LimitedColorOption {
	
	private String title;
	
	public LimitedColorOption(String title) {
		assert title != "";
		this.title = title;
	}
	
	public String read(){
		IO io = new IO();
		String value;
		boolean ok;
		do {
			value = io.readString(title);
			ok = this.cointains(value);
			if (!ok) {
				io.writeln("El valor debe ser un color valido " + Arrays.asList(Color.values()));
			} else {
				ok = value.length() == Code.NUM_PEGS ? true : false;
				if (!ok) {
					io.writeln("El tamanio debe ser " + Code.NUM_PEGS);
				}
			}
		} while (!ok);
		return value;
	}
	
	private boolean cointains(String value) {
		assert value != "";
		for(Color color: Color.values()) {
			if(value.contains(color.toString()))
				return true;
		}
		return false;
	}
}
