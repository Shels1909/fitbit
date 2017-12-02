package com.csci360.healthmonitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class HeartRateMonitor extends Thread {
	private static final String PATH = "pulse_data.txt";
	private float currentHeartRate;
	
	public HeartRateMonitor() {
		// set the initial heart rate to 0
		currentHeartRate = 0;
	}
	
	// run the pulse data 
	@Override 
	public void run() {
		startMonitoringPulse();
	}
	
	// method to begin reading pulse data from a file
	public void startMonitoringPulse() {			
		while(true) {
			try {
				readPulseDataFromFile();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	// get the current heart rate 
	public float getCurrentHeartRate() { 
		return currentHeartRate;
	}
	
	// method to read pulse data from a text file. as long as there is pulse
	// information available in the file, the method will continue to obtain
	// the next heart rate data point every 5 seconds
	public void readPulseDataFromFile() throws InterruptedException{
    		BufferedReader pulseReader = null;
    		try{   			
    			pulseReader = new BufferedReader(new FileReader(PATH));
    			String pulse;
    			while((pulse = pulseReader.readLine()) != null){
    					currentHeartRate = Float.parseFloat(pulse);
    					// get next heart rate data point every 5 seconds
    					Thread.sleep(5000);
    			}
    		}
    		catch(IOException e){
    			e.printStackTrace();
    		}
    		finally {
    			if(pulseReader != null) {
    				try {
					pulseReader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
    		}
    }
	
}
