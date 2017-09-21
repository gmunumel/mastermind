package mastermind;

public enum Position {
	FIRST(1),
	SECOND(2),
	THIRD(3),
	FOURTH(4),
	FIVE(5),
	NONE(0);
	
	private int value;
	
	private Position(int value){
		this.value = value;
	}
	
	public String toString() {
		return "" + value;
	}
}
