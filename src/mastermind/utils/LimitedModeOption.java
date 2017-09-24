package mastermind.utils;

import java.util.Arrays;

import mastermind.models.Mode;

public class LimitedModeOption {
	
	private String title;
	
	public LimitedModeOption(String title) {
		assert title != null;
		this.title = title;
	}
	
	public Mode read(){
		IO io = new IO();
		int value;
		boolean ok;
		do {
			value = io.readInt(title);
			ok = Mode.includes(value);
			if (!ok) {
				io.writeln("El valor debe ser " + Arrays.asList(Mode.values()));
			}
		} while (!ok);
		return Mode.getMode(value);
	}
}
