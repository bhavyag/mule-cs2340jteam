package view;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private BoardPanel boardPanel;

    final String BOARD = "Board";

    public GameFrame() {
        this.boardPanel = new BoardPanel();
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
        getContentPane().setLayout(new CardLayout(0, 0));
        getContentPane().add(boardPanel, "name_791672127307887");
    }

    public void showBoardPanel() {
    }
}
