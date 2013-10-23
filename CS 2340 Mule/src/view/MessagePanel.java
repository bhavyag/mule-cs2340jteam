package view;

import javax.swing.*;

public class MessagePanel extends JPanel {
    private JLabel messagePanel;

    protected MessagePanel() {
        this.messagePanel = new JLabel("");

        initialize();
    }

    private void initialize() {
        this.setLayout(null);
        this.add(messagePanel);

        messagePanel.setBounds(0, 0, 1000, 563);
        messagePanel.setIcon(new ImageIcon(TitlePanel.class.getResource("")));
    }
}
