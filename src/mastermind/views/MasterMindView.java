package mastermind.views;

import mastermind.controllers.ChooseController;
import mastermind.controllers.ContinueController;
import mastermind.controllers.CycleController;
import mastermind.controllers.CycleControllerVisitor;
import mastermind.controllers.StartController;

public class MasterMindView implements CycleControllerVisitor {
	
	private StartView startView;
	
	private ChooseView chooseView;
	
	private ContinueView continueView;
	
	public MasterMindView(){
		startView = new StartView();
		chooseView = new ChooseView();
		continueView = new ContinueView();
	}
	
	public void interact(CycleController cycleController) {
		assert cycleController != null;
		cycleController.accept(this);
	}
	
	@Override
	public void visit(StartController startController) {
		startView.interact(startController);
	}
	
	@Override
	public void visit(ChooseController chooseController) {
		chooseView.interact(chooseController);
	}
	
	@Override
	public void visit(ContinueController continueController) {
		continueView.interact(continueController);
	}

}
