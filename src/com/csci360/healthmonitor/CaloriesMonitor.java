package com.csci360.healthmonitor;

public class CaloriesMonitor extends Thread{
	
	private static final double STANDARD_MET = 7;
	private static final double STRENUOUS_MET = 8;
	private double calories;
	User user;
	private HeartRateMonitor hrm;
	private StepsMonitor sm;
	
	public CaloriesMonitor(HeartRateMonitor hrm, StepsMonitor sm) {
		calories = 0;
		user = User.getInstance();
		this.hrm = hrm;
		this.sm = sm;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				calculateCalories();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	public void calculateCalories() throws InterruptedException {
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
		
		Thread.sleep(5000);
		
	}
	
	public double getCalories() {
		calories = calories * 100;
		calories = Math.round(calories);
		calories = calories / 100;
		return calories;
	}
}
