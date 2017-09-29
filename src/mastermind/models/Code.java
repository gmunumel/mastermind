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
		List<String> codeBreaker = getListString(other.toString());
		List<String> codeMaker = getListString(this.toString());
		int whites = 0, blacks = 0, matched = -1;
		for(int i = 0; i < codeBreaker.size(); i++) {
			if (codeBreaker.get(i).equals(codeMaker.get(i))) {
				blacks++;
				codeMaker.set(i, "" + i);
			}  
		}   
		for(int i = 0; i < codeBreaker.size(); i++) {
			matched = codeMaker.lastIndexOf(codeBreaker.get(i));
			if (matched != -1) {
				whites++;
				codeMaker.set(matched, "" + matched);
			} 
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
	
	private List<String> getListString(String value) {
		List<String> result = new ArrayList<String>();
		for(char c : value.toCharArray()) {
			result.add("" + c);
		}
		return result;
	}
}
