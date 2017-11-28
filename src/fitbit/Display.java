package fitbit;

import javax.swing.*; // Import of the JavaSwing library 

public class Display {
	
	/**
	 * This class is responsible for creating the Display of the
	 * 		fitbit using JavaSwing. This display should include the
	 * 		following:
	 * 		-A 'Welcome' screen for the user to see upon initial startup
	 * 	 	-A setup screen for the user to set up their device; within
	 * 			this setup there should be 6 different screens:
	 * 			-The user will enter their sex
	 *  		-The user will enter their age
	 *   		-The user will enter their weight
	 *    		-The user will enter their height
	 * 		-Screen 1: Clock display. Should display the current time and date.
	 * 		-Screen 2: Steps counted. Should display the current steps counted
	 * 			for the given day.
	 * 		-Screen 3: Calories burned. Should display the current total calories
	 * 			burned by the user for the given day.
	 * 		-Screen 4: Sleep data. Should display the last known information
	 * 			on the time the user spent asleep. 
	 * 
	 * Each screen (1-4) should have left and right arrows that will allow the user
	 * 		to cycle between them.
	 */
	
	JFrame frame; // Instantiate a new window frame 
	
    public Display(JFrame frame) {
    	
        this.frame = frame; // Create the frame 
        
    }

}
