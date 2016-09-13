
public enum Rank {
	Director(1),
	Manager(2),
	Respondent(3);
	
	private int value;
	
	Rank(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
