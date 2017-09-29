package mastermind.views;

import mastermind.controllers.RandomCodeController;
import mastermind.utils.IO;

public class RandomCodeView {
	
	private IO io;
	
	private RandomCodeController randomCodeController;
	
	public RandomCodeView(RandomCodeController randomCodeController) { 
		io = new IO();
		assert randomCodeController != null;
		this.randomCodeController = randomCodeController;
	}
	
	public void write() {
		io.write(randomCodeController.getTitle());
		io.writeln(randomCodeController.getCode().toString());
	}
}
