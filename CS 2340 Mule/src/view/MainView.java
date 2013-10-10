package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Cursor;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView {

	private JFrame frame;
    private TitlePanel titlePanel;
    private GameConfigPanel gameConfigPanel;
    private PlayerConfigPanel playerConfigPanel;

	private CardLayout cardLayout;

	private final String
            TITLE = "Title",
            GAME_CONFIG = "Game Config",
            PLAYER_CONFIG = "model.Player Config";

	/**
	 * Create the application.
	 */
	public MainView() {
		this.frame = new JFrame();
        this.titlePanel = new TitlePanel();
        this.gameConfigPanel = new GameConfigPanel();
        this.playerConfigPanel = new PlayerConfigPanel();
		this.cardLayout = new CardLayout();

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame.setVisible(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/sprites/muleIcon.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1006, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(cardLayout);
        frame.getContentPane().add(titlePanel, TITLE);
        frame.getContentPane().add(gameConfigPanel, GAME_CONFIG);
        frame.getContentPane().add(playerConfigPanel, PLAYER_CONFIG);
	}

    public TitlePanel getTitlePanel() {
        return titlePanel;
    }

    public void showTitlePanel() {
        cardLayout.show(frame.getContentPane(), TITLE);
    }

    public GameConfigPanel getGameConfigPanel() {
        return gameConfigPanel;
    }

    public void showGameConfigPanel() {
        cardLayout.show(frame.getContentPane(), GAME_CONFIG);
    }

    public PlayerConfigPanel getPlayerConfigPanel() {
        return playerConfigPanel;
    }

    public void showPlayerConfigPanel(int playerNum) {
        playerConfigPanel.setPlayerNum(playerNum);
        cardLayout.show(frame.getContentPane(), PLAYER_CONFIG);
    }
}
