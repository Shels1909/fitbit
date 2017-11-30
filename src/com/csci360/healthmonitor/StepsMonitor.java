package com.csci360.healthmonitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StepsMonitor extends Thread {
	
	private int currentSteps;
	public StepsMonitor() {
		currentSteps = 0;
	}
	
	public int getCurrentSteps() {
		return currentSteps;
	}
	
	public void run() {
		startMonitoringSteps();
	}

	private void startMonitoringSteps() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				readStepsDataFromFile("steps_data.txt");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	private void readStepsDataFromFile(String path) throws InterruptedException{
		BufferedReader stepsReader = null;
		
		try{   			
			stepsReader = new BufferedReader(new FileReader(path));
		    String line;
		    int steps;
			while((line = stepsReader.readLine()) != null){
				steps = Integer.parseInt(line);
				currentSteps += steps;
				// get next step data point every 5 seconds
				Thread.sleep(5000);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			if(stepsReader != null) {
				try {
				stepsReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		        		
	}
}
