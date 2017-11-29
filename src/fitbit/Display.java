package fitbit;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Display extends JFrame {
	
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	class ClockPanel extends JPanel {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 
		 */
		
		@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
			String time = sdf.format(d);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
	        g.drawString(time, 150, 150);
	    }

	}

	/**
	 * Create the frame.
	 */
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ClockPanel contentPane = new ClockPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnButton = new JButton("button");
		btnButton.setAction(action);
		getContentPane().add(btnButton, BorderLayout.SOUTH);
		
		int delay = 1000; //milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				contentPane.repaint();
		      }
		  };
		  new Timer(delay, taskPerformer).start();
		  
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
