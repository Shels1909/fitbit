package com.csci360.healthmonitor;

public class UserCreator {
	private float height;
	private double weight;
	private char sex;
	private User user;
	public UserCreator(float height, double weight, char sex) {
		user = User.getInstance();
		
	}

	public void createUser() {
		// TODO Auto-generated method stub
		user.setHeight(height);
		user.setWeight(weight);
		user.setSex(sex);
	}
}
