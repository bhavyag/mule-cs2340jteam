package view.game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.geom.Area;
import java.net.URL;

import javax.swing.*;

/**
 * CLASS BoardPanel. This JPanel will hold 2 other JPanels in a cardlayout and switch between them,
 *  depending on if the player is supposed to be in the town center or on the map.
 * @author Chris
 *
 */
public class BoardPanel extends JPanel {

    private TilePanel tilePanel;
	private TownCenterPanel townCenterPanel;
	protected MarketPanel marketPanel;
	protected EndGamePanel endGamePanel;
	private CardLayout cardLayout;
    protected JLabel playerLabel;
    protected boolean inTownCenter;

	private final String
	TILES = "Tiles",
	TOWN_CENTER = "Town Center",
	MARKET = "Market",
	ENDGAME ="End Game";
	

	/**
	 * CONSTRUCTOR for the BoardPanel, also creates it's 'sub' JPanels, the tilePanel and the townCenterPanel.
	 */
	protected BoardPanel() {
		this.tilePanel = new TilePanel();
		this.townCenterPanel = new TownCenterPanel();
		this.marketPanel = new MarketPanel();
		this.endGamePanel = new EndGamePanel();
		this.cardLayout = new CardLayout();
		this.initialize();
	}

	/**
	 * METHOD that sets the initial state of the of BoardPanel
	 */
	private void initialize() {
        this.setBounds(168, 0, 832, 400);
        this.setLayout(cardLayout);
        this.add(townCenterPanel, TOWN_CENTER);
        this.add(tilePanel, TILES);
        this.add(marketPanel,MARKET);
        this.add(endGamePanel, ENDGAME);
	}
	
	public int checkCollisions(){
		int collisionCode;
		
		if(this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.pubLabel))
		{
			collisionCode = 0;
		}
		else if(this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.westExitLabel))
		{
            collisionCode = 1;
		}
		else if(this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.eastExitLabel))
		{
            collisionCode = 2;
		}
		else if(this.intersects(this.tilePanel.playerLabel, this.tilePanel.town))
		{
            collisionCode = 3;
		}
		else if(this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.muleStoreLabel))
		{
            collisionCode = 4;
		}
		else if(this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.energyStoreLabel))
		{
            collisionCode = 5;
		}
		else if(this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.foodStoreLabel))
		{
            collisionCode = 6;
		}
		else if(this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.smithoreStoreLabel))
		{
            collisionCode = 7;
		}
		else if(this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.crystiteStoreLabel))
		{
            collisionCode = 8;
		}
		else if(this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.landStoreLabel))
		{
            collisionCode = 9;
		}
		else if(this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.assayOfficeLabel))
		{
            collisionCode = 10;
		}
		else
		{
            collisionCode = 11;
		}

		return collisionCode;
	}
	
	public void resetPlayerPos()
	{
		this.tilePanel.defaultPlayerPos();
		this.townCenterPanel.defaultPlayerPos();	
	}
	
	/**
	 * METHOD that checks two Labels to see if they intersect
	 * @param labelA
	 * @param labelB
	 * @return true or false depending on if they intersect
	 */
	public boolean intersects(JLabel labelA, JLabel labelB){
	    Area areaA = new Area(labelA.getBounds());
	    Area areaB = new Area(labelB.getBounds());

	    return areaA.intersects(areaB.getBounds2D()) && labelA.isShowing() && labelB.isShowing();
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
	protected void showTilePanel() {
        System.out.println("SHOW TILE PANEL");
        cardLayout.show(this, TILES);
		this.inTownCenter = false;
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
	protected void showTownCenterPanel() {
		System.out.println("SHOW TOWN CENTER PANEL");
		cardLayout.show(this, TOWN_CENTER);
		this.inTownCenter = true;
	}
	
	/**
	 * METHOD that gets this BoardPanel's TownCenterPanel
	 * @return this BoardPanel's TownCenterPanel
	 */
	public MarketPanel getMarketPanel() {
		return this.marketPanel;
	}

	/**
	 * METHOD that tells this BoardPanel to display the TownCenterPanel
	 */
	protected void showMarketPanel() {
		System.out.println("SHOW MARKET PANEL");
		cardLayout.show(this, MARKET);
		this.inTownCenter = false;
	}
	
	public EndGamePanel getEndGamePanel() {
		return this.endGamePanel;
	}

	/**
	 * METHOD that tells this BoardPanel to display the TownCenterPanel
	 */
	protected void showEndGamePanel() {
		System.out.println("SHOW END GAME PANEL");
		cardLayout.show(this, ENDGAME);
		this.inTownCenter = false;
	}
	
	public boolean isInTownCenter()
	{
		return this.inTownCenter;
	}
	
}
