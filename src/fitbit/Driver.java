package fitbit;
/*
 * The purpose of this driver class is to test functionality during the development process
 * The
 */
public class Driver extends Thread{
	
	public static void main(String[] args) {
		
		createUser(78.3, 1.2, 'M');
		ActivityController ac = new ActivityController();	
		ac.startMonitors();
		while(true) {
			System.out.print("Cal:");
			System.out.println(ac.getCalories());
			System.out.print("HR: ");
			System.out.println(ac.getHeartRate());
			System.out.print("Steps: ");
			System.out.println(ac.getSteps());
		}
	}
	
	public static void createUser(double weight, double height, char sex) {
		User user = User.getInstance();
		user.setHeight(height);
		user.setWeight(weight);
		user.setSex(sex);
	}
}