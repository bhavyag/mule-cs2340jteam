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
    private JLabel playerLabel;

    /**
     * CONSTRUCTOR for the Town Center, instantiates the town centers label.
     */
    protected TownCenterPanel() {
        this.townCenterPanel = new JLabel("");
        townCenterPanel.setBounds(5, 5, 832, 400);

        initialize();
    }

    public void drawPlayer(int x, int y, URL imagePath)
	{
		this.playerLabel.setIcon(new ImageIcon(imagePath));
    	this.playerLabel.setBounds(x,y,50,50);
	}
    
    /**
     * METHOD to set the initial state of the town center.
     */
    private void initialize() {
        setLayout(null);
        playerLabel = new JLabel();
        playerLabel.setBounds(390, 184, 58, 43);
        this.add(playerLabel);
        this.add(townCenterPanel);
        this.setBounds(168, 0, 832, 400);
        townCenterPanel.setIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/town-center.png")));
    }
}
