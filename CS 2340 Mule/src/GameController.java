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
		titleView.dispose();
		gameView = new GameFrame();

		players.resetRound();
		players.beginRotation();
		this.makeMap();

		gameView.onTileClick(
				new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
                        Point tileIndex = gameView.getTileIndex(e.getPoint());
                        board.setOwner(players.getCurrentPlayer(), tileIndex);
                        gameView.updateTileBorder(board.getTileBorderPath(tileIndex), (int)tileIndex.getX(), (int)tileIndex.getY());

                        players.next();
                        timer.reset();
					}
				}
				);

		timer = new LimitTimer(50, 1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				if (timer.isOutOfTime()) {
					players.next();
					timer.reset();
				}
			}
		});
		timer.start();
	}

	private void makeMap()
	{
		Tile[][] tiles = board.getMap();

		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[0].length; j++)
			{
				gameView.updateTileImage(tiles[i][j].getImagePath(), i, j);
                gameView.updateTileBorder(tiles[i][j].getBorderPath(), i, j);
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GameController gc = new GameController();
		gc.startTitleSequence();
	}
}
