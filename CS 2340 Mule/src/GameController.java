import model.Board;
import model.BoardFactory;
import model.PlayerQueue;
import util.LimitTimer;
import view.GameConfigPanel;
import view.GameFrame;
import view.TitleFrame;
import view.PlayerConfigPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameController {
    private TitleFrame titleView;
    private GameFrame gameView;
    private int difficulty;
    private PlayerQueue players;
    private Board board;
    private LimitTimer timer;


    public GameController() {

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
                        players.getCurrentPlayer().setName(playerConfigPanel.getName());
                        players.getCurrentPlayer().setColor(playerConfigPanel.getColor());
                        players.getCurrentPlayer().setRace(playerConfigPanel.getRace());

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
//        titleView.dispose();
//        gameView = new GameFrame();
//        gameView.showBoardPanel();

        timer = new LimitTimer(10, 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("tick " + timer.getCount() + ": " + players.getCurrentPlayer());

                if (timer.isOutOfTime()) {
                    System.out.println("out of time");
                    players.next();
                    timer.reset();
                }
            }
        });

        timer.start();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        GameController gc = new GameController();
        gc.startTitleSequence();
    }
}
