package mastermind.utils;

import java.util.Arrays;

import mastermind.models.Mode;

public class LimitedModeOption {
	
	private String title;
	
	private LimitedOptionView modeView;
	
	public LimitedModeOption(String title) {
		assert title != null;
		this.title = title;
		modeView = new LimitedOptionView();
	}
	
	public Mode read(){
		IO io = new IO();
		int value;
		boolean ok;
		do {
			value = io.readInt(title);
			ok = Mode.includes(value);
			if (!ok) {
				modeView.writeln("El valor debe ser " + Arrays.asList(Mode.values()));
			}
		} while (!ok);
		return Mode.getMode(value);
	}
}
