package com.csci360.healthmonitor;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Timer;
import javax.swing.JButton;

public class Display extends JFrame {
	
	/**
	 * This class is responsible for creating the Display of the
	 * 		fitbit using JavaSwing. This display should include the
	 * 		following:
	 * 		
	 * 		-Screen 1: Clock display. Should display the current time and date.
	 * 		-Screen 2: Steps counted. Should display the current steps counted
	 * 			for the given day.
	 * 		-Screen 3: Calories burned. Should display the current total calories
	 * 			burned by the user for the given day.
	 * 		-Screen 4: Heart Rate. Should display the current heart rate
	 *                      of the user.
	 * 
	 * Each screen (1-4) should have left and right arrows that will allow the user
	 * 		to cycle between them.
	/**
	 *  Below are all of the variable initializations needed for creating the UI
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ClockPane clockPane;
	private StepsPane stepsPane;
	private CaloriesPane caloriesPane;
	private HeartRatePane heartRatePane;
	private AlarmPane alarmPane;
	private HeightPane heightPane;
	private WeightPane weightPane;
	private SexPane sexPane;
	private UserPane userPane;
	private String time;
	private String alarmTime = "";
	private char sex = 'M';
	private float height;
	private double weight;
	
	public ActivityFacade ac;
	private AlarmResultPane alarmResultPane;

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
	
	class HeightPane extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JButton nextButton;
		private JButton heightUpButton;
		private JButton heightDownButton;
		DecimalFormat df = new DecimalFormat("##.#");
		
		public HeightPane(JPanel panel) {
			contentPane = panel;
			setOpaque(true);
			setBackground(Color.BLACK);
			df.setRoundingMode(RoundingMode.DOWN);
			nextButton = new JButton("next");
			nextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
					cardLayout.show(contentPane, "Weight Pane");
				}
			});
			heightUpButton = new JButton("Up");
			heightUpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					height+=0.1;
					repaint();
				}
			});
			heightDownButton = new JButton("Down");
			heightDownButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					height-=0.1;
					repaint();
				}
			});
			
			add(heightUpButton);
			add(heightDownButton);
			add(nextButton);
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Apple LiGothic", Font.PLAIN, 26));
			String heightString = "Height: " + df.format(height) + " Meters";
			g.drawString("Set your height", 120, 60);
			g.drawString(heightString, 100, 150);
			
		}
		
	}
	class WeightPane extends JPanel{

		/**
		 * Creates a pane to use when utilizing the alarm feature of the system 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JButton nextButton;
		private JButton weightUpButton;
		private JButton weightDownButton;
		
		public WeightPane(JPanel panel) {
			contentPane = panel;
			setOpaque(true);
			setBackground(Color.BLACK);
			nextButton = new JButton("next");
			nextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
					cardLayout.show(contentPane, "Sex Pane");
				}
			});
			weightUpButton = new JButton("Up");
			weightUpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					weight++;
					repaint();
				}
			});
			weightDownButton = new JButton("Down");
			weightDownButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					weight--;
					repaint();
				}
			});
			
			add(weightUpButton);
			add(weightDownButton);
			add(nextButton);
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Apple LiGothic", Font.PLAIN, 26));
			g.drawString("Set your weight", 120, 60);
			String weightString = "Weight: " + Double.toString(weight) + " kg";
			g.drawString(weightString, 100, 150);
			
		}
		
	}
	
	class SexPane extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JButton nextButton;
		private JButton changeButton;
		
		public SexPane(JPanel panel) {
			contentPane = panel;
			setOpaque(true);
			setBackground(Color.BLACK);
			changeButton = new JButton("Change Sex");
			changeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(sex == 'M') {
						sex = 'F';
					}
					else {
						sex = 'M';
					}
					repaint();
				}
			});
			nextButton = new JButton("next");
			nextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
					cardLayout.show(contentPane, "User Pane");
				}
			});
			add(changeButton);
			add(nextButton);
		}
		
		@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Apple LiGothic", Font.PLAIN, 26));
			String sexString = "Sex: " + sex;
			g.drawString("Set your sex", 120, 60);
	        g.drawString(sexString, 150, 150);
	    }
		
		
		
	}
	class UserPane extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JButton confirmButton;
		private JButton redoButton;
		private DecimalFormat df;
		public UserPane(JPanel panel) {
			contentPane = panel;
			setOpaque(true);
			setBackground(Color.BLACK);
			df = new DecimalFormat("##.#");
			df.setRoundingMode(RoundingMode.DOWN);
			confirmButton = new JButton("Confirm");
			confirmButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					// create the global user object
					UserCreator uc = new UserCreator(height, weight, sex);
					uc.createUser();
					// create the activity facade and start the external monitors
					ac = new ActivityFacade();
					ac.startMonitors();
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "Clock Pane");
				}
			});
			redoButton = new JButton("Redo");
			redoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					// create the global user object
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "Height Pane");
				}
			});
			add(redoButton);
			add(confirmButton);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Apple LiGothic", Font.PLAIN, 26));
			String heightString = "Height: " + df.format(height) + " meters";
			String weightString = "Weight: " + Double.toString(weight) + " kg";
			String sexString = "Sex: " + sex;
	        g.drawString(heightString, 150, 60);
	        g.drawString(weightString, 150, 150);
	        g.drawString(sexString, 150, 250);

		}
		
		
	}
	class AlarmResultPane extends JPanel{

		/**
		 * Creates a pane to use when utilizing the alarm feature of the system 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JButton clock;
		
		public AlarmResultPane(JPanel panel) {
			contentPane = panel;
			setOpaque(true);
			setBackground(Color.BLACK);
			
			
			clock = new JButton("Clock");
			clock.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "Clock Pane");
				}
			});
			
			add(clock);
		}
		
		@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Apple LiGothic", Font.PLAIN, 26));
	        g.drawString("ALARM!!", 150, 150);
	    }
		
	}
	class HeartRatePane extends JPanel {
<<<<<<< HEAD
		/**
		 * Creates a pane for displaying the heart rate 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
=======

	    private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
>>>>>>> b74f47bcca82f32d629cff15c553eb83a999e001
	    private JButton nextPane;
	    private JButton backPane;

		/**
		 * Creates a pane for displaying the heart rate 
		 */
		public HeartRatePane(JPanel panel) {
			contentPane = panel;
			setOpaque(true);
			setBackground(Color.BLACK);
			//construct components
	        nextPane = new JButton ("Next Screen");
	        nextPane.addActionListener( new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "Clock Pane");
	            }
	        });
	        backPane = new JButton ("Previous Screen");
	        backPane.addActionListener( new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.previous(contentPane);
	            }
	        });
	        add(backPane);
	        add(nextPane);
		}	
		
		@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        float hrf = ac.getHeartRate();
			String heartRate = Float.toString(hrf);
			String heartRateMessage = "HeartRate: " + heartRate + " BPM";
			g.setColor(Color.WHITE);
			g.setFont(new Font("Apple LiGothic", Font.PLAIN, 26));
	        g.drawString(heartRateMessage, 100, 150);
	    }

	}
	
	class CaloriesPane extends JPanel {

		/**
		 * Creates a pane used for viewing the number of daily calories burned
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
	    private JButton nextPane;
	    private JButton backPane;

<<<<<<< HEAD
	    
=======
		/**
		 * Creates a pane used for viewing the number of daily calories burned
		 */
>>>>>>> b74f47bcca82f32d629cff15c553eb83a999e001
		public CaloriesPane(JPanel panel) {
			contentPane = panel;
			setOpaque(true);
			setBackground(Color.BLACK);
			//construct components
	        nextPane = new JButton ("Next Screen");
	        nextPane.addActionListener( new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.next(contentPane);
	            }
	        });
	        backPane = new JButton ("Previous Screen");
	        backPane.addActionListener( new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.previous(contentPane);
	            }
	        });
	        add(backPane);
	        add(nextPane);
	        nextPane.setLocation(0, 0);

		}	
		
		@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        double caloriesDouble = ac.getCalories();
			String calories = Double.toString(caloriesDouble);
			String caloriesMessage = "Calories Burned: " + calories;
			g.setColor(Color.WHITE);
			g.setFont(new Font("Apple LiGothic", Font.PLAIN, 26));
	        g.drawString(caloriesMessage, 70, 150);
	    }

	}
	
	class AlarmPane extends JPanel{

		/**
		 * Creates a pane used when utilizing the alarm feature of the system 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JButton hour;
		private JButton minute;
		private JButton clock;
		private JButton setAlarm;
		private String time;
		private Date d = new Date();
		private Calendar c;
		
		public AlarmPane(JPanel panel) {
			contentPane = panel;
			setOpaque(true);
			setBackground(Color.BLACK);
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			buttonPanel.setBackground(Color.BLACK);
			
			JPanel textPanel = new JPanel();
			textPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			textPanel.setBackground(Color.BLACK);
			
			setAlarm = new JButton("Set");
			setAlarm.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e)
				{
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
					alarmTime = sdf.format(c.getTime());
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
					cardLayout.show(contentPane, "Clock Pane");
				}
			});
			hour = new JButton("Hour");
			hour.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e)
				{
			        c.add(Calendar.HOUR, 1);
			        d = c.getTime();
			        repaint();
		
				}
			});
			
			minute = new JButton("Minute");
			minute.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e)
				{
					c.add(Calendar.MINUTE, 1);
			        d = c.getTime();
			        repaint();
				}
			});
			
			clock = new JButton("Back to Clock");
			clock.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e)
				{
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
					cardLayout.show(contentPane, "Clock Pane");
				}
			});
			add(minute);
			add(setAlarm);
			add(hour);
			
		}
		
		@Override
	    protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			c = Calendar.getInstance();
			c.setTime(d);
			c.set(Calendar.SECOND, 0);
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
			time = sdf.format(c.getTime());
			g.setColor(Color.WHITE);
			g.setFont(new Font("Apple LiGothic", Font.PLAIN, 26));
			g.drawString(time, 150, 150);
		}
		
	}
	
	class ClockPane extends JPanel {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
	    private JButton nextPane;
	    private JButton backPane;
	    private JButton alarm;

<<<<<<< HEAD
	    /**
=======
		/**
>>>>>>> b74f47bcca82f32d629cff15c553eb83a999e001
		 * Creates a pane for viewing the current time 
		 */
		public ClockPane(JPanel panel) {
			contentPane = panel;
			setOpaque(true);
			setBackground(Color.BLACK);
			//construct components
	        nextPane = new JButton ("Next Screen");
	        nextPane.addActionListener( new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.next(contentPane);
	            }
	        });
	        backPane = new JButton ("Previous Screen");
	        backPane.addActionListener( new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "HeartRate Pane");
	                
	            }
	        });
	        alarm = new JButton("Alarm");
	        alarm.addActionListener(new ActionListener()
	        	{
	        		public void actionPerformed(ActionEvent e)
	        		{
	        			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	        			cardLayout.show(contentPane, "Alarm Pane");
	        		}
	        	});
	        
	        add(backPane);
	        add(alarm);
	        add(nextPane);

		}	
		 
		@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Apple LiGothic", Font.PLAIN, 26));	
			g.drawString(time, 150, 150);
	    }

	}
	
	class StepsPane extends JPanel{
		
		/**
		 * Creates a pane for viewing the total number of daily steps taken 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
	    private JButton nextPane;
	    private JButton backPane;


		public StepsPane(JPanel panel) {
			contentPane = panel;
	        setOpaque(true);
	        setBackground(Color.BLACK);
	       
	        
	        nextPane = new JButton ("Next Screen");
	        nextPane.addActionListener( new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.next(contentPane);
	            }
	        });
	        
	        
	        backPane = new JButton ("Previous Screen");
	        backPane.addActionListener( new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.previous(contentPane);
	            }
	        });
	        add(backPane);
	        add(nextPane);
	     
	      
		}	
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int stepsInt = ac.getSteps();
			String steps = Integer.toString(stepsInt);
			String stepsMessage = "Steps Taken: " + steps;
			g.setColor(Color.WHITE);
			g.setFont(new Font("Apple LiGothic", Font.PLAIN, 26));
	        g.drawString(stepsMessage, 100, 150);
			
		}
		
	}

	/**
	 * Create the main display
	 */
	public Display() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// create main panel
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout());
		setContentPane(contentPane);
		
		// create and add all the views for the fitbit device		
		heightPane = new HeightPane(contentPane);
		weightPane = new WeightPane(contentPane);
		sexPane = new SexPane(contentPane);
		userPane = new  UserPane(contentPane);
		contentPane.add(heightPane, "Height Pane");
		contentPane.add(weightPane, "Weight Pane");
		contentPane.add(weightPane, "Weight Pane");
		contentPane.add(sexPane, "Sex Pane");
		contentPane.add(userPane, "User Pane");
		clockPane = new ClockPane(contentPane);
		stepsPane = new StepsPane(contentPane);
		caloriesPane = new CaloriesPane(contentPane);
		heartRatePane = new HeartRatePane(contentPane);
		alarmPane = new AlarmPane(contentPane);
		alarmResultPane = new AlarmResultPane(contentPane);
        contentPane.add(clockPane, "Clock Pane"); 
        contentPane.add(stepsPane, "Steps Pane");
        contentPane.add(caloriesPane, "Calories Pane");
        contentPane.add(heartRatePane, "HeartRate Pane");
        contentPane.add(alarmResultPane, "AlarmResult Pane");
        contentPane.add(alarmPane, "Alarm Pane");
       
        // Update the contents every second
		int delay = 1000; //milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// update the global clock
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
				time = sdf.format(d);				
				if(time.equals(alarmTime)) {
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	    				cardLayout.show(contentPane, "AlarmResult Pane");
				}			
				// repaint all the displays except the alarmSet pane
				stepsPane.repaint();
				clockPane.repaint();
				caloriesPane.repaint();
				heartRatePane.repaint();	

		      }
		  };
		  new Timer(delay, taskPerformer).start();	  
		  
	}
	

}
