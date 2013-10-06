import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;


public class GUI_Title {

	private JFrame frame;
	private final ButtonGroup mapButtonGroup = new ButtonGroup();
	private final ButtonGroup difficultyButtonGroup = new ButtonGroup();
	private final ButtonGroup playerButtonGroup = new ButtonGroup();

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
		frame.getContentPane().setLayout(new CardLayout());
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setBounds(0, 0, 1000, 563);
		titleLabel.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/mule-title-1000x563.png")));
		
		JPanel TitlePanel = new JPanel();
		frame.getContentPane().add(TitlePanel, "name_113771867568751");
		TitlePanel.setLayout(null);
		
		JButton btnStart = new JButton("");
		btnStart.setBounds(375, 343, 250, 80);
		TitlePanel.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});		
		
		btnStart.setForeground(Color.WHITE);
		btnStart.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/start-button.png")));
		btnStart.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/start-button-selected.png")));
		btnStart.setOpaque(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setBorderPainted(false);
		btnStart.setFocusPainted(false);

		TitlePanel.add(titleLabel);
		
		JPanel GameConfigPanel = new JPanel();
		GameConfigPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(GameConfigPanel, "name_114307841629191");
		GameConfigPanel.setLayout(null);
		
		JToggleButton map1Button = new JToggleButton("");
		mapButtonGroup.add(map1Button);
		map1Button.setFocusPainted(false);
		map1Button.setBorderPainted(false);
		map1Button.setBorder(null);
		map1Button.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/map1.png")));
		map1Button.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/map1.png")));
		map1Button.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/map1.png")));
		map1Button.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/map1unselect.png")));
		map1Button.setBounds(291, 183, 200, 117);
		GameConfigPanel.add(map1Button);
		
		JToggleButton map2Button = new JToggleButton("");
		mapButtonGroup.add(map2Button);
		map2Button.setFocusPainted(false);
		map2Button.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/map2.png")));
		map2Button.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/map2.png")));
		map2Button.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/map2.png")));
		map2Button.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/map2unselect.png")));
		map2Button.setBounds(639, 183, 200, 117);
		GameConfigPanel.add(map2Button);
		
		JToggleButton easyButton = new JToggleButton("");
		easyButton.setFocusPainted(false);
		easyButton.setBorderPainted(false);
		difficultyButtonGroup.add(easyButton);
		easyButton.setBorder(null);
		easyButton.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/easy.png")));
		easyButton.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/easy.png")));
		easyButton.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/easy.png")));
		easyButton.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/easyunselect.png")));
		easyButton.setBounds(336, 341, 150, 48);
		GameConfigPanel.add(easyButton);
		
		JToggleButton mediumButton = new JToggleButton("");
		difficultyButtonGroup.add(mediumButton);
		mediumButton.setFocusPainted(false);
		mediumButton.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/mediumunselect.png")));
		mediumButton.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/medium.png")));
		mediumButton.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/medium.png")));
		mediumButton.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/medium.png")));
		mediumButton.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/medium.png")));
		mediumButton.setBorderPainted(false);
		mediumButton.setBorder(null);
		mediumButton.setBounds(556, 341, 150, 48);
		GameConfigPanel.add(mediumButton);
		
		JToggleButton hardButton = new JToggleButton("");
		difficultyButtonGroup.add(hardButton);
		hardButton.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/hardunselect.png")));
		hardButton.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/hard.png")));
		hardButton.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/hard.png")));
		hardButton.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/hard.png")));
		hardButton.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/hard.png")));
		hardButton.setFocusPainted(false);
		hardButton.setBorderPainted(false);
		hardButton.setBorder(null);
		hardButton.setBounds(780, 341, 150, 48);
		GameConfigPanel.add(hardButton);
		
		JToggleButton p2Button = new JToggleButton("");
		playerButtonGroup.add(p2Button);
		p2Button.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/2unselect.png")));
		p2Button.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/2.png")));
		p2Button.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/2.png")));
		p2Button.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/2.png")));
		p2Button.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/2.png")));
		p2Button.setFocusPainted(false);
		p2Button.setBorderPainted(false);
		p2Button.setBorder(null);
		p2Button.setBounds(387, 400, 48, 48);
		GameConfigPanel.add(p2Button);
		
		JToggleButton p3Button = new JToggleButton("");
		playerButtonGroup.add(p3Button);
		p3Button.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/3unselect.png")));
		p3Button.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/3.png")));
		p3Button.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/3.png")));
		p3Button.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/3.png")));
		p3Button.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/3.png")));
		p3Button.setFocusPainted(false);
		p3Button.setBorderPainted(false);
		p3Button.setBorder(null);
		p3Button.setBounds(607, 400, 48, 48);
		GameConfigPanel.add(p3Button);
		
		JToggleButton p4Button = new JToggleButton("");
		playerButtonGroup.add(p4Button);
		p4Button.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/4unselect.png")));
		p4Button.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/4.png")));
		p4Button.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/4.png")));
		p4Button.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/4.png")));
		p4Button.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/4.png")));
		p4Button.setFocusPainted(false);
		p4Button.setBorderPainted(false);
		p4Button.setBorder(null);
		p4Button.setBounds(831, 400, 48, 48);
		GameConfigPanel.add(p4Button);
		
		JLabel gameConfigLabel = new JLabel("");
		gameConfigLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		gameConfigLabel.setBounds(0, 0, 1000, 563);
		gameConfigLabel.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/mule-config.png")));
		GameConfigPanel.add(gameConfigLabel);
		
		JPanel Player1ConfigPanel = new JPanel();
		frame.getContentPane().add(Player1ConfigPanel, "name_114575770316570");
		
		JPanel Player2ConfigPanel = new JPanel();
		frame.getContentPane().add(Player2ConfigPanel, "name_114609488731357");
		
		JPanel Player3ConfigPanel = new JPanel();
		frame.getContentPane().add(Player3ConfigPanel, "name_114634527618031");
		
		JPanel Player4ConfigPanel = new JPanel();
		frame.getContentPane().add(Player4ConfigPanel, "name_114642598948613");
		
	}
}
