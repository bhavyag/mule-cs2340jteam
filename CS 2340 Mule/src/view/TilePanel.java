package view;

import javax.swing.*;

public class TilePanel extends JPanel {
    private JLabel tilePanel;

    protected TilePanel() {
        this.tilePanel = new JLabel("");

        initialize();
    }

    private void initialize() {
        this.setLayout(null);
        this.add(tilePanel);

        tilePanel.setBounds(0, 0, 1000, 563);
        tilePanel.setIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/mule-board.png")));
    }
}
