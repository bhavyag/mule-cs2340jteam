package view.game;

import view.title.TitlePanel;

import javax.swing.*;
import java.awt.FlowLayout;

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
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.add(townCenterPanel);
        this.setBounds(168, 0, 832, 400);
        townCenterPanel.setIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/MULE-town-center-PLACEHOLDER.png")));
    }
}
