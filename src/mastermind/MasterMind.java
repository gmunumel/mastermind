package mastermind;

import mastermind.controllers.BaseController;
import mastermind.controllers.CycleController;
import mastermind.controllers.Dispatcher;

public class MasterMind {
	
	private Dispatcher dispatcher;

	public MasterMind() {
		dispatcher = new Dispatcher();
	}

	public void play() {
//		board.writeOptions();
//		choose.pickGame();
//		choose.pickCodeMaker();
//		do {
//			choose.pickCodeBreaker();
//			board.write();
//		} while (!board.existsMasterMind() && !round.complete());
		CycleController cycleController;
		do {
			cycleController = dispatcher.getController();
			if (cycleController != null){
				cycleController.control();
			}
		} while (cycleController != null);
	}

	public static void main(String[] args) {
		new MasterMind().play();
	}
}
