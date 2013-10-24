package view;

import javax.swing.*;

import java.awt.Rectangle;
import java.util.ArrayList;

public class StatusPanel extends JPanel {

    protected StatusPanel() {
    	setBounds(new Rectangle(168, 400, 832, 163));

        initialize();
    }

    private void initialize() {
        this.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/Status-Panel.png")));
        lblNewLabel.setBounds(168, 400, 832, 163);
        add(lblNewLabel);
    }
    
    public void updateStatusPanel(ArrayList<model.Player> players)
    {
    	
    }
}
