package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * CLASS GameConfigPanel. For the JPanel that handles game configuration
 * @author Chris
 *
 */
public class GameConfigPanel extends JPanel {
    private ButtonGroup
            mapButtonGroup,
            difficultyButtonGroup,
            playerButtonGroup;

    private JToggleButton
            nextButton,
            map1Button,
            map2Button,
            easyButton,
            mediumButton,
            hardButton,
            p2Button,
            p3Button,
            p4Button;

    private JLabel gameConfigLabel;

    /**
     * CONSTRUCTOR for the GameConfigPanel, instantiates all of its buttons
     */
    protected GameConfigPanel() {
        mapButtonGroup = new ButtonGroup();
        difficultyButtonGroup = new ButtonGroup();
        playerButtonGroup = new ButtonGroup();

        nextButton = new JToggleButton("");
        map1Button = new JToggleButton("");
        map2Button = new JToggleButton("");
        easyButton = new JToggleButton("");
        mediumButton = new JToggleButton("");
        hardButton = new JToggleButton("");
        p2Button = new JToggleButton("");
        p3Button = new JToggleButton("");
        p4Button = new JToggleButton("");

        gameConfigLabel = new JLabel("");

        initialize();
    }

    /**
     * METHOD that adds all of the buttons to the GameConfigPanel and sets their initial values.
     */
    private void initialize() {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setLayout(null);
        this.add(nextButton);
        this.add(map1Button);
        this.add(map2Button);
        this.add(easyButton);
        this.add(mediumButton);
        this.add(hardButton);
        this.add(p2Button);
        this.add(p3Button);
        this.add(p4Button);
        this.add(gameConfigLabel);

        mapButtonGroup.add(map1Button);
        mapButtonGroup.add(map2Button);

        difficultyButtonGroup.add(easyButton);
        difficultyButtonGroup.add(mediumButton);
        difficultyButtonGroup.add(hardButton);

        playerButtonGroup.add(p2Button);
        playerButtonGroup.add(p3Button);
        playerButtonGroup.add(p4Button);

        nextButton.setIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/next-unselect.png")));
        nextButton.setPressedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/next.png")));
        nextButton.setRolloverIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/next.png")));
        nextButton.setRolloverSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/next.png")));
        nextButton.setSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/next.png")));
        nextButton.setFocusPainted(false);
        nextButton.setBorderPainted(false);
        nextButton.setBorder(null);
        nextButton.setBounds(807, 493, 150, 48);

        map1Button.setFocusPainted(false);
        map1Button.setBorderPainted(false);
        map1Button.setBorder(null);
        map1Button.setPressedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/map1.png")));
        map1Button.setRolloverIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/map1.png")));
        map1Button.setSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/map1.png")));
        map1Button.setIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/map1unselect.png")));
        map1Button.setBounds(291, 183, 200, 117);

        map2Button.setFocusPainted(false);
        map2Button.setPressedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/map2.png")));
        map2Button.setRolloverIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/map2.png")));
        map2Button.setSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/map2.png")));
        map2Button.setIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/map2unselect.png")));
        map2Button.setBounds(639, 183, 200, 117);

        easyButton.setFocusPainted(false);
        easyButton.setBorderPainted(false);
        easyButton.setBorder(null);
        easyButton.setSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/easy.png")));
        easyButton.setRolloverIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/easy.png")));
        easyButton.setPressedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/easy.png")));
        easyButton.setIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/easyunselect.png")));
        easyButton.setBounds(336, 341, 150, 48);

        mediumButton.setFocusPainted(false);
        mediumButton.setIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/mediumunselect.png")));
        mediumButton.setPressedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/medium.png")));
        mediumButton.setRolloverIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/medium.png")));
        mediumButton.setRolloverSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/medium.png")));
        mediumButton.setSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/medium.png")));
        mediumButton.setBorderPainted(false);
        mediumButton.setBorder(null);
        mediumButton.setBounds(556, 341, 150, 48);

        hardButton.setIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/hardunselect.png")));
        hardButton.setPressedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/hard.png")));
        hardButton.setRolloverIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/hard.png")));
        hardButton.setRolloverSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/hard.png")));
        hardButton.setSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/hard.png")));
        hardButton.setFocusPainted(false);
        hardButton.setBorderPainted(false);
        hardButton.setBorder(null);
        hardButton.setBounds(780, 341, 150, 48);

        p2Button.setIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/2unselect.png")));
        p2Button.setPressedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/2.png")));
        p2Button.setRolloverIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/2.png")));
        p2Button.setRolloverSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/2.png")));
        p2Button.setSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/2.png")));
        p2Button.setFocusPainted(false);
        p2Button.setBorderPainted(false);
        p2Button.setBorder(null);
        p2Button.setBounds(387, 400, 48, 48);

        p3Button.setIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/3unselect.png")));
        p3Button.setPressedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/3.png")));
        p3Button.setRolloverIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/3.png")));
        p3Button.setRolloverSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/3.png")));
        p3Button.setSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/3.png")));
        p3Button.setFocusPainted(false);
        p3Button.setBorderPainted(false);
        p3Button.setBorder(null);
        p3Button.setBounds(607, 400, 48, 48);

        p4Button.setIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/4unselect.png")));
        p4Button.setPressedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/4.png")));
        p4Button.setRolloverSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/4.png")));
        p4Button.setRolloverIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/4.png")));
        p4Button.setSelectedIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/4.png")));
        p4Button.setFocusPainted(false);
        p4Button.setBorderPainted(false);
        p4Button.setBorder(null);
        p4Button.setBounds(831, 400, 48, 48);

        gameConfigLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        gameConfigLabel.setBounds(0, 0, 1000, 563);
        gameConfigLabel.setIcon(new ImageIcon(GameConfigPanel.class.getResource("/sprites/config/mule-config.png")));
    }

    /**
     * METHOD that gets the number of players selected based on the button that is pressed.
     * @return the number of players selected.
     */
    public int getNumPlayers() {
        if (p2Button.isSelected()) {
            return 2;
        } else if (p3Button.isSelected()) {
            return 3;
        } else if (p4Button.isSelected()) {
            return 4;
        } else {
            return -1;
        }
    }

    /**
     * METHOD that gets the map that is selected based on the button that is pressed.
     * @return a number representing the map that is selected.
     */
    public int getMap() {
        if (map1Button.isSelected()) {
            return 0;
        } else if (map2Button.isSelected()) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * METHOD that gets the difficulty selected for this game based on the button that is pressed.
     * @return an number representing the difficulty selected.
     */
    public int getDifficulty() {
        if (easyButton.isSelected()) {
            return 0;
        } else if (mediumButton.isSelected()) {
            return 1;
        } else if (hardButton.isSelected()) {
            return 2;
        } else {
            return -1;
        }
    }

    /**
     * METHOD that adds a mouse listener to the GameConfigPanel
     * @param mouseAdapter the mouse adapter to add.
     */
    public void onClickNext(MouseAdapter mouseAdapter) {
        nextButton.addMouseListener(mouseAdapter);
    }
}
