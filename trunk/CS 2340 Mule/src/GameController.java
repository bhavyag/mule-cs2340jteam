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
import java.util.ArrayList;

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

		titleView.onClickStart(
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

		titleView.onGameConfigNext(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        difficulty = titleView.getGameConfigDifficulty();
                        board = BoardFactory.constructBoard(titleView.getGameConfigMap());
                        players = new PlayerQueue(titleView.getGameConfigNumPlayers(), 60 / difficulty);

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
		titleView.configurePlayer(players.getCurrentPlayer().getPlayerNum());

		titleView.onPlayerConfigNext(
				new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						players.getCurrentPlayer().setName(titleView.getPlayerConfigName());
						players.getCurrentPlayer().setColor(titleView.getPlayerConfigColor());
						players.getCurrentPlayer().setRace(titleView.getPlayerConfigRace());

						players.next();

						if (players.isNewRound()) {
							startGame();
						} else {
							titleView.configurePlayer(players.getCurrentPlayer().getPlayerNum());
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
		gameView = new GameFrame(players.getNumPlayers());

        configureTimer();
        landGrant();
	}

    /**
     * METHODS adds a listener to the timer that will be active across all instances of the timer
     */
    private void configureTimer() {
        LimitTimer.setDefaultListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameView.updateTimer(timer.getTimeRemaining());
                gameView.updatePlayer(players.getCurrentPlayer().getPlayerNum());
                updateStatus();//will probably have to move this so it updates REGULARLY
            }
        });
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
    
    /**
     * METHOD begins the land grant portion of the game
     */
    private void landGrant() {
        players.beginRotation();
        gameView.showTilePanel();
        displayMap();

        gameView.onTileClick(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("old");
                    Point tileIndex = gameView.getTileIndex(e.getPoint());

                    if (players.getRound() < 2) {
                        if (board.setOwner(players.getCurrentPlayer(), tileIndex)) {
                            gameView.updateTileBorder(board.getTileBorderPath(tileIndex), (int) tileIndex.getX(), (int) tileIndex.getY());

                            System.out.println(players.getCurrentPlayer());

                            if (players.pass()) {
                                timer.stop();
                                System.out.println("entering townphase");
                                townPhase();
                            }
                            else {
                                timer.reset();
                            }
                        }
                    } else {
                        if (board.purchaseTile(players.getCurrentPlayer(), tileIndex)) {
                            gameView.updateTileBorder(board.getTileBorderPath(tileIndex), (int) tileIndex.getX(), (int) tileIndex.getY());

                            System.out.println(players.getCurrentPlayer());

                            if (players.pass()) {
                                timer.stop();
                                System.out.println("entering townphase");
                                townPhase();
                            }
                            else {
                                timer.reset();
                            }
                        }
                    }

                }
            }
        );

        timer = new LimitTimer(5, 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (timer.isOutOfTime()) {
                    if (players.pass()) {
                        timer.stop();
                        System.out.println("entering townphase");
                        townPhase();
                    } else {
                        timer.reset();
                    }
                }
            }
        });
        timer.start();
    }

    /**
     * METHOD begins the town and map phase of the game
     */
    private void townPhase() {
        System.out.println("starting town phase");
        gameView.showTownCenterPanel();
        players.beginRotation();
        gameView.onTileClick(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                System.out.println("new");
            }
        });

        timer = new LimitTimer(50, 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (timer.isOutOfTime()) {
                    players.next();

                    if (players.isNewRound()) {
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

    private void nextPhase() {
        System.out.println("town phase over");
        gameView.dispose();
    }
    
    public void updateStatus()
    {
    	ArrayList<Player> playerArray = players.getPlayers();
    	System.out.println("Num of players: " + players.getNumPlayers());
    	String[][] playerInfo = new String[4][8];
    	
    	for(int i=0; i < players.getNumPlayers(); i++)
    	{
    		 Player player = playerArray.get(i);
    		 String playerName = player.getPlayerName(),
    				playerColor = player.getColor().toString(),
    				playerRace = player.getRace().toString(),
    				playerMoney = player.getMoney() + "",
    				playerEnergy = player.getEnergy() + "",
    				playerSmithore = player.getSmithore() + "",
    				playerFood = player.getFood() + "",
    				playerCrystite = player.getCrystite() + "";
    		
    				playerInfo[i][0] = playerName;
    				playerInfo[i][1] = playerColor;
    				playerInfo[i][2] = playerRace;
    				playerInfo[i][3] = playerMoney;
    				playerInfo[i][4] = playerEnergy;
    				playerInfo[i][5] = playerSmithore;
    				playerInfo[i][6] = playerFood;
    				playerInfo[i][7] = playerCrystite;
    				
    				/*System.out.println(playerName);
    				System.out.println(playerColor);
    				System.out.println(playerMoney);
    				System.out.println(playerEnergy);
    				System.out.println(playerSmithore);
    				System.out.println(playerFood);
    				System.out.println(playerCrystite);*/
    		
    	    //pass this array into a method in StatusPanel that takes the info and uses it to update the status panel.    		
    	}
		this.gameView.getStatusPanel().updateStatusPanel(playerInfo);		
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GameController gc = new GameController();
		gc.startTitleSequence();
	}
}
