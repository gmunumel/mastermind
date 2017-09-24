package mastermind.models;

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
	
	public static Color getColor(String value) {
		assert value != null;
		for(Color color : Color.values()) {
			if (color.toString().compareTo(value) == 0) {
				return color;
			}
		}
		return Color.BLANCO;
	}
	
	public static boolean includes(String value) {
		assert value != null;
		boolean isIn = false;
		for(char c : value.toCharArray()) {
			isIn = false;
			for(Color color : Color.values()) {
		        if (color.toString().compareTo("" + c) == 0) {
		        		isIn = true;
		            break;
		        }
		    }
			if (!isIn) return false;
		}
		return true;
	}
	
	public String toString() {
		return "" + value;
	}
}