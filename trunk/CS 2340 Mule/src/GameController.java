import model.Board;
import model.BoardFactory;
import model.Player;
import model.PlayerQueue;
import view.GameConfigPanel;
import view.GameFrame;
import view.TitleFrame;
import view.PlayerConfigPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameController {
    private TitleFrame titleView;
    private GameFrame gameView;
    private int difficulty;
    private PlayerQueue players;
    private Board board;


    public GameController() {}

    private void startTitleSequence() {
        titleView = new TitleFrame();
        titleScreen();
    }


    private void titleScreen() {
        titleView.showTitlePanel();

        titleView.getTitlePanel().onClickStart(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        configureGame();
                    }
                }
        );
    }

    private void configureGame() {
        titleView.showGameConfigPanel();

        final GameConfigPanel gameConfigPanel = titleView.getGameConfigPanel();
        gameConfigPanel.onClickNext(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        players = new PlayerQueue(gameConfigPanel.getNumPlayers());
                        difficulty = gameConfigPanel.getDifficulty();
                        board = BoardFactory.constructBoard(gameConfigPanel.getMap());

                        configurePlayers();
                    }
                }
        );
    }

    private void configurePlayers() {
        titleView.showPlayerConfigPanel();
        titleView.updatePlayerConfigPanel(players.getCurrentPlayer().getPlayerNum());

        final PlayerConfigPanel playerConfigPanel = titleView.getPlayerConfigPanel();
        playerConfigPanel.onClickNext(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Player currentPlayer = players.getCurrentPlayer();
                        currentPlayer.setName(playerConfigPanel.getName());
                        currentPlayer.setColor(playerConfigPanel.getColor());
                        currentPlayer.setRace(playerConfigPanel.getRace());

                        players.next();

                        if (players.isNewRound()) {
                            startGame();
                        } else {
                            titleView.updatePlayerConfigPanel(players.getCurrentPlayer().getPlayerNum());
                        }
                    }
                }
        );
    }

    private void startGame() {
        titleView.dispose();
        gameView = new GameFrame();
        gameView.showBoardPanel();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        GameController gc = new GameController();
        gc.startTitleSequence();
    }
}
