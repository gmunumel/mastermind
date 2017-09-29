package mastermind.controllers;

public interface CycleControllerVisitor {
	
	void visit(StartController startController);
	
	void visit(ChooseController chooseController);
	
	void visit(ContinueController continueController);

}
