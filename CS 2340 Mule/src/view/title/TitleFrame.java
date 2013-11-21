package view.title;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;

/**
 * CLASS TitleFrame. For the JFrame that will display the title screen as well
 * as the configuration screens.
 * 
 * @author Chris
 * 
 */
public class TitleFrame extends JFrame {

	private TitlePanel titlePanel;
	private GameConfigPanel gameConfigPanel;
	private PlayerConfigPanel playerConfigPanel;

	private CardLayout cardLayout;

	private final String TITLE = "Title", GAME_CONFIG = "Game Config",
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
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				TitleFrame.class.getResource("/sprites/muleIcon.png")));
		this.setResizable(false);
		this.setBounds(100, 100, 1006, 592);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(cardLayout);
		this.getContentPane().add(titlePanel, TITLE);
		this.getContentPane().add(gameConfigPanel, GAME_CONFIG);
		this.getContentPane().add(playerConfigPanel, PLAYER_CONFIG);
	}

	/**
	 * METHOD to tell the TitleFrame to display the TitlePanel
	 */
	public void showTitlePanel() {
		cardLayout.show(this.getContentPane(), TITLE);
	}

	/**
	 * METHOD to tell the TitleFrame to display the GameConfigPanel
	 */
	public void showGameConfigPanel() {
		cardLayout.show(this.getContentPane(), GAME_CONFIG);
	}

	/**
	 * METHOD to tell the TitleFrame to display the PlayerConfigPanel
	 */
	public void showPlayerConfigPanel() {
		cardLayout.show(this.getContentPane(), PLAYER_CONFIG);
	}

	/**
	 * METHOD to create another player config panel for another player
	 * 
	 * @param playerNum
	 *            the number of the player to be configured
	 */
	public void configurePlayer(int playerNum) {
		playerConfigPanel.clear();
		playerConfigPanel.setPlayerNum(playerNum);
	}

	/**
	 * METHOD that adds a mouse listener to the TitlePanel
	 * 
	 * @param mouseAdapter
	 *            the mouse listener to add
	 */
	public void onClickStart(MouseAdapter mouseAdapter) {
		titlePanel.onClickStart(mouseAdapter);
	}

	/**
	 * METHOD that gets the number of players selected based on the button that
	 * is pressed.
	 * 
	 * @return the number of players selected.
	 */
	public int getGameConfigNumPlayers() {
		return gameConfigPanel.getNumPlayers();
	}

	/**
	 * METHOD that gets the map that is selected based on the button that is
	 * pressed.
	 * 
	 * @return a number representing the map that is selected.
	 */
	public int getGameConfigMap() {
		return gameConfigPanel.getMap();
	}

	/**
	 * METHOD that gets the difficulty selected for this game based on the
	 * button that is pressed.
	 * 
	 * @return an number representing the difficulty selected.
	 */
	public int getGameConfigDifficulty() {
		return gameConfigPanel.getDifficulty();
	}

	/**
	 * METHOD that adds a mouse listener to the GameConfigPanel
	 * 
	 * @param mouseAdapter
	 *            the mouse adapter to add.
	 */
	public void onGameConfigNext(MouseAdapter mouseAdapter) {
		gameConfigPanel.onClickNext(mouseAdapter);
	}

	/**
	 * METHOD that sets the image on the screen based on the player that needs
	 * to be configured.
	 * 
	 * @param playerNum
	 */
	public void setPlayerConfigNum(int playerNum) {
		playerConfigPanel.setPlayerNum(playerNum);
	}

	/**
	 * METHOD that gets the name of this player which was input into the
	 * PlayerConfig's text field
	 */
	public String getPlayerConfigName() {
		return playerConfigPanel.getPlayerName();
	}

	/**
	 * METHOD that gets the color that was selected for the player.
	 * 
	 * @return the color that was selected for the player.
	 */
	public int getPlayerConfigColor() {
		return playerConfigPanel.getColor();
	}

	/**
	 * METHOD that gets the race that was selected for the player.
	 * 
	 * @return the race that was selected for the player.
	 */
	public int getPlayerConfigRace() {
		return playerConfigPanel.getRace();
	}

	/**
	 * METHOD that clears the previous input on the screen
	 */
	public void clearPlayerConfig() {
		playerConfigPanel.clear();
	}

	/**
	 * METHOD that adds a mouse adapter to the PlayerConfigPanel
	 * 
	 * @param mouseAdapter
	 *            the mouse listener to add to this panel
	 */
	public void onPlayerConfigNext(MouseAdapter mouseAdapter) {
		playerConfigPanel.onClickNext(mouseAdapter);
	}
}
