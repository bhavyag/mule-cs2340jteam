package view.title;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * CLASS PlayerConfigPanel. For the JPanel that handles player configuration.
 * 
 * @author Chris
 * 
 */
public class PlayerConfigPanel extends JPanel {
	private ButtonGroup colorButtonGroup, raceButtonGroup;

	private JToggleButton nextButton, redButton, yellowButton, greenButton,
			purpleButton, humanButton, flapperButton, bonzoidButton,
			ugaiteButton, buzziteButton;

	private JTextField nameTextField;

	private JLabel playerConfigLabel;

	/**
	 * CONSTRUCTOR for the PlayerConfigPanel. Instantiates all of its buttons
	 * etc.
	 */
	protected PlayerConfigPanel() {
		this.colorButtonGroup = new ButtonGroup();
		this.raceButtonGroup = new ButtonGroup();

		this.nextButton = new JToggleButton("");
		this.redButton = new JToggleButton("");
		this.yellowButton = new JToggleButton("");
		this.greenButton = new JToggleButton("");
		this.purpleButton = new JToggleButton("");
		this.humanButton = new JToggleButton("");
		this.flapperButton = new JToggleButton("");
		this.bonzoidButton = new JToggleButton("");
		this.ugaiteButton = new JToggleButton("");
		this.buzziteButton = new JToggleButton("");

		this.nameTextField = new JTextField("");

		this.playerConfigLabel = new JLabel("");

		initialize();
	}

	/**
	 * METHOD that sets the initial state of the PlayerConfigPanel, adds all of
	 * its buttons, places them in button groups, etc.
	 */
	private void initialize() {
		this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.setLayout(null);
		this.add(nextButton);
		this.add(redButton);
		this.add(yellowButton);
		this.add(greenButton);
		this.add(purpleButton);
		this.add(humanButton);
		this.add(flapperButton);
		this.add(bonzoidButton);
		this.add(ugaiteButton);
		this.add(buzziteButton);
		this.add(nameTextField);
		this.add(playerConfigLabel);

		colorButtonGroup.add(redButton);
		colorButtonGroup.add(yellowButton);
		colorButtonGroup.add(greenButton);
		colorButtonGroup.add(purpleButton);

		raceButtonGroup.add(humanButton);
		raceButtonGroup.add(flapperButton);
		raceButtonGroup.add(bonzoidButton);
		raceButtonGroup.add(ugaiteButton);
		raceButtonGroup.add(buzziteButton);

		nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nextButton.setIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/config/next-unselect.png")));
		nextButton.setPressedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/config/next.png")));
		nextButton.setRolloverIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/config/next.png")));
		nextButton.setSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/config/next.png")));
		nextButton.setRolloverSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/config/next.png")));
		nextButton.setFocusPainted(false);
		nextButton.setBorderPainted(false);
		nextButton.setBorder(null);
		nextButton.setBounds(807, 491, 150, 48);

		redButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		redButton.setIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/red-unselected.png")));
		redButton.setPressedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/red.png")));
		redButton.setRolloverIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/red.png")));
		redButton.setRolloverSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/red.png")));
		redButton.setSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/red.png")));
		redButton.setFocusPainted(false);
		redButton.setBorderPainted(false);
		redButton.setBorder(null);
		redButton.setBounds(235, 240, 48, 48);

		yellowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		yellowButton.setIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/yellow-unselected.png")));
		yellowButton.setPressedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/yellow.png")));
		yellowButton.setRolloverIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/yellow.png")));
		yellowButton.setRolloverSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/yellow.png")));
		yellowButton.setSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/yellow.png")));
		yellowButton.setFocusPainted(false);
		yellowButton.setBorderPainted(false);
		yellowButton.setBorder(null);
		yellowButton.setBounds(427, 240, 48, 48);

		greenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		greenButton.setIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/green-unselected.png")));
		greenButton.setPressedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/green.png")));
		greenButton.setRolloverIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/green.png")));
		greenButton.setRolloverSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/green.png")));
		greenButton.setSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/green.png")));
		greenButton.setFocusPainted(false);
		greenButton.setBorderPainted(false);
		greenButton.setBorder(null);
		greenButton.setBounds(606, 240, 48, 48);

		purpleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		purpleButton.setIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/purple-unselected.png")));
		purpleButton.setPressedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/purple.png")));
		purpleButton.setRolloverIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/purple.png")));
		purpleButton.setRolloverSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/purple.png")));
		purpleButton.setSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/colors/purple.png")));
		purpleButton.setFocusPainted(false);
		purpleButton.setBorderPainted(false);
		purpleButton.setBorder(null);
		purpleButton.setBounds(799, 240, 48, 48);

		nameTextField.setBackground(new Color(66, 93, 140));
		nameTextField.setForeground(Color.WHITE);
		nameTextField.setFont(new Font("Impact", Font.PLAIN, 30));
		nameTextField.setBounds(235, 164, 240, 37);
		nameTextField.setColumns(10);

		humanButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		humanButton.setIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/human-unselect.png")));
		humanButton.setPressedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/human.png")));
		humanButton.setRolloverIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/human.png")));
		humanButton.setRolloverSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/human.png")));
		humanButton.setSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/human.png")));
		humanButton.setFocusPainted(false);
		humanButton.setBorderPainted(false);
		humanButton.setBorder(null);
		humanButton.setBounds(781, 372, 150, 48);

		flapperButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		flapperButton.setIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/flapper-unselect.png")));
		flapperButton.setPressedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/flapper.png")));
		flapperButton.setRolloverIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/flapper.png")));
		flapperButton.setRolloverSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/flapper.png")));
		flapperButton.setSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/flapper.png")));
		flapperButton.setFocusPainted(false);
		flapperButton.setBorderPainted(false);
		flapperButton.setBorder(null);
		flapperButton.setBounds(606, 372, 150, 48);

		bonzoidButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bonzoidButton.setIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/bonzoid-unselect.png")));
		bonzoidButton.setPressedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/bonzoid.png")));
		bonzoidButton.setRolloverIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/bonzoid.png")));
		bonzoidButton.setRolloverSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/bonzoid.png")));
		bonzoidButton.setSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/bonzoid.png")));
		bonzoidButton.setFocusPainted(false);
		bonzoidButton.setBorderPainted(false);
		bonzoidButton.setBorder(null);
		bonzoidButton.setBounds(427, 372, 150, 48);

		ugaiteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ugaiteButton.setIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/ugaite-unselect.png")));
		ugaiteButton.setPressedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/ugaite.png")));
		ugaiteButton.setRolloverIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/ugaite.png")));
		ugaiteButton.setRolloverSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/ugaite.png")));
		ugaiteButton.setSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/ugaite.png")));
		ugaiteButton.setFocusPainted(false);
		ugaiteButton.setBorderPainted(false);
		ugaiteButton.setBorder(null);
		ugaiteButton.setBounds(246, 372, 150, 48);

		buzziteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buzziteButton.setIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/buzzite-unselect.png")));
		buzziteButton.setPressedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/buzzite.png")));
		buzziteButton.setRolloverIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/buzzite.png")));
		buzziteButton.setRolloverSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/buzzite.png")));
		buzziteButton.setSelectedIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/Races/buzzite.png")));
		buzziteButton.setFocusPainted(false);
		buzziteButton.setBorderPainted(false);
		buzziteButton.setBorder(null);
		buzziteButton.setBounds(65, 372, 150, 48);

		playerConfigLabel.setCursor(Cursor
				.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		playerConfigLabel.setBounds(0, 0, 1000, 563);
	}

	/**
	 * METHOD that sets the image on the screen based on the player that needs
	 * to be configured.
	 * 
	 * @param playerNum
	 */
	protected void setPlayerNum(int playerNum) {
		playerConfigLabel.setIcon(new ImageIcon(TitleFrame.class
				.getResource("/sprites/player-config" + playerNum + ".png")));
		this.updateUI();
	}

	/**
	 * METHOD that gets the name of this player which was input into the
	 * PlayerConfig's text field
	 */
	protected String getPlayerName() {
		return nameTextField.getText();
	}

	/**
	 * METHOD that gets the color that was selected for the player.
	 * 
	 * @return the color that was selected for the player.
	 */
	protected int getColor() {
		if (redButton.isSelected()) {
			return 0;
		} else if (yellowButton.isSelected()) {
			return 1;
		} else if (greenButton.isSelected()) {
			return 2;
		} else if (purpleButton.isSelected()) {
			return 3;
		} else {
			return -1;
		}
	}

	/**
	 * METHOD that gets the race that was selected for the player.
	 * 
	 * @return the race that was selected for the player.
	 */
	protected int getRace() {
		if (humanButton.isSelected()) {
			return 0;
		} else if (flapperButton.isSelected()) {
			return 1;
		} else if (bonzoidButton.isSelected()) {
			return 2;
		} else if (ugaiteButton.isSelected()) {
			return 3;
		} else if (buzziteButton.isSelected()) {
			return 4;
		} else {
			return -1;
		}
	}

	/**
	 * METHOD that clears the previous input on the screen
	 */
	protected void clear() {
		nameTextField.setText("");
		colorButtonGroup.clearSelection();
		raceButtonGroup.clearSelection();
	}

	/**
	 * METHOD that adds a mouse adapter to the PlayerConfigPanel
	 * 
	 * @param mouseAdapter
	 *            the mouse listener to add to this panel
	 */
	protected void onClickNext(MouseAdapter mouseAdapter) {
		nextButton.addMouseListener(mouseAdapter);
	}
}
