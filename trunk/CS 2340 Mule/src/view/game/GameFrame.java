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
        statusPanel.setMaximumSize(new Dimension(832, 163));
        this.messagePanel = new MessagePanel();
        //messagePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        boardPanel.getTownCenterPanel().setLocation(new Point(168, 0));
        boardPanel.getTilePanel().setLocation(new Point(168, 0));
        boardPanel.setLocation(new Point(168, 0));
        boardPanel.getTownCenterPanel().setBounds(new Rectangle(168, 0, 832, 400));
        boardPanel.getTilePanel().setBounds(new Rectangle(168, 0, 832, 400));
        boardPanel.setBounds(new Rectangle(168, 0, 832, 400));

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

    public Point getTileIndex(Point cartesian) {
        return boardPanel.getTilePanel().getTileIndex(cartesian);
    }

    public void onTileClick(MouseAdapter mouseAdapter) {
        boardPanel.getTilePanel().addMouseListener(mouseAdapter);
    }

    public void updateTileBorder(URL imagePath, int x, int y) {
        boardPanel.getTilePanel().setBorderImage(
                new ImageIcon(imagePath), x, y
        );
    }

    public void updateTileImage(URL imagePath, int x, int y) {
        boardPanel.getTilePanel().setTileImage(
                new ImageIcon(imagePath), x, y
        );
    }
}
