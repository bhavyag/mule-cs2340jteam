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
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class GUI_Title {

	private JFrame frame;
	private JPanel TitlePanel, GameConfigPanel, Player1ConfigPanel;
	private final ButtonGroup mapButtonGroup;
	private final ButtonGroup difficultyButtonGroup;
	private final ButtonGroup playerButtonGroup;
	private final ButtonGroup raceButtonGroup;
	private final ButtonGroup color1ButtonGroup;
	private JTextField nameTextField;
	private JButton btnStart;
	private JToggleButton nextButton;
	private CardLayout cardLayout;
	private final String title = "GUI Title", gameConfig = "Game Config", playerConfig = "Player Config";

	/**
	 * Create the application.
	 */
	public GUI_Title() {
		this.frame = new JFrame();
		this.mapButtonGroup = new ButtonGroup();
		this.difficultyButtonGroup = new ButtonGroup();
		this.playerButtonGroup = new ButtonGroup();
		this.raceButtonGroup = new ButtonGroup();
		this.nameTextField = new JTextField();
		this.color1ButtonGroup = new ButtonGroup();
		this.cardLayout = new CardLayout();

		initialize();
	}

	private void initialize() {
		initializeFrame();
		initializeTitlePanel();
		initializeGameConfigPanel();
		initializePlayerConfigPanel();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initializeFrame() {
		frame.setVisible(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_Title.class.getResource("/sprites/muleIcon.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1006, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(cardLayout);

	}

	private void initializeTitlePanel() {
		JLabel titleLabel = new JLabel("");
		titleLabel.setBounds(0, 0, 1000, 563);
		titleLabel.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/mule-title-1000x563.png")));

		TitlePanel = new JPanel();
		frame.getContentPane().add(TitlePanel, title);
		TitlePanel.setLayout(null);

		btnStart = new JButton("");
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnStart.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/start-button-selected.png")));
		btnStart.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/start-button-selected.png")));
		btnStart.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/start-button-selected.png")));
		btnStart.setBounds(375, 343, 250, 80);
		TitlePanel.add(btnStart);

		btnStart.setForeground(Color.WHITE);
		btnStart.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/start-button.png")));
		btnStart.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/start-button-selected.png")));
		btnStart.setOpaque(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setBorderPainted(false);
		btnStart.setFocusPainted(false);

		TitlePanel.add(titleLabel);
	}

	private void initializeGameConfigPanel() {

		GameConfigPanel = new JPanel();
		GameConfigPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(GameConfigPanel, gameConfig);
		GameConfigPanel.setLayout(null);

		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(frame.getContentPane(), gameConfig);			}
		});

		nextButton = new JToggleButton("");

		nextButton.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/next-unselect.png")));
		nextButton.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/next.png")));
		nextButton.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/next.png")));
		nextButton.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/next.png")));
		nextButton.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/next.png")));
		nextButton.setFocusPainted(false);
		nextButton.setBorderPainted(false);
		nextButton.setBorder(null);
		nextButton.setBounds(807, 493, 150, 48);
		GameConfigPanel.add(nextButton);

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
	}

	private void initializePlayerConfigPanel() {

		Player1ConfigPanel = new JPanel();
		Player1ConfigPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.getContentPane().add(Player1ConfigPanel, playerConfig);
		Player1ConfigPanel.setLayout(null);

		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(frame.getContentPane(), playerConfig);	
			}
		});
		
		JToggleButton nextButtonToStart = new JToggleButton("");
		nextButtonToStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				GameController.triggerStartGame();
			}
		});
		nextButtonToStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nextButtonToStart.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/next-unselect.png")));
		nextButtonToStart.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/next.png")));
		nextButtonToStart.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/next.png")));
		nextButtonToStart.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/next.png")));
		nextButtonToStart.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/SPRITES/next.png")));
		nextButtonToStart.setFocusPainted(false);
		nextButtonToStart.setBorderPainted(false);
		nextButtonToStart.setBorder(null);
		nextButtonToStart.setBounds(807, 491, 150, 48);
		Player1ConfigPanel.add(nextButtonToStart);

		JToggleButton redButton = new JToggleButton("");
		redButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		color1ButtonGroup.add(redButton);
		redButton.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/red-unselected.png")));
		redButton.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/red.png")));
		redButton.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/red.png")));
		redButton.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/red.png")));
		redButton.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/red.png")));
		redButton.setFocusPainted(false);
		redButton.setBorderPainted(false);
		redButton.setBorder(null);
		redButton.setBounds(235, 240, 48, 48);
		Player1ConfigPanel.add(redButton);

		JToggleButton yellowButton = new JToggleButton("");
		yellowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		color1ButtonGroup.add(yellowButton);
		yellowButton.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/yellow-unselected.png")));
		yellowButton.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/yellow.png")));
		yellowButton.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/yellow.png")));
		yellowButton.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/yellow.png")));
		yellowButton.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/yellow.png")));
		yellowButton.setFocusPainted(false);
		yellowButton.setBorderPainted(false);
		yellowButton.setBorder(null);
		yellowButton.setBounds(427, 240, 48, 48);
		Player1ConfigPanel.add(yellowButton);

		JToggleButton greenButton = new JToggleButton("");
		greenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		color1ButtonGroup.add(greenButton);
		greenButton.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/green-unselected.png")));
		greenButton.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/green.png")));
		greenButton.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/green.png")));
		greenButton.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/green.png")));
		greenButton.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/green.png")));
		greenButton.setFocusPainted(false);
		greenButton.setBorderPainted(false);
		greenButton.setBorder(null);
		greenButton.setBounds(606, 240, 48, 48);
		Player1ConfigPanel.add(greenButton);

		JToggleButton purpleButton = new JToggleButton("");
		purpleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		color1ButtonGroup.add(purpleButton);
		purpleButton.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/purple-unselected.png")));
		purpleButton.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/purple.png")));
		purpleButton.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/purple.png")));
		purpleButton.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/purple.png")));
		purpleButton.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/colors/purple.png")));
		purpleButton.setFocusPainted(false);
		purpleButton.setBorderPainted(false);
		purpleButton.setBorder(null);
		purpleButton.setBounds(799, 240, 48, 48);
		Player1ConfigPanel.add(purpleButton);

		nameTextField.setBackground(new Color(66, 93, 140));
		nameTextField.setForeground(Color.WHITE);
		nameTextField.setFont(new Font("Impact", Font.PLAIN, 30));
		nameTextField.setBounds(235, 164, 240, 37);
		Player1ConfigPanel.add(nameTextField);
		nameTextField.setColumns(10);

		JToggleButton humanButton1 = new JToggleButton("");
		humanButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		raceButtonGroup.add(humanButton1);
		humanButton1.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/human-unselect.png")));
		humanButton1.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/human.png")));
		humanButton1.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/human.png")));
		humanButton1.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/human.png")));
		humanButton1.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/human.png")));
		humanButton1.setFocusPainted(false);
		humanButton1.setBorderPainted(false);
		humanButton1.setBorder(null);
		humanButton1.setBounds(781, 372, 150, 48);
		Player1ConfigPanel.add(humanButton1);

		JToggleButton flapperButton1 = new JToggleButton("");
		flapperButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		raceButtonGroup.add(flapperButton1);
		flapperButton1.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/flapper-unselect.png")));
		flapperButton1.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/flapper.png")));
		flapperButton1.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/flapper.png")));
		flapperButton1.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/flapper.png")));
		flapperButton1.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/flapper.png")));
		flapperButton1.setFocusPainted(false);
		flapperButton1.setBorderPainted(false);
		flapperButton1.setBorder(null);
		flapperButton1.setBounds(606, 372, 150, 48);
		Player1ConfigPanel.add(flapperButton1);

		JToggleButton bonzoidButton1 = new JToggleButton("");
		bonzoidButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		raceButtonGroup.add(bonzoidButton1);
		bonzoidButton1.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/bonzoid-unselect.png")));
		bonzoidButton1.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/bonzoid.png")));
		bonzoidButton1.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/bonzoid.png")));
		bonzoidButton1.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/bonzoid.png")));
		bonzoidButton1.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/bonzoid.png")));
		bonzoidButton1.setFocusPainted(false);
		bonzoidButton1.setBorderPainted(false);
		bonzoidButton1.setBorder(null);
		bonzoidButton1.setBounds(427, 372, 150, 48);
		Player1ConfigPanel.add(bonzoidButton1);

		JToggleButton ugaiteButton1 = new JToggleButton("");
		ugaiteButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		raceButtonGroup.add(ugaiteButton1);
		ugaiteButton1.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/ugaite-unselect.png")));
		ugaiteButton1.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/ugaite.png")));
		ugaiteButton1.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/ugaite.png")));
		ugaiteButton1.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/ugaite.png")));
		ugaiteButton1.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/ugaite.png")));
		ugaiteButton1.setFocusPainted(false);
		ugaiteButton1.setBorderPainted(false);
		ugaiteButton1.setBorder(null);
		ugaiteButton1.setBounds(246, 372, 150, 48);
		Player1ConfigPanel.add(ugaiteButton1);

		JToggleButton buzziteButton1 = new JToggleButton("");
		buzziteButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		raceButtonGroup.add(buzziteButton1);
		buzziteButton1.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/buzzite-unselect.png")));
		buzziteButton1.setPressedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/buzzite.png")));
		buzziteButton1.setRolloverIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/buzzite.png")));
		buzziteButton1.setRolloverSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/buzzite.png")));
		buzziteButton1.setSelectedIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/Races/buzzite.png")));
		buzziteButton1.setFocusPainted(false);
		buzziteButton1.setBorderPainted(false);
		buzziteButton1.setBorder(null);
		buzziteButton1.setBounds(65, 372, 150, 48);
		Player1ConfigPanel.add(buzziteButton1);

		JLabel playerConfigLabel1 = new JLabel("");
		playerConfigLabel1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		playerConfigLabel1.setIcon(new ImageIcon(GUI_Title.class.getResource("/sprites/player-config1.png")));
		playerConfigLabel1.setBounds(0, 0, 1000, 563);
		Player1ConfigPanel.add(playerConfigLabel1);
	}
}
