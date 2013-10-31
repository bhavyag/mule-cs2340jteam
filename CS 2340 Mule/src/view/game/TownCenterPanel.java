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

        initialize();
    }

    /**
     * METHOD to set which player to display in the town center.
     * @param imagePath the image of the player
     */
    protected void setPlayerImage(URL imagePath)
    {
    	playerLabel.setIcon(new ImageIcon(imagePath));
    }
    
    /**
     * METHOD to set the player's position on the screen.
     * @param p the player's new position
     */
    protected void setPlayerCoords(Point p)
    {
    	int x = (int) p.getX();
    	int y = (int) p.getY();
    	playerLabel.setBounds(x,y,40,40);
    }
    
    /**
     * METHOD to set the initial state of the town center.
     */
    private void initialize() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.add(townCenterPanel);
        this.setBounds(168, 0, 832, 400);
        townCenterPanel.setIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/town-center.png")));
    }
}
