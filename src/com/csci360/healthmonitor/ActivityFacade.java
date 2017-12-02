package com.csci360.healthmonitor;

public class ActivityFacade {
	
	// initialize the monitors to be used in the system 
	private StepsMonitor sm;
	private HeartRateMonitor hrm;
	private CaloriesMonitor cm;
	
	public ActivityFacade() {
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
		return sm.getCurrentSteps(); // get current steps walked by user 
	}
	
	public float getHeartRate(){
		return hrm.getCurrentHeartRate(); // get current heart rate of user
	}
	
	public double getCalories() {
		return cm.getCalories(); // get current calories burned by user
	}
	
}
