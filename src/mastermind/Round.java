package mastermind;

public class Round {
	
	public static final int NUM_ROUNDS = 3;

	private int value;
	
	public Round() {
		value = 0;
	}
	
	public int get() {
		return value;
	}
	
	public void advance() {
		value++;
	}
	
	public boolean complete() {
		return value == NUM_ROUNDS;
	}
}
