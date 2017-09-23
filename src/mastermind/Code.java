package mastermind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Code {
	
	public static final int NUM_PEGS = 4;
	
	private List<Peg> code;
	
	public Code() {
		code = new ArrayList<Peg>();
	}
	
	public Code (String value) {
		this();
		assert value != "";
		for(char c : value.toCharArray()) {
			code.add(new Peg(Color.valueOf("" + c)));
		}
	}
	
	public HashMap<Color, Integer> getBlacksAndWhites(Code other) {
		assert other != null;
		HashMap<Color, Integer> result = new HashMap<Color, Integer>();
		int whites = 0, blacks = 0;
		for(int i = 0; i < NUM_PEGS; i++) {
			if (code.get(i).equals(other.code.get(i)))
				blacks++;
			else if (other.contains(code.get(i)))
				whites++;	
		}
		result.put(Color.BLANCO, whites);
		result.put(Color.NEGRO, blacks);
		return result;
	}
	
	public Code random() {
		Code newCode = new Code();
		for(int i = 0; i < NUM_PEGS; i ++) {
			newCode.code.add(new Peg().random());
		}
		return newCode;
	}
	
	private boolean contains(Peg otherPeg) {
		assert otherPeg != null;
		for(Peg peg : code) {
			if (peg.equals(otherPeg)) 
				return true;
		}
		return false;
	}
	
	public String toString() {
		String result = "";
		for(Peg peg : code) {
			result += peg.toString();
		}
		return result;
	}
}
