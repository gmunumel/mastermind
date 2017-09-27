package mastermind.models;

public class Game {

	private State state;
	
	private Mode mode;
	
	private Round round;

	private Board board;
	
	public Game() {
		state = State.INITIAL;
		mode = Mode.ONEPLAYER;
		round = new Round();
		board = new Board();
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state){
		assert state != null;
		this.state = state;
	}
	
	public Mode getMode() {
		return mode;
	}
	
	public void setMode(Mode mode){
		assert mode != null;
		this.mode = mode;
	}
	
	public Round getRound() {
		return round;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public int getNumPlayers() {
		return getMode() == Mode.ONEPLAYER ? 1 : 0;
	}
}
