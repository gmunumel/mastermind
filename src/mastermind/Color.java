package mastermind;

public enum Color {
	RED('r'),
	BLUE('b'),
	GREEN('g'),
	YELLOW('y'),
	ORANGE('o'),
	WHITE('w'),
	BLACK('k'),
	NONE('.');
	
	private char value;
	
	private Color(char value){
		assert value != Character.MIN_VALUE;
		this.value = value;
	}
	
	public static Color getColor(String value) {
		for(Color color: Color.values()) {
			if (color.toString().compareTo(value) == 0)
				return color;
		}
		return Color.NONE;
	}
	
	public String toString() {
		return "" + value;
	}
}