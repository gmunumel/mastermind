package mastermind;

public class Peg {

	private Color color;
	
	public Peg() {
		color = Color.BLANCO;
	}
	
	public Peg(Color color) {
		this.color = color;
	}
	
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
	
	public Peg random() {
		return new Peg(Color.random());
	}
	
	public String toString() {
		return "" + color.toString();
	}
}
