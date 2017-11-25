package fitbit;

public class HeartRateMonitorDriver {
	
	public static void main(String[] args) {
		HeartRateMonitor hrm = new HeartRateMonitor();
		hrm.start();
		while(true) {
			System.out.println(hrm.getCurrentHeartRate());
		}
	}
}