package mastermind.views;

import mastermind.controllers.StartController;
import mastermind.utils.LimitedModeOption;

public class StartView {

	void interact(StartController startController){
		new BoardView().writeOptions();
		startController.setModeGame(new LimitedModeOption("Opcion? ").read());
		startController.processCodeMaker();
		new CodeMakerView(startController.getCodeMakerController()).write();
		startController.processStart();
	}
	
}
