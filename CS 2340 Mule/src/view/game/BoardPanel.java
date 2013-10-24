package view.game;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;

import javax.swing.*;

/**
 * CLASS BoardPanel. This JPanel will hold 2 other JPanels in a cardlayout and switch between them,
 *  depending on if the player is supposed to be in the town center or on the map.
 * @author Chris
 *
 */
public class BoardPanel extends JPanel {

	private JLabel boardLabel;
	private TilePanel tilePanel;
	private TownCenterPanel townCenterPanel;
	private CardLayout cardLayout;

	private final String
	TILES = "Tiles",
	TOWN_CENTER = "Town Center";

	/**
	 * CONSTRUCTOR for the BoardPanel, also creates it's 'sub' JPanels, the tilePanel and the townCenterPanel.
	 */
	public BoardPanel() {
		this.boardLabel = new JLabel("");
		this.tilePanel = new TilePanel();
		this.townCenterPanel = new TownCenterPanel();
		this.cardLayout = new CardLayout();
		this.initialize();
	}

	/**
	 * METHOD that sets the initial state of the of BoardPanel
	 */
	private void initialize() {
		this.add(boardLabel);
        this.setLayout(cardLayout);
        this.add(tilePanel, TILES);
        this.add(townCenterPanel, TOWN_CENTER);
        this.setBounds(168, 0, 832, 400);
	}
	
	/**
	 * METHOD that gets this BoardPanel's TilePanel
	 * @return this BoardPanel's TilePanel
	 */
	public TilePanel getTilePanel() {
		return tilePanel;
	}
	
	/**
	 * METHOD that tells this BoardPanel to display the TilePanel
	 */
	public void showTilePanel() {
		cardLayout.show(this, TILES);
	}
	
	/**
	 * METHOD that gets this BoardPanel's TownCenterPanel
	 * @return this BoardPanel's TownCenterPanel
	 */
	public TownCenterPanel getTownCenterPanel() {
		return townCenterPanel;
	}

	/**
	 * METHOD that tells this BoardPanel to display the TownCenterPanel
	 */
	public void showTownCenterPanel() {
		cardLayout.show(this, TOWN_CENTER);
	}
}
