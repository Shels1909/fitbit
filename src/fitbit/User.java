package fitbit;

public final class User {
	private static volatile User instance = null;
	private double weight;
	private double height;
	private char sex;

    User() {}

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
    
    public void setWeight(double weight) {
    		this.weight = weight;
    }
    
    public void setHeight(double height) {
    		this.height = height;
    }
    
    public void setSex(char sex) {
    		this.sex = sex;
    }
    
    public double getWeight() {
    		return weight;
    }
    
    public double getHeight() {
    		return height;
    }
    
    public char getSex() {
    		return sex;
    }
    
}
