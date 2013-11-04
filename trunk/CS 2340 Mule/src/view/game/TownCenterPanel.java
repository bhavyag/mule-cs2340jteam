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

    /**
     * CONSTRUCTOR for the Town Center, instantiates the town centers label.
     */
    protected TownCenterPanel() {
        this.townCenterPanel = new JLabel("");
        townCenterPanel.setBounds(5, 5, 832, 400);

        initialize();
    }
    
    protected void defaultPlayerPos()
    {
    	playerLabel.setIcon(null); 
        playerLabel.setBounds(390, 184, 58, 43);
    }
    
	/**
	 * METHOD that draws the player at a certain x/y with a certain sprite
	 * @param x
	 * @param y
	 * @param imagePath
	 */
    public void drawPlayer(int x, int y, URL imagePath)
	{
		this.playerLabel.setIcon(new ImageIcon(imagePath));
    	this.playerLabel.setBounds(x,y,50,50);
	}
    
    /**
     * METHOD to set the initial state of the town center.
     */
    private void initialize() 
    {
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
        townCenterPanel.setIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/town-center.png")));
       
    }
    
    public JLabel getPlayerLabel()
    {
    	return this.playerLabel;
    }
    
    public JLabel getPubLabel()
    {
    	return this.pubLabel;
    }
}
