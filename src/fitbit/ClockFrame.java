package fitbit;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class ClockFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockFrame frame = new ClockFrame();
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
	        g.drawString(time, 75, 75);
	    }

	}

	/**
	 * Create the frame.
	 */
	public ClockFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ClockPanel contentPane = new ClockPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		int delay = 1000; //milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				contentPane.repaint();
		      }
		  };
		  new Timer(delay, taskPerformer).start();
		  
	}

}
