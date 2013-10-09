package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class TitlePanel extends JPanel {
    private JLabel titleLabel;
    private JButton btnStart;

    protected TitlePanel() {
        titleLabel = new JLabel("");
        btnStart = new JButton("");

        initialize();
    }

    private void initialize() {
        this.setLayout(null);
        this.add(btnStart);
        this.add(titleLabel);

        titleLabel.setBounds(0, 0, 1000, 563);
        titleLabel.setIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/mule-title-1000x563.png")));

        btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnStart.setSelectedIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/start-button-selected.png")));
        btnStart.setRolloverSelectedIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/start-button-selected.png")));
        btnStart.setRolloverIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/start-button-selected.png")));
        btnStart.setBounds(375, 343, 250, 80);
        btnStart.setForeground(Color.WHITE);
        btnStart.setIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/start-button.png")));
        btnStart.setPressedIcon(new ImageIcon(TitlePanel.class.getResource("/sprites/start-button-selected.png")));
        btnStart.setOpaque(false);
        btnStart.setContentAreaFilled(false);
        btnStart.setBorderPainted(false);
        btnStart.setFocusPainted(false);
    }

    public void onClickStart(MouseAdapter mouseAdapter) {
        btnStart.addMouseListener(mouseAdapter);
    }
}
