package fitbit;

public class MonitorDriver {
	
	public static void main(String[] args) {
		HeartRateMonitor hrm = new HeartRateMonitor();
		hrm.start();
		StepsMonitor sm = new StepsMonitor();
		sm.start();
	}
}