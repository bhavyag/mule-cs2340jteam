package view;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Toolkit;

public class TitleFrame extends JFrame {

    private TitlePanel titlePanel;
    private GameConfigPanel gameConfigPanel;
    private PlayerConfigPanel playerConfigPanel;

	private CardLayout cardLayout;

	private final String
            TITLE = "Title",
            GAME_CONFIG = "Game Config",
            PLAYER_CONFIG = "Player Config";

	/**
	 * Create the application.
	 */
	public TitleFrame() {
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
		this.setVisible(true);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(TitleFrame.class.getResource("/sprites/muleIcon.png")));
		this.setResizable(false);
		this.setBounds(100, 100, 1006, 592);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(cardLayout);
        this.getContentPane().add(titlePanel, TITLE);
        this.getContentPane().add(gameConfigPanel, GAME_CONFIG);
        this.getContentPane().add(playerConfigPanel, PLAYER_CONFIG);
	}

    public TitlePanel getTitlePanel() {
        return titlePanel;
    }

    public void showTitlePanel() {
        cardLayout.show(this.getContentPane(), TITLE);
    }

    public GameConfigPanel getGameConfigPanel() {
        return gameConfigPanel;
    }

    public void showGameConfigPanel() {
        cardLayout.show(this.getContentPane(), GAME_CONFIG);
    }

    public PlayerConfigPanel getPlayerConfigPanel() {
        return playerConfigPanel;
    }

    public void showPlayerConfigPanel() {
        cardLayout.show(this.getContentPane(), PLAYER_CONFIG);
    }

    public void updatePlayerConfigPanel(int playerNum) {
        playerConfigPanel.clear();
        playerConfigPanel.setPlayerNum(playerNum);
    }
}
