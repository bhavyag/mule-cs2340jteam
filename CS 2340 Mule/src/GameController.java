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

                        if ()
							System.out.println("x: " + e.getPoint().x + " y: " + e.getPoint().y);
							System.out.println("Row: " + row + "  Col: " + col);
							board.getMap()[row][col].setOwner(players.getCurrentPlayer());
							switch (players.getCurrentPlayer().getColor().toString())
							{
							case "red":
								board.getMap()[row][col].setTileColor(Tile.TileColor.RED);
								break;
							case "yellow":
								board.getMap()[row][col].setTileColor(Tile.TileColor.YELLOW);
								break;
							case "green":
								board.getMap()[row][col].setTileColor(Tile.TileColor.GREEN);
								break;
							case "purple":
								board.getMap()[row][col].setTileColor(Tile.TileColor.PURPLE);
								break;
							}						

							makeMap();
						}
					}
				}
				);

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

	private void makeMap()
	{
		Tile[][] tiles = board.getMap();

		for(int i = 0; i<5; i++)
		{
			for(int j = 0; j<9; j++)
			{
				Tile tile1 = tiles[i][j];

				URL url = tile1.getType().getImgPath();
				ImageIcon icon = new ImageIcon(url);
				this.tilePanel.instantiateTileImage(icon, i, j);


			}
		}

		for(int i = 0; i<5; i++)
		{
			for(int j = 0; j<9; j++)
			{
				Tile tile2 = tiles[i][j];

				URL url2 = tile2.getTileColor().getBorderPath();
				ImageIcon borderIcon = new ImageIcon(url2);
				this.tilePanel.instantiateBorderImage(borderIcon,i,j);	

			}
		}
	}

	private void update()
	{
		this.statusPanel.updateStatusPanel(players.getPlayers());
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GameController gc = new GameController();
		gc.startTitleSequence();
	}
}
