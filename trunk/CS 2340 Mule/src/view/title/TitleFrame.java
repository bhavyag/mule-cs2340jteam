package view.title;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Toolkit;

/**
 * CLASS TitleFrame. For the JFrame that will display the title screen as well as the configuration screens.
 * @author Chris
 *
 */
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

	/**
	 * METHOD to get this TitleFrame's TitlePanel
	 * @return this TitleFrame's TitlePanel
	 */
    public TitlePanel getTitlePanel() {
        return titlePanel;
    }

    /**
     * METHOD to tell the TitleFrame to display the TitlePanel
     */
    public void showTitlePanel() {
        cardLayout.show(this.getContentPane(), TITLE);
    }

    /**
     * METHOD to get the TitleFrame's GameConfigPanel
     * @return this TitleFrame's GameConfigPanel
     */
    public GameConfigPanel getGameConfigPanel() {
        return gameConfigPanel;
    }

    /**
     * METHOD to tell the TitleFrame to display the GameConfigPanel
     */
    public void showGameConfigPanel() {
        cardLayout.show(this.getContentPane(), GAME_CONFIG);
    }

    /**
     * METHOD to get the TitleFrame's PlayerConfigPanel
     * @return this TitleFrame's PlayerConfigPanel
     */
    public PlayerConfigPanel getPlayerConfigPanel() {
        return playerConfigPanel;
    }

    /**
     * METHOD to tell the TitleFrame to display the PlayerConfigPanel
     */
    public void showPlayerConfigPanel() {
        cardLayout.show(this.getContentPane(), PLAYER_CONFIG);
    }

    /**
     * METHOD to create another player config panel for another player
     * @param playerNum the number of the player to be configured
     */
    public void updatePlayerConfigPanel(int playerNum) {
        playerConfigPanel.clear();
        playerConfigPanel.setPlayerNum(playerNum);
    }
}
