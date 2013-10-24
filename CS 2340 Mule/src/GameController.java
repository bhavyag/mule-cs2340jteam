import model.*;
import util.LimitTimer;
import view.game.GameFrame;
import view.title.GameConfigPanel;
import view.title.PlayerConfigPanel;
import view.title.TitleFrame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * CLASS GAMECONTROLLER controls the flow of the game
 */
public class GameController {
	private TitleFrame titleView;
	private GameFrame gameView;

	private int difficulty;
	private PlayerQueue players;
	private Board board;
	private LimitTimer timer;

    /**
     * METHOD begins the title sequence
     */
	private void startTitleSequence() {
		titleView = new TitleFrame();
		titleScreen();
	}

    /**
     * METHOD displays the title screen
     */
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

    /**
     * METHOD displays the configure game screen
     */
	private void configureGame() {
		titleView.showGameConfigPanel();

		final GameConfigPanel gameConfigPanel = titleView.getGameConfigPanel();
		gameConfigPanel.onClickNext(
				new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
                        difficulty = gameConfigPanel.getDifficulty();
                        board = BoardFactory.constructBoard(gameConfigPanel.getMap());
                        players = new PlayerQueue(gameConfigPanel.getNumPlayers(), 60 / difficulty);

						configurePlayers();
					}
				}
				);
	}

    /**
     * METHOD displays the configure players screen
     */
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

    /**
     * METHOD starts the actual gameplay
     */
	private void startGame() {
		titleView.dispose();
		gameView = new GameFrame();

        landGrant();
	}

    /**
     * METHOD begins the land grant portion of the game
     */
    private void landGrant() {
        players.beginRotation();
        displayMap();

        gameView.onTileClick(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Point tileIndex = gameView.getTileIndex(e.getPoint());

                    if (players.getRound() <= 2) {
                        if (board.setOwner(players.getCurrentPlayer(), tileIndex)) {
                            gameView.updateTileBorder(board.getTileBorderPath(tileIndex), (int) tileIndex.getX(), (int) tileIndex.getY());

                            System.out.println(players.getCurrentPlayer());

                            players.next();
                            timer.reset();
                        }
                    } else {
                        if (board.purchaseTile(players.getCurrentPlayer(), tileIndex)) {
                            gameView.updateTileBorder(board.getTileBorderPath(tileIndex), (int) tileIndex.getX(), (int) tileIndex.getY());

                            System.out.println(players.getCurrentPlayer());

                            players.next();
                            timer.reset();
                        }
                    }

                }
            }
        );

        timer = new LimitTimer(10, 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("tick " + timer.getCount());

                if (timer.isOutOfTime()) {
                    System.out.println("out of time");

                    if (players.pass()) {
                        timer.stop();
                        nextPhase();
                    } else {
                        timer.reset();
                    }

                }
            }
        });
        timer.start();
    }

    /**
     * METHOD displays the map based on the game configuration
     */
	private void displayMap() {
		Tile[][] tiles = board.getMap();

		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				gameView.updateTileImage(tiles[i][j].getImagePath(), i, j);
                gameView.updateTileBorder(tiles[i][j].getBorderPath(), i, j);
			}
		}
	}

    private void nextPhase() {
        System.out.println("Land selection over");
        gameView.dispose();
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GameController gc = new GameController();
		gc.startTitleSequence();
	}
}
