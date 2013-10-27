package view.game;

import javax.swing.*;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Font;

/**
 * CLASS StatusPanel. For the JPanel that displays the status of each player,
 * their name, money, and resources.
 * @author Chris
 *
 */
public class StatusPanel extends JPanel {

	/**
	 * CONSTRUCTOR for the StatusPanel, sets its initial size.
	 */
    protected StatusPanel() {
    	setBounds(new Rectangle(168, 400, 832, 163));

        initialize();
    }

    /**
     * METHOD that adds the StatusPanel's JLabels for each player's information
     */
    private void initialize() {
        setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(new Rectangle(11, 10, 195, 143));
        add(lblNewLabel);
        
        JLabel label_4 = new JLabel("New label");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_4.setBounds(0, 0, 60, 14);
        lblNewLabel.add(label_4);
        
        JLabel label_5 = new JLabel("New label");
        label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_5.setBounds(0, 0, 60, 14);
        lblNewLabel.add(label_5);
        
        JLabel label_1 = new JLabel("");
        label_1.setBounds(new Rectangle(11, 10, 195, 143));
        label_1.setBounds(216, 10, 195, 143);
        add(label_1);
        
        JLabel label_2 = new JLabel("");
        label_2.setBounds(new Rectangle(11, 10, 195, 143));
        label_2.setBounds(421, 10, 195, 143);
        add(label_2);
        
        JLabel label_3 = new JLabel("");
        label_3.setBounds(new Rectangle(11, 10, 195, 143));
        label_3.setBounds(626, 10, 195, 143);
        add(label_3);
        
        JLabel label = new JLabel("");
        label.setBounds(new Rectangle(0, 0, 195, 143));
        label.setBounds(0, 0, 832, 163);
        label.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/Status-Panel.png")));
        add(label);
    }
}
