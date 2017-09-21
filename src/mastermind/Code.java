package mastermind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Code {
	
	public static final int NUM_PEGS = 4;
	
	private List<Peg> code;
	
	public Code() {
		code = new ArrayList<Peg>();
	}
	
	public Code(Peg peg) {
		this();
		assert peg != null;
		code.addAll(Collections.nCopies(NUM_PEGS, peg));
	}
	
	public List<Peg> getCode() {
		return code;
	}
	
	public void setPegInPosition(int index, Color color) {
		assert index > 0;
		assert color != null;
		code.add(index, new Peg(color));
	}
	
	public HashMap<Color, Integer> getBlacksAndWhites(Code other) {
		assert other != null;
		HashMap<Color, Integer> result = new HashMap<Color, Integer>();
		int whites = 0, blacks = 0;
		for(int i = 0; i < NUM_PEGS; i++) {
			if (code.get(i).equals(other.getCode().get(i)))
				blacks++;
			else if (other.contains(code.get(i)))
				whites++;	
		}
		result.put(Color.WHITE, whites);
		result.put(Color.BLACK, blacks);
		return result;
	}
	
	public String toString() {
		String result = "";
		for(Peg peg : code) {
			result += peg.toString();
		}
		return result;
	}
	
	private boolean contains(Peg otherPeg) {
		assert otherPeg != null;
		boolean result = false;
		for(Peg peg : code) {
			if (peg.equals(otherPeg)) 
				return true;
		}
		return result;
	}
}
