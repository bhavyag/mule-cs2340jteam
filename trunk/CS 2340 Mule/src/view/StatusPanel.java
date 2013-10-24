package view;

import javax.swing.*;

public class StatusPanel extends JPanel {
    private JLabel statusPanel;

    protected StatusPanel() {
        this.statusPanel = new JLabel("");

        initialize();
    }

    private void initialize() {
        this.setLayout(null);
        this.add(statusPanel);

        statusPanel.setBounds(168, 400, 832, 163);
        statusPanel.setIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/mule-board.png")));
    }
    
    public void updateStatusPanel()
    {
    	
    }
}
