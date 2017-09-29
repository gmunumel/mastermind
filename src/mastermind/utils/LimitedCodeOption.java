package mastermind.utils;

import java.util.Arrays;

import mastermind.models.Code;
import mastermind.models.Color;

public class LimitedCodeOption {
	
	private String title;
	
	private LimitedOptionView codeView;
	
	public LimitedCodeOption(String title) {
		assert title != null;
		this.title = title;
		codeView = new LimitedOptionView();
	}
	
	public String read(){
		IO io = new IO();
		String value;
		boolean ok;
		do {
			value = io.readString(title);
			ok = Color.includes(value);
			if (!ok) {
				codeView.writeln("El valor debe ser " + Arrays.asList(Color.values()));
			} else {
				ok = value.length() == Code.NUM_PEGS ? true : false;
				if (!ok) {
					codeView.writeln("El tamanio debe ser " + Code.NUM_PEGS);
				}
			}
		} while (!ok);
		return value;
	}
}
