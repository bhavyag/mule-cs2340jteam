package view;

import javax.swing.*;

/**
 * CLASS TownCenterPanel. Displays the Town Center
 * @author Chris
 *
 */
public class TownCenterPanel extends JPanel {
    private JLabel townCenterPanel;

    /**
     * CONSTRUCTOR for the Town Center, instantiates the town centers label.
     */
    protected TownCenterPanel() {
        this.townCenterPanel = new JLabel("");

        initialize();
    }

    /**
     * METHOD to set the initial state of the town center.
     */
    private void initialize() {
        this.setLayout(null);
        this.add(townCenterPanel);

        townCenterPanel.setBounds(168, 0, 832, 400);
        townCenterPanel.setIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/mule-board.png")));
    }
}
