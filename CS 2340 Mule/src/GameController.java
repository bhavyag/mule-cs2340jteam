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
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * CLASS GAMECONTROLLER controls the flow of the game
 */
public class GameController {
	private TitleFrame titleView;
	private GameFrame gameView;
	private static String phase;
	private int difficulty;
	private PlayerQueue players;
	private Board board;
	private LimitTimer timer;
	private int minimumFood;

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
                        minimumFood=3;
                        
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
        players.beginRotation();
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
                updateStatus();
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
        phase = "land grant";
    	gameView.getBoardPanel().resetPlayerPos();
    	players.resetPlayers();
        
        gameView.showTilePanel();
        displayMap();
        
    	updateStatus();
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
    	
        phase = "town";
        

        int currentPlayerFood = players.getCurrentPlayer().getFood();
        int turnLength = 50;
        if (currentPlayerFood > 0 && currentPlayerFood < minimumFood){
        	turnLength = 30;
        } else if (currentPlayerFood==0){
        	turnLength = 5;
        }
        
        timer = new LimitTimer(turnLength, 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (timer.isOutOfTime()) {
                    players.next();

                    if (players.isNewRound()) {
                        timer.stop();
                        //nextPhase();
                        landGrant();
                    } else {
                        timer.reset();
                    }
                }
            }
        });

        timer.start();
        
    	Timer updateTimer = new Timer(10, new ActionListener() 
    	{
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                updateStatus();
            }
        });
    	
    	updateTimer.start();
    	
        System.out.println("starting town phase");
        
        gameView.showTownCenterPanel();
        players.beginRotation();
        
        gameView.onKeyMove( new KeyListener() 
        	{
        		public void keyPressed(KeyEvent e)
        		{
        			Player currentPlayer = players.getCurrentPlayer();
        			int key = e.getKeyCode();
        			if(key == KeyEvent.VK_W)
        			{
        				currentPlayer.moveUp();
        				//System.out.println("UP");
        			}
        			if(key == KeyEvent.VK_A)
        			{
        				currentPlayer.moveLeft();
        				//System.out.println("LEFT");
        			}
        			if(key == KeyEvent.VK_S)
        			{
        				currentPlayer.moveDown();
        				//System.out.println("DOWN");
        			}
        			if(key == KeyEvent.VK_D)
        			{
        				currentPlayer.moveRight();
        				//System.out.println("RIGHT");
        			}
        		}
        		
        		public void keyReleased(KeyEvent e)
        		{
        			
        		}
        		
        		public void keyTyped(KeyEvent e)
        		{
        			
        		}
        	}
        );

       
    }

    /**
     * METHOD that controls how the next phase will be executed (not currently being used)
     */
    private void nextPhase() {
        System.out.println("town phase over");
        gameView.dispose();
    }
    
    /**
     * METHOD for updating two main components: the JLabels of the Status Panel for each player
     * and the location of the sprite for the current player. Also calls method for collision
     * checking as player's location is updated.
     */
    public void updateStatus()
    {	
    	ArrayList<Player> playerArray = players.getPlayers();
    	//System.out.println("Num of players: " + players.getNumPlayers());
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

        if(phase == "town")
        {

	    	Player currentPlayer = players.getCurrentPlayer();
	    	currentPlayer.updateScore();
	    	URL playerImage = currentPlayer.getColor().getPlayerImagePath();
	    	int x = (int)currentPlayer.getPlayerPos().getX();
	    	int y = (int)currentPlayer.getPlayerPos().getY();
	
	    	//check which board the player is on
	    	if(gameView.getBoardPanel().isInTownCenter())
	    	{
	    		gameView.getBoardPanel().getTilePanel().drawPlayer(391, 103, playerImage);
	    		gameView.getBoardPanel().getTownCenterPanel().drawPlayer(x, y, playerImage);
	    	}
	    	else
	    	{
	    		gameView.getBoardPanel().getTownCenterPanel().drawPlayer(391, 180, playerImage);
	    		gameView.getBoardPanel().getTilePanel().drawPlayer(x, y, playerImage);
	    	}
	    	
			collisionReact();
        }
        
        //Update minimum food for turn length calculations
        if (players.getRound()>4 && players.getRound()<9){
        	minimumFood=4;
        } else if (players.getRound()>8){
        	minimumFood=5;
        }
    	
		this.gameView.getStatusPanel().updateStatusPanel(playerInfo);
    }
    
    /**
     * METHOD that checks for collisions between the player and other stuff and appropriately
     * handles game logic (ex: colliding into pub ends the turn)
     */
    public void collisionReact()
    {
    	if(phase == "town")
    	{
    		if(gameView.getBoardPanel().checkCollisionPub()) 
    	
	    	{
    			Random rand = new Random();
    			Player currentPlayer = players.getCurrentPlayer();
    			int timeLeft = timer.getTimeRemaining();
    			int moneyFromPub = 1+rand.nextInt(timeLeft);
    			System.out.println(moneyFromPub);
    			currentPlayer.addMoney(moneyFromPub);
    			
	    		System.out.println("YOU HAVE GAMBLED YOUR TIME AWAY IN THE PUB, GOOD JOB");
	    		//players.next();
	    		
	    		if (players.pass()) {
	                timer.stop();
	                System.out.println("entering land grant");
	                phase = "land grant";
	                landGrant();
	            }
	            else {
	                timer.reset();
	            }
	    	}
	    	
    		else if(gameView.getBoardPanel().checkCollisionWestExit())
	    	{
	    		gameView.showTilePanel();
	        	Player currentPlayer = players.getCurrentPlayer();
	        	currentPlayer.setPlayerPos(new Point(319,175));
	    	}
	    	
    		else if(gameView.getBoardPanel().checkCollisionEastExit())
	    	{
	    		gameView.showTilePanel();
	        	Player currentPlayer = players.getCurrentPlayer();
	        	currentPlayer.setPlayerPos(new Point(463,175));
	    	}
	    	
    		else if(gameView.getBoardPanel().checkCollisionTown())
	    	{
	    		gameView.showTownCenterPanel();
	        	Player currentPlayer = players.getCurrentPlayer();
	        	currentPlayer.setPlayerPos(new Point(391,175));
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
