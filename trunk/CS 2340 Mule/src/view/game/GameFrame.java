package view.game;

import view.title.TitleFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.net.URL;

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
     * CONSTRUCTOR for te GameFrame, instantiates it's board panel, its status panel, and its message panel
     */
    public GameFrame() {
        this.boardPanel = new BoardPanel();
        this.statusPanel = new StatusPanel();
        this.messagePanel = new MessagePanel();

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
        getContentPane().setLayout(new BorderLayout(0, 0));
        getContentPane().add(boardPanel);
        getContentPane().add(messagePanel);
        getContentPane().add(statusPanel);

        boardPanel.getTownCenterPanel().setLocation(new Point(168, 0));
        boardPanel.getTilePanel().setLocation(new Point(168, 0));
        boardPanel.setLocation(new Point(168, 0));
        boardPanel.getTownCenterPanel().setBounds(new Rectangle(168, 0, 832, 400));
        boardPanel.getTilePanel().setBounds(new Rectangle(168, 0, 832, 400));
        boardPanel.setBounds(new Rectangle(168, 0, 832, 400));
        statusPanel.setMaximumSize(new Dimension(832, 163));
    }
    
    /**
     * METHOD that gets the game frame's board panel
     * @return the game frame's board panel
     */
    public BoardPanel getBoardPanel()
    {
    	return this.boardPanel;
    }
    
    /**
     * Method that gets the game frame's message panel
     * @return the game frame's message panel
     */
	public MessagePanel getMessagePanel()
	{
		return this.messagePanel;
	}
	
	/**
	 * Method that gets the game frame's status panel
	 * @return the game frame's status panel
	 */
	public StatusPanel getStatusPanel()
	{
		return this.statusPanel;
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
}
