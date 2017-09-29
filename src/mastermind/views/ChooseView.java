package mastermind.views;

import mastermind.controllers.ChooseController;
import mastermind.controllers.CodeBreakerController;
import mastermind.controllers.RandomCodeController;
import mastermind.models.State;
import mastermind.utils.LimitedCodeOption;

public class ChooseView {

	void interact(ChooseController chooseController){
		if (chooseController.getCodeController() instanceof CodeBreakerController) {
			String title = "Intento? [cuatro letras de entre A-amarillo, "
							+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ";
			chooseController.setCode(new LimitedCodeOption(title).read());
		} else {
			chooseController.setCode("");
			new RandomCodeView((RandomCodeController) chooseController.getCodeController()).write();
		}
		if (!chooseController.existsMasterMindGame())
			new BoardView().write(chooseController.getBlacksAndWhitesGame());
		if (chooseController.existsMasterMindGame()) {
			new BoardView().writeWinner();
			chooseController.setStateGame(State.FINAL);
		} else
			chooseController.processControl();
	}
	
}
