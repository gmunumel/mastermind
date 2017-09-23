package mastermind;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Color {
	AMARILLO('A'),
	ROJO('R'),
	VERDE('V'),
	AZUL('Z'),
	BLANCO('B'),
	NEGRO('N');
	
	private char value;
	
	private Color(char value){
		assert value != Character.MIN_VALUE;
		this.value = value;
	}
	
	public static Color random() {
		Random rand = new Random();
		List<Color> colors = Collections.unmodifiableList(Arrays.asList(values()));
		return colors.get(rand.nextInt(colors.size())) ;
	}
	
	public static boolean includes(String value) {
		assert value != "";
		for(Color color: Color.values()) {
			if(!value.contains(color.toString()))
				return false;
		}
		return true;
	}
	
	public String toString() {
		return "" + value;
	}
}