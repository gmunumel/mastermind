package mastermind.controllers;

import mastermind.models.Code;
import mastermind.models.Game;
import mastermind.models.State;
import mastermind.utils.IO;

public class CodeRandomController extends /*BaseController*/CodeController {

	private String title;
//	
	private Code code;
	
	protected CodeRandomController(Game game) {
		super(game);
		this.title = "Intento? [cuato letras de entre A-amarillo, "
						+ "R-rojo, V-verde, Z-azul, B-blanco, N-negro] ";
	}
	
//	public void control() {
//		IO io = new IO();
//		code = this.createRandomCode();
//		io.write(title);
//		//io.writeln(isSecret ? "****" + newCode.toString() : newCode.toString());
//		this.message();
//		this.set();
//	}
	
	@Override
	public void place() {
		code = new Code().random();
		IO io = new IO();
		io.write(title);
		io.writeln(code.toString());
//		return code;
//		io.write(title);
		//io.writeln(isSecret ? "****" + newCode.toString() : newCode.toString());
		//this.message();
		//this.setCode();
	}
	
//	@Override
//	public void displayMessage() {
//		IO io = new IO();
//		io.write(title);
//		io.writeln(code.toString());
//	}
	
	@Override
	public void set() {
		this.getBoard().setCodeBreaker(code);
	}

//	@Override
//	public void control() {
//		// TODO Auto-generated method stub
//		
//	}
	
//	protected abstract void message();
	
	//protected abstract void setCode();
	
//	public Code getCode() {
//		return code;
//	}
//	
//	private Code createRandomCode() {
//		return new Code().random();
//	}
	
	
	
//	@Override
//	protected void choose() {
//		IO io = new IO();
//		Code newCode = this.getCode();
//		newCode = this.createRandomCode();
//		io.write(title);
//		//io.writeln(isSecret ? "****" + newCode.toString() : newCode.toString());
//		this.message();
//	}
	
//	public Code getCode() {
//		return code;
//	}
	
	
}
