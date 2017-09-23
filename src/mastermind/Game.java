package mastermind;

public enum Game {
	PARTIDA(1),
	DEMO(2);
	
	private int value;
	
	private Game(int value){
		assert value > 0;
		this.value = value;
	}
	
	public static boolean includes(int value) {
		assert value > 0;
		for(Game game : Game.values()) {
			if(value == game.value)
				return true;
		}
		return false;
	}
	
	public static Game getGame(int value) {
		assert value > 0;
		for(Game game : Game.values()) {
			if(value == game.value)
				return game;
		}
		return Game.DEMO;
	}
	
	public String toString() {
		return "" + value;
	}
}