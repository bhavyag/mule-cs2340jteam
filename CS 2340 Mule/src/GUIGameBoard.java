import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class GUIGameBoard {

	private JFrame frame;
	private CardLayout cardLayout;
	private final String gameBoardStr = "GUI Game Board";

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIGameBoard window = new GUIGameBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public GUIGameBoard() {
		System.out.println("GUIGAMEBOARD");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1006, 592);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_Title.class.getResource("/sprites/muleIcon.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(cardLayout);
		frame.setVisible(true);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel gameBoard = new JPanel();
		frame.getContentPane().add(gameBoard, "name_379706790293597");
		gameBoard.setLayout(null);
		
		JLabel gameBoardLabel = new JLabel("");
		gameBoardLabel.setIcon(new ImageIcon(GUIGameBoard.class.getResource("/sprites/mule-board.png")));
		gameBoardLabel.setBounds(0, 0, 1000, 563);
		gameBoard.add(gameBoardLabel);
	}
}
