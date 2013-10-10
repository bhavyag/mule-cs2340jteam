import model.Board;
import model.Player;
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
    private ArrayList<Player> players;
    private int currentPlayerIdx;
    private Board map;


    public GameController() {
        this.players = new ArrayList<Player>();
        this.currentPlayerIdx = 0;
    }

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
                        int numPlayers = gameConfigPanel.getNumPlayers();
                        for (int i = 0; i < numPlayers; i++) {
                            players.add(new Player());
                        }
                        difficulty = gameConfigPanel.getDifficulty();
                        map = Board.constructBoard(gameConfigPanel.getMap());

                        System.out.println("difficulty: " + difficulty);
                        System.out.println("number of players: " + numPlayers);
                        System.out.println("map: " + map);

                        configurePlayers();
                    }
                }
        );
    }

    private void configurePlayers() {
        titleView.showPlayerConfigPanel();
        titleView.updatePlayerConfigPanel(players.get(currentPlayerIdx).getPlayerNum());

        final PlayerConfigPanel playerConfigPanel = titleView.getPlayerConfigPanel();
        playerConfigPanel.onClickNext(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Player currentPlayer = players.get(currentPlayerIdx);
                        currentPlayer.setName(playerConfigPanel.getName());
                        currentPlayer.setColor(playerConfigPanel.getColor());
                        currentPlayer.setRace(playerConfigPanel.getRace());

                        System.out.println(currentPlayer);

                        configureNextPlayer();
                    }
                }
        );
    }

    private void configureNextPlayer() {
        currentPlayerIdx ++;

        if (currentPlayerIdx == players.size()) {
            currentPlayerIdx = 0;
            startGame();
        } else {
            titleView.updatePlayerConfigPanel(players.get(currentPlayerIdx).getPlayerNum());
        }
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
