package view;

import javax.swing.*;
import java.awt.Rectangle;

public class StatusPanel extends JPanel {
    private JLabel statusPanel;

    protected StatusPanel() {
    	setBounds(new Rectangle(168, 400, 832, 163));
        this.statusPanel = new JLabel("");

        initialize();
    }

    private void initialize() {
        this.setLayout(null);
        this.add(statusPanel);

        statusPanel.setBounds(168, 400, 832, 163);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/Status-Panel.png")));
        lblNewLabel.setBounds(0, 0, 832, 163);
        add(lblNewLabel);
    }
    
    public void updateStatusPanel()
    {
    	
    }
}
