import view.GameConfigPanel;
import view.MainView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameController {
    private MainView view;
    private int difficulty;
    private ArrayList<Player> players;
    private int currentPlayer;

    public GameController(MainView view) {
        this.view = view;
        this.players = new ArrayList<Player>();
        this.currentPlayer = 0;
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
                }
            }
        );
    }

    private void configurePlayers() {
        for (Player player : players) {

        }
    }

    private static void startGame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GUIGameBoard guiGameBoard = new GUIGameBoard();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        GameController gc = new GameController(new MainView());
        gc.titleScreen();
    }
}
