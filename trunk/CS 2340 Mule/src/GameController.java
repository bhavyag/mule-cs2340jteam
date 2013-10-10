import model.Board;
import model.Player;
import view.GameConfigPanel;
import view.MainView;
import view.PlayerConfigPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameController {
    private MainView view;
    private int difficulty;
    private ArrayList<Player> players;
    private int currentPlayerIdx;
    private Board map;


    public GameController(MainView view) {
        this.view = view;
        this.players = new ArrayList<Player>();
        this.currentPlayerIdx = 0;
    }
    
    private void titleScreen() {
        view.showTitlePanel();

        view.getTitlePanel().onClickStart(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    configureGame();
                }
            }
        );
    }

    private void configureGame() {
        view.showGameConfigPanel();

        final GameConfigPanel gameConfigPanel = view.getGameConfigPanel();
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
        view.showPlayerConfigPanel();
        view.updatePlayerConfigPanel(players.get(currentPlayerIdx).getPlayerNum());

        final PlayerConfigPanel playerConfigPanel = view.getPlayerConfigPanel();
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
            view.updatePlayerConfigPanel(players.get(currentPlayerIdx).getPlayerNum());
        }
    }

    private void startGame() {
        view.showGameBoardPanel();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        GameController gc = new GameController(new MainView());
        gc.titleScreen();
    }
}
