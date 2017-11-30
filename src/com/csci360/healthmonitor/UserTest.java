package com.csci360.healthmonitor;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;
	
	@Before
	public void setUp() throws Exception {
		user = User.getInstance();
	}

	@Test
	public void testSetWeight() {
		user.setWeight(111);
		assertEquals(111, user.getWeight(), 0);
	}
	
	@Test
	public void testSetHeight() {
		user.setHeight(165);
		assertEquals(165, user.getHeight(), 0);
	}
	
	@Test
	public void testSetSex() {
		user.setSex('F');
		assertEquals('F', user.getSex(), 0);
	}
	
	@Test
	public void testGetWeight() {
		user.setWeight(111);
		assertEquals(111, user.getWeight(), 0);
	}
	
	@Test
	public void testGetHeight() {
		user.setHeight(111);
		assertEquals(111, user.getHeight(), 0);
	}
	
	@Test
	public void testGetSex() {
		user.setSex('F');
		assertEquals('F', user.getSex(), 0);
	}

}
