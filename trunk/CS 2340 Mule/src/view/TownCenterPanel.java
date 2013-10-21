package view;

import javax.swing.*;

public class TownCenterPanel extends JPanel {
    private JLabel townCenterPanel;

    protected TownCenterPanel() {
        this.townCenterPanel = new JLabel("");

        initialize();
    }

    private void initialize() {
        this.setLayout(null);
        this.add(townCenterPanel);

        townCenterPanel.setBounds(0, 0, 1000, 563);
        townCenterPanel.setIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/mule-board.png")));
    }
}
