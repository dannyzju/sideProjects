import java.util.*;

public class CallHandler {
	private final int LEVELS = 3;
	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;
	
	List<List<Employee>> employeeLevels;
	List<List<Call>> callQueues;
	
	public CallHandler() {
		employeeLevels = new ArrayList<List<Employee>>();
		callQueues = new ArrayList<List<Call>>();
		for (int i = 0; i < LEVELS; i++) {
			employeeLevels.add(new ArrayList<Employee>());
			callQueues.add(new ArrayList<Call>());
		}
		
	}
	
	public Employee getHandlerForCall(Call call) {
		//Find free respondent.
		for (Employee emp : employeeLevels.get(Rank.Respondent.getValue())) {
			if (emp.isFree()) {
				return emp;
			}
		}
		
		//Find free manager
		for (Employee emp : employeeLevels.get(Rank.Manager.getValue())) {
			if (emp.isFree()) {
				return emp;
			}
		}
		
		//Find free director
		for (Employee emp : employeeLevels.get(Rank.Director.getValue())) {
			if (emp.isFree()) {
				return emp;
			}
		}
		return null;
	}
	
	public void dispatchCall(Caller caller) {
		Call call = new Call(caller);
		dispatchCall(call);
	}
	
	public void dispatchCall(Call call) {
		Employee emp = getHandlerForCall(call);
		if (emp != null) {
			emp.receiveCall(call);
			call.setHandler(emp);
		} else {
			call.reply("Please wait for free employeee to reply");
			callQueues.get(call.getRank().getValue()).add(call);
		}
	}
}
