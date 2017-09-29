package mastermind;

import mastermind.controllers.CycleController;
import mastermind.controllers.Dispatcher;
import mastermind.views.MasterMindView;

public class MasterMind {
	
	private Dispatcher dispatcher;
	
	private MasterMindView view;

	public MasterMind() {
		dispatcher = new Dispatcher();
		view = new MasterMindView();
	}

	public void play() {
		CycleController cycleController;
		do {
			cycleController = dispatcher.getController();
			if (cycleController != null){
				view.interact(cycleController);
			}
		} while (cycleController != null);
	}

	public static void main(String[] args) {
		new MasterMind().play();
	}
}
