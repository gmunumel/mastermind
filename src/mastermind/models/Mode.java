package mastermind.models;

public enum Mode {
	ONEPLAYER(1),
	DEMO(2);
	
	private int value;
	
	private Mode(int value){
		assert value > 0;
		this.value = value;
	}
	
	public static boolean includes(int value) {
		assert value > 0;
		for(Mode mode : Mode.values()) {
			if(value == mode.value)
				return true;
		}
		return false;
	}
	
	public static Mode getMode(int value) {
		assert value > 0;
		for(Mode mode : Mode.values()) {
			if(value == mode.value)
				return mode;
		}
		return Mode.DEMO;
	}
	
	public String toString() {
		return "" + value;
	}
}