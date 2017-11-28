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
			System.out.println(ac.getCalories());
		}
		
		/*System.out.println(ac.getCalories());
		 update the calories burned every 5 seconds and output the total calories burned so far
		while(true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ac.updateCalories();
			System.out.println(ac.getCalories());
		}
		*/
	}
	
	
	public static void createUser(double weight, double height, char sex) {
		User user = User.getInstance();
		user.setHeight(height);
		user.setWeight(weight);
		user.setSex(sex);
	}
}