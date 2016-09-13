
abstract class Employee {
	private Call currentCall = null;
	protected Rank rank;
	
	public Employee() {
		rank = Rank.Director;
	}
	
	public void receiveCall(Call call) {
		currentCall = call;
	}
	
	public void callCompleted() {
		currentCall = null;
	}
	
	public boolean isFree() {
		return currentCall == null;
	}
}
