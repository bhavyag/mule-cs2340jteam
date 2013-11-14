package view.game;

import view.title.TitleFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.net.URL;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * CLASS GameFrame. Defines the frame that holds what is displayed for the game, including 3 JPanels:
 * the BoardPanel, the StatusPanel, and the MessagePanel
 * @author Chris
 *
 */
public class GameFrame extends JFrame {
    private BoardPanel boardPanel;
    private StatusPanel statusPanel;
    private MessagePanel messagePanel;

    /**
     * CONSTRUCTOR for the GameFrame, instantiates it's board panel, its status panel, and its message panel
     */
    public GameFrame(int numPlayers) {
    	
        this.boardPanel = new BoardPanel();
        
        this.statusPanel = new StatusPanel(numPlayers);
        statusPanel.setBounds(168, 400, 832, 163);
        
        this.messagePanel = new MessagePanel();
        messagePanel.setBounds(0, 0, 168, 563);


        initialize();
    }

    /**
     * METHOD that sets the initial settings for the GameFrame, its size etc.
     */
    private void initialize() {
        this.setVisible(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(TitleFrame.class.getResource("/sprites/muleIcon.png")));
        this.setResizable(false);
        this.setBounds(100, 100, 1006, 592);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(boardPanel);
        getContentPane().add(messagePanel);
        getContentPane().add(statusPanel);

        boardPanel.getTownCenterPanel().setLocation(new Point(168, 0));
        boardPanel.getTilePanel().setLocation(new Point(168, 0));
        boardPanel.setLocation(new Point(168, 0));
        boardPanel.getTownCenterPanel().setBounds(new Rectangle(168, 0, 832, 400));
        boardPanel.getTilePanel().setBounds(new Rectangle(168, 0, 832, 400));
        boardPanel.setBounds(new Rectangle(168, 0, 832, 400));
        //statusPanel.setMaximumSize(new Dimension(832, 163));
        
        this.setFocusable(true);
    }
    
    public void onKeyMove(KeyListener keyListener)
    {
//    	if (boardPanel.getTownCenterPanel().getKeyListeners().length > 0) 
//    	{
//            boardPanel.getTownCenterPanel().removeKeyListener(boardPanel.getTownCenterPanel().getKeyListeners()[0]);
//      }
    	this.addKeyListener(keyListener);
    }
    

    /**
     * METHOD gets the index of a tile based on a mouse location
     * @param cartesian the mouse location
     * @return the index of the clicked tile in the tile array
     */
    public Point getTileIndex(Point cartesian) {
        return boardPanel.getTilePanel().getTileIndex(cartesian);
    }

    /**
     * METHOD adds functionality to clicking tile panel
     *
     * @param mouseAdapter the adapter containing the functionality
     */
    public void onTileClick(MouseAdapter mouseAdapter) {
        if (boardPanel.getTilePanel().getMouseListeners().length > 0) {
            boardPanel.getTilePanel().removeMouseListener(boardPanel.getTilePanel().getMouseListeners()[0]);
        }
        boardPanel.getTilePanel().addMouseListener(mouseAdapter);
    }

    /**
     * METHOD updates the image of the tile's border
     * @param imagePath the path to the image
     * @param x the x coordinate of the tile
     * @param y the y coordinate of the tile
     */
    public void updateTileBorder(URL imagePath, int x, int y) {
        boardPanel.getTilePanel().setBorderImage(imagePath, x, y);
    }

    /**
     * METHOD updates the image of the tile's image
     * @param imagePath the path to the image
     * @param x the x coordinate of the tile
     * @param y the y coordinate of the tile
     */
    public void updateTileImage(URL imagePath, int x, int y) {
        boardPanel.getTilePanel().setTileImage(imagePath, x, y);
    }

    /**
     * METHOD to show Town Center Panel
     */
    public void showTownCenterPanel() {
        boardPanel.showTownCenterPanel();
    }

    /**
     * METHOD to show Tile Panel
     */
    public void showTilePanel() {
        boardPanel.showTilePanel();
    }
    
    /**
     * METHOD to show market panel
     */
    public void showMarketPanel() {
        boardPanel.showMarketPanel();
    }

    /**
     * METHOD to update the timer based on a new time value
     * @param time the amount of time left on the timer
     */
    public void updateTimer(int time) {
        messagePanel.updateTimer(time);
    }

    /**
     * METHOD to update the player based on the new player number
     * @param player the player's number as assigned in configuration
     */
    public void updatePlayer(int player) {
        messagePanel.updatePlayer(player);
    }
    
    /**
     * METHOD to get the StatusPanel object
     * @return the current StatusPanel object
     */
    public StatusPanel getStatusPanel()
    {
    	return this.statusPanel;
    }
    
    public BoardPanel getBoardPanel()
    {
    	return this.boardPanel;
    }
    
    public MarketPanel getMarketPanel()
    {
    	return this.boardPanel.marketPanel;
    }
}
