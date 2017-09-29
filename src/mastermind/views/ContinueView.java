package mastermind.views;

import mastermind.controllers.ContinueController;
import mastermind.utils.YesNoOption;

public class ContinueView {
	
	void interact(ContinueController continueController){
		continueController.setContinue(new YesNoOption("Desea continuar").read());
	}

}
