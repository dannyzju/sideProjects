
public class Call {
	/* Minimal rank of employee who can handle this call. */
	private Rank rank;
	
	/* Person who is calling. */
	private Caller caller;
	
	/* Employee who is handling call. */
	private Employee handler;
	
	public Call (Caller c) {
		rank = Rank.Respondent;
		caller = c;
	}
	
	public void setHandler(Employee e) {
		handler = e;
	}
	
	public void reply(String message) {
		//TODO
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public void setRank(Rank r) {
		rank = r;
	}
	
	public Rank incrementRank() {
		//TODO
		return rank;
	}
	
	public void disconnect () {
		//TODO;
	}
}
