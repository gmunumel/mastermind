package mastermind.utils;

public class LimitedOptionView {
	
	private IO io;
	
	public LimitedOptionView() {
		io = new IO();
	}
	
	public void writeln(String title) {
		assert title != null;
		io.writeln(title);
	}
}
