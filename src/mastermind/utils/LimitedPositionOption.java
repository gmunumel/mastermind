package mastermind.utils;

import mastermind.Position;

public class LimitedPositionOption {
	
	private Position pos;
	
	private String title;
	
	public LimitedPositionOption(String title) {
		assert title != null;
		
	}
	
//	public int read() {
//		IO io = new IO();
//		int value;
//		boolean ok;
//		do {
//			value = io.readInt(title);
//			ok = limits.includes(value);
//			if (!ok) {
//				io.writeln("El valor debe estar entre " + limits);
//			}
//		} while (!ok);
//		return value;
//	}
}
