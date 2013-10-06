import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Color;


public class GUI_Title {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GUI_Title window = new GUI_Title();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Title() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1006, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("");
		btnStart.setForeground(Color.WHITE);
		btnStart.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/start-button.png")));
		btnStart.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/start-button-selected.png")));
		btnStart.setBounds(376, 397, 248, 57);
		btnStart.setOpaque(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setBorderPainted(false);
		btnStart.setFocusPainted(false);
		frame.getContentPane().add(btnStart);
		
		Component glue = Box.createGlue();
		glue.setBounds(22, 26, 1, 1);
		frame.getContentPane().add(glue);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/mule-title-1000x563.png")));
		lblNewLabel.setBounds(0, 0, 1000, 563);
		frame.getContentPane().add(lblNewLabel);
	}
}
