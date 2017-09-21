package mastermind.utils;

import java.util.Arrays;

import mastermind.Color;

public class LimitedColorOption {
	
	private String title;
	
	public LimitedColorOption(String title) {
		assert title != "";
		this.title = title;
	}
	
	public Color read(){
		IO io = new IO();
		String value;
		boolean ok;
		do {
			value = io.readString(title);
			ok = this.cointains(value);
			if (!ok) {
				io.writeln("El valor debe ser un color valido " + Arrays.asList(Color.values()));
			}
		} while (!ok);
		return Color.getColor(value);
	}
	
	private boolean cointains(String value) {
		assert value != "";
		for(Color color: Color.values()) {
			if(color.toString().compareTo(value) == 0)
				return true;
		}
		return false;
	}
}
