package fitbit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import org.junit.Test;

public class HeartRateMonitorTest {
	private HeartRateMonitor hr;
	
	@Before
	public void setup() throws Exception{
		hr = new HeartRateMonitor();
	}

	@Test
	public void testGetCurrentHeartRate() {
		assertEquals(0,hr.getCurrentHeartRate(),0);
	}

}
