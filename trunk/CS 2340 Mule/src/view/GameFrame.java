package view;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private BoardPanel boardPanel;
    private StatusPanel statusPanel;
    private MessagePanel messagePanel;

    final String BOARD = "Board";

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
    
    public void update()
    {
    	boardPanel.updateBoardPanel();
    	statusPanel.updateStatusPanel();
    	messagePanel.updateMessagePanel();
    }

    public BoardPanel getBoardPanel()
    {
    	return this.boardPanel;
    }
    
	public void showBoardPanel() 
	{
		
	}
}
