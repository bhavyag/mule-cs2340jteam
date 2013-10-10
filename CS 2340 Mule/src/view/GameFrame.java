package view;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private BoardPanel boardPanel;

    private CardLayout cardLayout;

    final String BOARD = "Board";

    public GameFrame() {
        this.boardPanel = new BoardPanel();

        this.cardLayout = new CardLayout();

        initialize();
    }

    private void initialize() {
        this.setVisible(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(TitleFrame.class.getResource("/sprites/muleIcon.png")));
        this.setResizable(false);
        this.setBounds(100, 100, 1006, 592);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(cardLayout);
        this.add(boardPanel, BOARD);
    }

    public void showBoardPanel() {
        cardLayout.show(this.getContentPane(), BOARD);
    }
}
