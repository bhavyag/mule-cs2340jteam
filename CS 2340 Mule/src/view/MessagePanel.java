package view;

import javax.swing.*;
import java.awt.Rectangle;

public class MessagePanel extends JPanel {

    protected MessagePanel() {
    	setBounds(new Rectangle(0, 0, 168, 563));

        initialize();
    }

    private void initialize() {
        this.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(MessagePanel.class.getResource("/sprites/Message-Panel.png")));
        lblNewLabel.setBounds(0, 0, 168, 563);
        add(lblNewLabel);
    }
    
    public void updateMessagePanel()
    {
    	
    }
    
    
}
