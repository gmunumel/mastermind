package mastermind.views;

import mastermind.controllers.CodeMakerController;
import mastermind.utils.IO;

public class CodeMakerView {
	
	private IO io;
	
	private CodeMakerController codeMakerController;
	
	public CodeMakerView(CodeMakerController codeMakerController) { 
		io = new IO();
		assert codeMakerController != null;
		this.codeMakerController = codeMakerController;
	}
	
	public void write() {
		io.write(codeMakerController.getTitle());
		io.writeln("****" + codeMakerController.getCode().toString());
	}
}
