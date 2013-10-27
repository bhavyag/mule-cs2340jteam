package view.game;

import javax.swing.*;
import java.awt.Rectangle;

/**
 * CLASS MessagePanel. For the JPanel that holds the message center,
 *  where messages to the players are written
 * @author Chris
 *
 */
public class MessagePanel extends JPanel {

    private JLabel messagePanelLabel;
    private JLabel timerLabel;
    private JLabel playerLabel;

	/**
	 * CONSTRUCTOR for the MessagePanel, sets its initial size.
	 */
    protected MessagePanel() {
        messagePanelLabel = new JLabel("");
        timerLabel = new JLabel("");
        playerLabel = new JLabel("");

        initialize();
    }

    /**
     * METHOD that sets the initial state of the MessagePanel, creates its JLabel, etc.
     */
    private void initialize() {
        this.setLayout(null);
        this.setBounds(new Rectangle(0, 0, 168, 563));
        this.add(messagePanelLabel);
        this.add(timerLabel);
        this.add(playerLabel);

        messagePanelLabel.setIcon(new ImageIcon(MessagePanel.class.getResource("/sprites/Message-Panel.png")));
        messagePanelLabel.setBounds(0, 0, 168, 563);
        playerLabel.setBounds(20, 20, 168, 50);
        timerLabel.setBounds(20, 40, 168, 50);
    }

    public void updateTimer(int time) {
        timerLabel.setText("Time Remaining: " + time);
    }


    public void updatePlayer(int player) {
        playerLabel.setText("Player " + player + "'s Turn");
    }
}
