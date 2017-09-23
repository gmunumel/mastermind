package mastermind.utils;

import java.util.Arrays;

import mastermind.Code;
import mastermind.Color;

public class LimitedCodeOption {
	
	private String title;
	
	public LimitedCodeOption(String title) {
		assert title != "";
		this.title = title;
	}
	
	public String read(){
		IO io = new IO();
		String value;
		boolean ok;
		do {
			value = io.readString(title);
			ok = Color.includes(value);
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
}
