package view;

import javax.swing.*;

public class GameBoardPanel extends JPanel {
    private JLabel boardLabel;

    protected GameBoardPanel() {
        this.boardLabel = new JLabel("");

        initialize();
    }

    private void initialize() {
        this.setLayout(null);
        this.add(boardLabel);

        boardLabel.setBounds(0, 0, 1000, 563);
        boardLabel.setIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/mule-board.png")));
    }
}
