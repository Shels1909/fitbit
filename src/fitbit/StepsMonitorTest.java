package fitbit;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class StepsMonitorTest {
	private StepsMonitor sm;
	
	@Before
	public void setUp() throws Exception {
		sm = new StepsMonitor();
	}

	@Test
	public void testGetCurrentSteps() {
		assertEquals(0,sm.getCurrentSteps(),0);
	}

}
