package com.csci360.healthmonitor;

public class ActivityFacade {
	
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
		return sm.getCurrentSteps();
	}
	
	public float getHeartRate(){
		return hrm.getCurrentHeartRate();
	}
	
	public double getCalories() {
		return cm.getCalories(); 
	}
	
}
