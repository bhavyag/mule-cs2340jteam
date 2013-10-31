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
	private CardLayout cardLayout;
    protected JLabel playerLabel;
    protected boolean inTownCenter;

	private final String
	TILES = "Tiles",
	TOWN_CENTER = "Town Center";

	/**
	 * CONSTRUCTOR for the BoardPanel, also creates it's 'sub' JPanels, the tilePanel and the townCenterPanel.
	 */
	protected BoardPanel() {
		this.tilePanel = new TilePanel();
		this.townCenterPanel = new TownCenterPanel();
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
	}
	
	public boolean checkCollisionPub()
	{
		return this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.pubLabel);
	}
	
	public boolean checkCollisionWestExit()
	{
		return this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.westExitLabel); 
	}
	
	public boolean checkCollisionEastExit()
	{
		return this.intersects(this.townCenterPanel.playerLabel, this.townCenterPanel.eastExitLabel); 
	}
	
	public boolean checkCollisionTown()
	{
		return this.intersects(this.tilePanel.playerLabel, this.tilePanel.town); 
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

	    return areaA.intersects(areaB.getBounds2D());
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
	
	public boolean isInTownCenter()
	{
		return this.inTownCenter;
	}
}
