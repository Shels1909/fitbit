package fitbit;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

/*
 * Test cases written using JUnit to test the steps monitor class
 */
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
