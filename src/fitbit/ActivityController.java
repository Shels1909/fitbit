package fitbit;

public class ActivityController extends Thread {
	private static final double STANDARD_MET = 6;
	private static final double STRENUOUS_MET = 9;
	private double calories = 0;
	private StepsMonitor sm;
	private HeartRateMonitor hrm;
	private User user;
	
	public ActivityController() {
		user = User.getInstance();
		sm = new StepsMonitor();
		hrm = new HeartRateMonitor();
	}
	
	// start the heartrate and steps monitor
	public void startMonitors() {
		hrm.start();
		sm.start();
	}
	public int getSteps() {
		return sm.getCurrentSteps();
	}
	
	public float getHeartRate(){
		return hrm.getCurrentHeartRate();
	}
	
	// update the calories burned based on the intensity of the user's current activity
	public void updateCalories() {
		
		float steps = sm.getCurrentSteps();
		float heartrate = hrm.getCurrentHeartRate();
	
		if(steps > 0 && heartrate > 60) {
			calories += (user.getWeight() * STANDARD_MET) / 60; 
		}
		if(steps > 5 && heartrate > 80) {
			calories += (user.getWeight() * STRENUOUS_MET) / 60; 
		}
		else {
			calories += STANDARD_MET;
		}
	}
	
	public double getCalories() {
		return calories;
	}
}
