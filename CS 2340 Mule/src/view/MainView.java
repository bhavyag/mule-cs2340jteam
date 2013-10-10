package view;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Toolkit;

public class MainView {

	private JFrame frame;
    private TitlePanel titlePanel;
    private GameConfigPanel gameConfigPanel;
    private PlayerConfigPanel playerConfigPanel;
    private GameBoardPanel gameBoardPanel;

	private CardLayout cardLayout;

	private final String
            TITLE = "Title",
            GAME_CONFIG = "Game Config",
            PLAYER_CONFIG = "Player Config",
            GAME_BOARD = "Game model.Board";

	/**
	 * Create the application.
	 */
	public MainView() {
		this.frame = new JFrame();
        this.titlePanel = new TitlePanel();
        this.gameConfigPanel = new GameConfigPanel();
        this.playerConfigPanel = new PlayerConfigPanel();
        this.gameBoardPanel = new GameBoardPanel();
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
        frame.getContentPane().add(gameBoardPanel, GAME_BOARD);
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

    public void showPlayerConfigPanel() {
        cardLayout.show(frame.getContentPane(), PLAYER_CONFIG);
    }

    public void updatePlayerConfigPanel(int playerNum) {
        playerConfigPanel.clear();
        playerConfigPanel.setPlayerNum(playerNum);
    }

    public void showGameBoardPanel() {
        cardLayout.show(frame.getContentPane(), GAME_BOARD);
    }
}
