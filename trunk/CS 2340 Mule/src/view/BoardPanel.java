package view;

import java.awt.CardLayout;

import javax.swing.*;

public class BoardPanel extends JPanel {

	private JLabel boardLabel;
	private TilePanel tilePanel;
	private TownCenterPanel townCenterPanel;
	private CardLayout cardLayout;

	private final String
	TILES = "Tiles",
	TOWN_CENTER = "Town Center";


	public BoardPanel() {
		this.boardLabel = new JLabel("");
		this.tilePanel = new TilePanel();
		this.townCenterPanel = new TownCenterPanel();
		this.cardLayout = new CardLayout();
		initialize();
	}

	private void initialize() {
		this.setLayout(cardLayout);
		this.add(boardLabel);
		this.add(tilePanel, TILES);
		this.add(townCenterPanel, TOWN_CENTER);

		boardLabel.setBounds(168, 0, 832, 400);
		boardLabel.setIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/mule-board.png"))); //CHANGE THIS SHIT
	}



	public TilePanel getTilePanel() {
		return tilePanel;
	}

	public void showTilePanel() {
		cardLayout.show(this, TILES);
	}

	public TownCenterPanel getTownCenterPanel() {
		return townCenterPanel;
	}

	public void showTownCenterPanel() {
		cardLayout.show(this, TOWN_CENTER);
	}

}
