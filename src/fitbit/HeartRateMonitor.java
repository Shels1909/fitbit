package fitbit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class HeartRateMonitor extends Thread {
	private float currentHeartRate;
	
	public HeartRateMonitor() {
		// set the initial heart rate to 0
		currentHeartRate = 0;
	}
	@Override 
	public void run() {
		startMonitoringPulse();
	}
	public void startMonitoringPulse() {			
		while(true) {
			try {
				readPulseDataFromFile("pulse_data.txt");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	public float getCurrentHeartRate() {
		return currentHeartRate;
	}
	
	public void readPulseDataFromFile(String path) throws InterruptedException{
    		BufferedReader pulseReader = null;
    		
    		try{   			
    			pulseReader = new BufferedReader(new FileReader(path));
    			String pulse;
    			while((pulse = pulseReader.readLine()) != null){
    					currentHeartRate = Float.parseFloat(pulse);
    					// get next heart rate data point every 10 seconds
    					Thread.sleep(10000);
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
