import javax.swing.*;
import java.awt.*;

public class PlayerConfigView {
    private final ButtonGroup raceButtonGroup;
    private JTextField nameTextField;
    private final ButtonGroup color1ButtonGroup;
    private CardLayout cardLayout;

    public PlayerConfigView(String title) {
        this.raceButtonGroup = new ButtonGroup();
        this.nameTextField = new JTextField();
        this.color1ButtonGroup = new ButtonGroup();
        this.cardLayout = new CardLayout();
    }
}
