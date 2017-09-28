package mastermind.models;

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
		assert value != null;
		for(char c : value.toCharArray()) {
			code.add(new Peg(Color.getColor("" + c)));
		}
	}
	
	public HashMap<Color, Integer> getBlacksAndWhites(Code other) {
		assert other != null;
		HashMap<Color, Integer> result = new HashMap<Color, Integer>();
		List<String> visitedCodeBreaker = new ArrayList<String>();
		List<String>  visitedCodeMaker = new ArrayList<String>();
		int whites = 0, blacks = 0;
		for(int i = 0; i < NUM_PEGS; i++) {
			if (this.code.get(i).equals(other.code.get(i)))
				blacks++;
			else {
				visitedCodeBreaker.add(other.code.get(i).toString());	
				visitedCodeMaker.add(this.code.get(i).toString());
			}
		}
		for(int i = 0; i < visitedCodeBreaker.size(); i++) {
			if (visitedCodeMaker.contains(visitedCodeBreaker.get(i)))
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
	
	public String toString() {
		String result = "";
		for(Peg peg : code) {
			result += peg.toString();
		}
		return result;
	}
}
