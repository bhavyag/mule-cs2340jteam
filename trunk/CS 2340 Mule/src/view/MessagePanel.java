package view;

import javax.swing.*;
import java.awt.Rectangle;

/**
 * CLASS MessagePanel. For the JPanel that holds the message center,
 *  where messages to the players are written
 * @author Chris
 *
 */
public class MessagePanel extends JPanel {

	/**
	 * CONSTRUCTOR for the MessagePanel, sets its initial size.
	 */
    protected MessagePanel() {
    	setBounds(new Rectangle(0, 0, 168, 563));

        initialize();
    }

    /**
     * METHOD that sets the initial state of the MessagePanel, creates its JLabel, etc.
     */
    private void initialize() {
        this.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(MessagePanel.class.getResource("/sprites/Message-Panel.png")));
        lblNewLabel.setBounds(0, 0, 168, 563);
        add(lblNewLabel);
    }
    
    /**
     * METHOD that updates what is being displayed on the MessagePanel
     */
    public void updateMessagePanel()
    {
    	
    }
}
