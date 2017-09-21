package mastermind;

public enum Game {
	PARTIDA(1),
	DEMO(2);
	
	private int value;
	
	private Game(int value){
		assert value > 0;
		this.value = value;
	}
	
	public static Game getGame(int value) {
		for(Game game : Game.values()) {
			if (game.value == value)
				return game;
		}
		return Game.PARTIDA;
	}
	
	public String toString() {
		return "" + value;
	}
}