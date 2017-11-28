package fitbit;

public class ActivityController {
	
	private StepsMonitor sm;
	private HeartRateMonitor hrm;
	private CaloriesMonitor cm;
	
	public ActivityController() {
		sm = new StepsMonitor();
		hrm = new HeartRateMonitor();
		cm = new CaloriesMonitor(hrm, sm);
	}
	
	// start the heartrate and steps monitor
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
