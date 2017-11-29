package fitbit;

public class ActivityController {
	
	private StepsMonitor sm;
	private HeartRateMonitor hrm;
	private CaloriesMonitor cm;
	
	public ActivityController() {
		User user = User.getInstance();
		user.setHeight(1.2);
		user.setWeight(73.4);
		user.setSex('M');
		sm = new StepsMonitor();
		hrm = new HeartRateMonitor();
		cm = new CaloriesMonitor(hrm, sm);
	}
	
	// start all the monitors
	public void startMonitors() {	
		
		hrm.start();
		sm.start();
		cm.start();
		
	}
	
	public int getSteps() {
		return sm.getCurrentSteps();
	}
	
	public float getHeartRate(){
		return hrm.getCurrentHeartRate();
	}
	
	public double getCalories() {
		return cm.getCalories(); 
	}
	
}
