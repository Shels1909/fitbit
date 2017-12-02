package com.csci360.healthmonitor;

public final class User {
	//initialize variables needed for user 
	private static volatile User instance = null;
	private double weight;
	private double height;
	private char sex;

    User() {}

    // if there is no user, create a new instance of user
    public static User getInstance() {
        if (instance == null) {
            synchronized(User.class) {
                if (instance == null) {
                    instance = new User();
                }
            }
        }
        return instance;
    }
    
    public void setWeight(double weight) { //set weight of user
    		this.weight = weight;
    }
    
    public void setHeight(double height) { //set height of user
    		this.height = height;
    }
    
    public void setSex(char sex) { // set sex of user
    		this.sex = sex;
    }
    
    public double getWeight() { // get weight of user
    		return weight;
    }
    
    public double getHeight() { // get height of user
    		return height;
    }
    
    public char getSex() { // get sex of user
    		return sex;
    }
    
}
