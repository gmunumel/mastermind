package mastermind.views;

import mastermind.controllers.ChooseController;
import mastermind.controllers.CodeBreakerController;
import mastermind.controllers.ContinueController;
import mastermind.controllers.CycleController;
import mastermind.controllers.RandomCodeController;
import mastermind.controllers.StartController;
import mastermind.models.State;
import mastermind.utils.LimitedCodeOption;
import mastermind.utils.LimitedModeOption;
import mastermind.utils.YesNoOption;

public class MasterMindView {
	
//	private IO io = new IO();
	
	public void interact(CycleController controller) {
		assert controller != null;
		if (controller instanceof StartController) {
			this.interact((StartController) controller);
//		} else if (controller instanceof PutController) {
//			this.interact((PutController) controller);
		} else if (controller instanceof ChooseController) {
			this.interact((ChooseController) controller);
		} else if (controller instanceof ContinueController) {
			this.interact((ContinueController) controller);
		}
	}
	
	private void interact(StartController startController) {
		new BoardView().writeOptions();
		startController.setModeGame(new LimitedModeOption("Opcion? ").read());
		startController.processCodeMaker();
		new CodeMakerView(startController.getCodeMakerController()).write();
		startController.processStart();
		//int users = new LimitedIntDialog("Cuántos usuarios?", 0, 2).read();
		//startController.setUsers(users);
		//new BoardView(startController).write();
		
	}
	
	private void interact(ChooseController chooseController) {
		
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
		}else
			chooseController.processControl();
	}
	
	private void interact(ContinueController continueController) {
		continueController.setContinue(new YesNoOption("Desea continuar").read());
	}
	
//	private Code getCodeMaker(CodeMakerController codeMakerController) {
//		return codeMakerController.getCode();
//	}

}
