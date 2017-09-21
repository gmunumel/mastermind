package mastermind;

public class Peg {

	private Color color;
	
//	private Position position;
	
	public Peg() {
		color = Color.NONE;
//		position = Position.NONE;
	}
	
	public Peg(Color color) {
		this();
		this.color = color;
	}
	
//	public Peg(Position position) {
//		this();
//		this.position = position;
//	}
//	
//	public Peg(Color color, Position position) {
//		this.color = color;
//		this.position = position;
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this == null) ? 0 : hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peg other = (Peg)obj;
		if (this.color.toString().compareTo(other.color.toString()) != 0)
			return false;
		
		return true;
	}
	
	public String toString() {
		return "" + color.toString(); //+ " || Position: " + position.toString();
	}
}
