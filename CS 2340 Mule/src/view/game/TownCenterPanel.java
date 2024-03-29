package view.game;

import view.title.TitlePanel;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Point;
import java.net.URL;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * CLASS TownCenterPanel. Displays the Town Center
 * 
 * @author Chris
 * 
 */
public class TownCenterPanel extends JPanel {
	private JLabel townCenterPanel;
	protected JLabel playerLabel;
	protected JLabel pubLabel;
	protected JLabel westExitLabel;
	protected JLabel eastExitLabel;
	protected JLabel muleStoreLabel;
	protected JLabel foodStoreLabel;
	protected JLabel smithoreStoreLabel;
	protected JLabel energyStoreLabel;
	protected JLabel crystiteStoreLabel;
	protected JLabel landStoreLabel;
	protected JLabel assayOfficeLabel;

	/**
	 * CONSTRUCTOR for the Town Center, instantiates the town centers label.
	 */
	protected TownCenterPanel() {
		this.townCenterPanel = new JLabel("");
		townCenterPanel.setBounds(5, 5, 832, 400);

		initialize();
	}

	/**
	 * Place the player in their default position in the town after a turn ends.
	 * They are blank so that their sprite can be setto the next player later.
	 */
	protected void defaultPlayerPos() {
		playerLabel.setIcon(null);
		playerLabel.setBounds(390, 184, 58, 43);
	}

	/**
	 * METHOD that draws the player at a certain x/y with a certain sprite
	 * 
	 * @param x
	 * @param y
	 * @param imagePath
	 */
	public void drawPlayer(final int x, final int y, URL imagePath) {
		ImageIcon icon = new ImageIcon(imagePath);
		this.playerLabel.setIcon(icon);
		this.playerLabel.setBounds(x, y, icon.getIconWidth(),
				icon.getIconHeight());

	}

	/**
	 * METHOD to set the initial state of the town center.
	 */
	private void initialize() {
		setLayout(null);
		playerLabel = new JLabel();
		playerLabel.setBounds(390, 184, 58, 43);
		this.add(playerLabel);

		foodStoreLabel = new JLabel("");
		foodStoreLabel.setBounds(624, 26, 131, 128);
		add(foodStoreLabel);

		muleStoreLabel = new JLabel("");
		muleStoreLabel.setBounds(624, 255, 131, 134);
		this.add(muleStoreLabel);

		smithoreStoreLabel = new JLabel("");
		smithoreStoreLabel.setBounds(473, 26, 130, 128);
		add(smithoreStoreLabel);

		energyStoreLabel = new JLabel("");
		energyStoreLabel.setBounds(240, 26, 131, 128);
		add(energyStoreLabel);

		crystiteStoreLabel = new JLabel("");
		crystiteStoreLabel.setBounds(89, 26, 131, 128);
		add(crystiteStoreLabel);

		landStoreLabel = new JLabel("");
		landStoreLabel.setBounds(240, 255, 131, 134);
		add(landStoreLabel);

		assayOfficeLabel = new JLabel("");
		assayOfficeLabel.setBounds(90, 255, 130, 134);
		add(assayOfficeLabel);

		pubLabel = new JLabel();
		pubLabel.setBounds(473, 255, 130, 134);
		this.add(pubLabel);

		westExitLabel = new JLabel();
		westExitLabel.setBounds(0, 0, 75, 400);
		add(westExitLabel);

		eastExitLabel = new JLabel("");
		eastExitLabel.setBounds(765, 0, 67, 400);
		add(eastExitLabel);

		this.add(townCenterPanel);
		this.setBounds(168, 0, 832, 400);
		townCenterPanel.setIcon(new ImageIcon(TitlePanel.class
				.getResource("/sprites/town-center.png")));

	}

	/**
	 * get the JLabel for the player
	 * 
	 * @return the JLabel for the player
	 */
	public JLabel getPlayerLabel() {
		return this.playerLabel;
	}

	/**
	 * get the label of the pub. I think this is useless actually but whatever.
	 * 
	 * @return the label for the pub.
	 */
	public JLabel getPubLabel() {
		return this.pubLabel;
	}
}
