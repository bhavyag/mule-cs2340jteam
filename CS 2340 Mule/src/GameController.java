import model.*;
import util.LimitTimer;
import view.game.DialogMessage;
import view.game.GameFrame;
import view.title.TitleFrame;

import javax.swing.*;

import java.awt.*; 	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * CLASS GAMECONTROLLER controls the flow of the game
 */
public class GameController implements Serializable {
	private TitleFrame titleView;
	private GameFrame gameView;
	private static String phase;
	private int difficulty;
	private PlayerQueue players;
	private Board board;
	private LimitTimer timer;
	private int minimumFood;
	private DialogMessage randEvent;

	/**
	 * METHOD begins the title sequence
	 */
	public void startTitleSequence() {
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
						players = new PlayerQueue(titleView.getGameConfigNumPlayers(), 600 / difficulty);
						minimumFood = 3;

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
	public void startGame() {
		titleView.dispose();
		gameView = new GameFrame(players.getNumPlayers());

		configureTimer();
		players.beginRotation();
		randomEvent("land grant");
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
	 * METHOD creates a random event and notifies the user through
	 * a DialogMessage box
	 */
	private void randomEvent(final String state){
		Random rand = new Random();
		 //change this to 0.27 later
		if (rand.nextDouble() > 0.07){
			if (state.equals("land grant")){
				phase = "land grant";
				gameView.getBoardPanel().resetPlayerPos();
				players.resetPlayers();

				updateStatus();
				gameView.showTilePanel();
				displayMap();
				landGrant();
			}
			else if (state.equals("timer"))
				timer.reset();
		}
		else{
			if (state.equals("land grant")){
				phase = "land grant";
				gameView.getBoardPanel().resetPlayerPos();
				players.resetPlayers();

				updateStatus();
				gameView.showTilePanel();
				displayMap();
			}

			randEvent = new DialogMessage(RandomEvent.performRandom(players, players.getCurrentIndex()));
			randEvent.onClickNext(
					new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							randEvent.dispose();
							if (state.equals("land grant"))
								landGrant();
							else if (state.equals("timer"))
								timer.reset();
						}
					}
					);
		}
	}

	/**
	 * METHOD begins the land grant portion of the game
	 */
	private void landGrant() {
		//		phase = "land grant";
		//		gameView.getBoardPanel().resetPlayerPos();
		//		players.resetPlayers();
		//
		//		gameView.showTilePanel();
		//		displayMap();

		/*
		if (!randCheck)
		{
			randEvent = new DialogMessage(RandomEvent.performRandom(players, players.getCurrentIndex()));

			randEvent.onClickNext(
					new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							randEvent.dispose();
							randCheck = true;
							synchronized(waitThread)
							{
								waitThread.notify();
							}
						}
					}
					);
			synchronized(waitThread)
			{
				try 
				{
					waitThread.wait();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		}
		 */

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
									randomEvent("timer");//timer.reset();
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
									randomEvent("timer");//timer.reset();
								}
							}
						}
					}
				}
				);

		timer = new LimitTimer(15, 1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				if (timer.isOutOfTime()) {
					if (players.pass()) {
						timer.stop();
						System.out.println("entering townphase");
						townPhase();
					} else {
						randomEvent("timer");//timer.reset();
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
		gameView.onTileClick(null);

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
						randomEvent("land grant");
					} else {
						timer.reset();
						gameView.showTownCenterPanel();
					}
				}
			}
		});

		timer.start();

		Timer updateTimer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				updateStatus();
			}
		});

		updateTimer.start();

		System.out.println("starting town phase");

		gameView.showTownCenterPanel();
		calculateProduction();
		players.beginRotation();

		gameView.onKeyMove( new KeyListener() {
			public void keyPressed(KeyEvent e){
				Player currentPlayer = players.getCurrentPlayer();
				int key = e.getKeyCode();
				int maxHeight = 348, maxWidth = 780, minHeight = 20, minWidth = 0;

				if (!gameView.getBoardPanel().isInTownCenter()){
					minWidth = 92;
					minHeight = 25;
					maxWidth = 668 + 20;
					maxHeight = 308 + 20;
				}

				if(key == KeyEvent.VK_W && currentPlayer.getPlayerPos().y >= minHeight)
				{
					currentPlayer.moveUp();
					//System.out.println("UP");
				}
				else if(key == KeyEvent.VK_A && currentPlayer.getPlayerPos().x >= minWidth)
				{
					currentPlayer.moveLeft();
					//System.out.println("LEFT");
				}
				else if(key == KeyEvent.VK_S && currentPlayer.getPlayerPos().y <= maxHeight)
				{
					currentPlayer.moveDown();
					//System.out.println("DOWN");
				}
				else if(key == KeyEvent.VK_D && currentPlayer.getPlayerPos().x <= maxWidth)
				{
					currentPlayer.moveRight();
					//System.out.println("RIGHT");
				}
				else if(key == KeyEvent.VK_E)
				{

					Point whereAt = currentPlayer.getPlayerPos();



					Point tileIndex = gameView.getTileIndex(whereAt);
					//tileIndex.setX();
					Tile t = board.map[(int)tileIndex.getX()][(int)tileIndex.getY()];
					if(t.getOwner() != null && currentPlayer.toString().equals(t.getOwner().toString()))
					{
						if(currentPlayer.isHoldingMule())
						{
							if(currentPlayer.getHoldingMule().getType() != null)
							{
								System.out.println("MULE Placed on tile");
								
								gameView.getBoardPanel().getTilePanel().setIconImage(
										currentPlayer.getHoldingMule().getType().getIconImagePath(), (int)tileIndex.getX(), (int)tileIndex.getY());
								currentPlayer.placeMule();
								
								//call setIconImage(URL,x,y) in tile panel 
								//to set the image displayed on the tile based 
								//on the type of mule placed on it. get the image 
								//out of the enum for the mule, x and y are the same 
								//as the x and y of the tile array(5 x 9, this does 
								//NOT take in a pixel coordinate)
							}
						}
						else
							System.out.println("Player is not holding a mule");
					}
					else
						System.out.println("Player doesn't own this tile!");
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

	private void sendMarketData()
	{
		int[][] marketInfo = new int[4][4];
		Player player = players.getCurrentPlayer();

		marketInfo[0][0] = player.getFood();
		marketInfo[0][1] = player.getSmithore();
		marketInfo[0][2] = player.getEnergy();
		marketInfo[0][3] = player.getCrystite();
		marketInfo[1][0] = Market.getMarketFood();
		marketInfo[1][1] = Market.getMarketSmithore();
		marketInfo[1][2] = Market.getMarketEnergy();
		marketInfo[1][3] = Market.getMarketCrystite();
		marketInfo[2][0] = Market.getBuyFoodPrice(); 
		marketInfo[2][1] = Market.getBuySmithorePrice();
		marketInfo[2][2] = Market.getBuyEnergyPrice();
		marketInfo[2][3] = Market.getBuyCrystitePrice();
		marketInfo[3][0] = Market.getSellFoodPrice();
		marketInfo[3][1] = Market.getSellSmithorePrice();
		marketInfo[3][2] = Market.getSellEnergyPrice();
		marketInfo[3][3] = Market.getSellCrystitePrice();

		this.gameView.getMarketPanel().setUpMarket(marketInfo);
	}
	/**
	 * METHOD that sets up the market screen
	 */
	private void marketScreen() {
		gameView.showMarketPanel();
		sendMarketData();
		gameView.getMarketPanel().onClickExit(
				new MouseAdapter() 
				{
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						Player currentPlayer = players.getCurrentPlayer();
						currentPlayer.setPlayerPos(new Point(280,192));
						System.out.println("LEAVING MARKET");
						gameView.showTownCenterPanel();
					}
				}
				);

		gameView.getMarketPanel().onClickTrade(
				new MouseAdapter() 
				{
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						int[][] data = gameView.getMarketPanel().getMarketData();
						Player player = players.getCurrentPlayer();
						if(player.getMoney() + data[2][0] >= 0)
						{
							player.setFood(data[0][0]);
							player.setSmithore(data[0][1]);
							player.setEnergy(data[0][2]);
							player.setCrystite(data[0][3]);
							Market.setMarketFood(data[1][0]); 
							Market.setMarketSmithore(data[1][1]);
							Market.setMarketEnergy(data[1][2]);
							Market.setMarketCrystite(data[1][3]);
							player.incrementMoney(data[2][0]);
							gameView.getMarketPanel().resetTotal();
						}	
					}
				}
				);
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
			URL playerImage = currentPlayer.getImagePath();
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
	 * METHOD that calculates production for each player
	 * based on the tiles owned by players and the mules
	 * placed on those tiles.
	 */
	public void calculateProduction()
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(board.getOwnerXY(i,j)!=null)
				{
					if(board.getMuleTypeXY(i,j)!=null)
					{
						if(board.getTypeXY(i,j)==Tile.Type.RIVER)
						{
							if(board.getOwnerXY(i, j).getEnergy()>0){
								board.getOwnerXY(i, j).incrementEnergy(-1);
								if(board.getMuleTypeXY(i, j)==Mule.Type.FOOD)
								{
									board.getOwnerXY(i, j).incrementFood(4);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.ENERGY)
								{
									board.getOwnerXY(i, j).incrementEnergy(2);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.SMITHORE)
								{
									//nothing
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.CRYSTITE)
								{
									//nothing
								}
							}
						}
						else if(board.getTypeXY(i,j)==Tile.Type.PLAINS)
						{
							if(board.getOwnerXY(i, j).getEnergy()>0){
								board.getOwnerXY(i, j).incrementEnergy(-1);
								if(board.getMuleTypeXY(i, j)==Mule.Type.FOOD)
								{
									board.getOwnerXY(i, j).incrementFood(2);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.ENERGY)
								{
									board.getOwnerXY(i, j).incrementEnergy(3);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.SMITHORE)
								{
									board.getOwnerXY(i, j).incrementSmithore(1);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.CRYSTITE)
								{
									//TODO:Implement crystite
								}
							}
						}
						else if(board.getTypeXY(i,j)==Tile.Type.MOUNTAINONE)
						{
							if(board.getOwnerXY(i, j).getEnergy()>0){
								board.getOwnerXY(i, j).incrementEnergy(-1);
								if(board.getMuleTypeXY(i, j)==Mule.Type.FOOD)
								{
									board.getOwnerXY(i, j).incrementFood(1);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.ENERGY)
								{
									board.getOwnerXY(i, j).incrementEnergy(1);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.SMITHORE)
								{
									board.getOwnerXY(i, j).incrementSmithore(2);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.CRYSTITE)
								{
									//TODO:Implement crystite
								}
							}
						}
						else if(board.getTypeXY(i,j)==Tile.Type.MOUNTAINTWO)
						{
							if(board.getOwnerXY(i, j).getEnergy()>0){
								board.getOwnerXY(i, j).incrementEnergy(-1);
								if(board.getMuleTypeXY(i, j)==Mule.Type.FOOD)
								{
									board.getOwnerXY(i, j).incrementFood(1);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.ENERGY)
								{
									board.getOwnerXY(i, j).incrementEnergy(1);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.SMITHORE)
								{
									board.getOwnerXY(i, j).incrementSmithore(3);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.CRYSTITE)
								{
									//TODO:Implement crystite
								}
							}
						}
						else if(board.getTypeXY(i,j)==Tile.Type.MOUNTAINTHREE)
						{
							if(board.getOwnerXY(i, j).getEnergy()>0){
								board.getOwnerXY(i, j).incrementEnergy(-1);
								if(board.getMuleTypeXY(i, j)==Mule.Type.FOOD)
								{
									board.getOwnerXY(i, j).incrementFood(1);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.ENERGY)
								{
									board.getOwnerXY(i, j).incrementEnergy(1);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.SMITHORE)
								{
									board.getOwnerXY(i, j).incrementSmithore(4);
								}
								else if(board.getMuleTypeXY(i, j)==Mule.Type.CRYSTITE)
								{
									//TODO:Implement crystite
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * METHOD that checks for collisions between the player and other stuff and appropriately
	 * handles game logic (ex: colliding into pub ends the turn)
	 */
	public void collisionReact()
	{
		if(phase == "town")
		{
			int collidedWith = gameView.getBoardPanel().checkCollisions();
			Player currentPlayer = players.getCurrentPlayer();

			// Don't switch on strings!! Java 6 backwards compatibility blah blah blah
			// Also switches are gross unless in a factory
			// asdfjkl;asdfjka;sdfjkasdfj;askljf
			switch(collidedWith)
			{
			case 0:
				Random rand = new Random();

				int timeLeft = timer.getTimeRemaining();
				int moneyFromPub = 1+rand.nextInt(timeLeft);
				System.out.println(moneyFromPub);
				currentPlayer.incrementMoney(moneyFromPub);

				System.out.println("YOU HAVE GAMBLED YOUR TIME AWAY IN THE PUB, GOOD JOB");
				//players.next();

				if (players.pass()) {
					timer.stop();
					System.out.println("entering land grant");
					phase = "land grant";
					randomEvent("land grant");
				}
				else {
					timer.reset();
				}
				break;

			case 1:
				gameView.showTilePanel();
				currentPlayer.setPlayerPos(new Point(319,175));
				break;

			case 2:
				gameView.showTilePanel();
				currentPlayer.setPlayerPos(new Point(463,175));
				break;

			case 3:
				gameView.showTownCenterPanel();
				currentPlayer.setPlayerPos(new Point(391,175));
				break;

			case 4:
				//check if the player is already holding a mule
				//check if the player has enough money
				//deduct the money from player
				//add the mule to the player's list of mules
				//set 'holding mule' to the mule object that was purchased
				if (currentPlayer.isHoldingMule() && !currentPlayer.isInStore() && currentPlayer.getHoldingMule().getType() == null)
				{
					currentPlayer.sellHoldingMule();
				}
				else if (!currentPlayer.isHoldingMule() && !currentPlayer.isInStore())
				{
					currentPlayer.purchase(new Mule(currentPlayer));
				}
				currentPlayer.setInStore(true);
				break;

			case 5:
				if (currentPlayer.isHoldingMule() && !currentPlayer.isInStore() && Mule.Type.ENERGY.equals(currentPlayer.getHoldingMule().getType()))
				{
					currentPlayer.deOutfitMule(Mule.Type.ENERGY);
					currentPlayer.setInStore(true);
				}
				else if (currentPlayer.isHoldingMule() && !currentPlayer.isInStore())
				{
					currentPlayer.outfitMule(Mule.Type.ENERGY);
				}
				currentPlayer.setInStore(true);
				break;

			case 6:

				if (currentPlayer.isHoldingMule() && !currentPlayer.isInStore() && Mule.Type.FOOD.equals(currentPlayer.getHoldingMule().getType()))
				{
					currentPlayer.deOutfitMule(Mule.Type.FOOD);
					currentPlayer.setInStore(true);
				}
				else if (currentPlayer.isHoldingMule() && !currentPlayer.isInStore())
				{
					//System.out.println("OUTFITTING MULE");
					currentPlayer.outfitMule(Mule.Type.FOOD);
					//System.out.println("OUTFITTING COMPLETE");
				}
				currentPlayer.setInStore(true);
				break;

			case 7:
				if (currentPlayer.isHoldingMule() && !currentPlayer.isInStore() && Mule.Type.SMITHORE.equals(currentPlayer.getHoldingMule().getType()))
				{
					currentPlayer.deOutfitMule(Mule.Type.SMITHORE);
					currentPlayer.setInStore(true);
				}
				else if (currentPlayer.isHoldingMule() && !currentPlayer.isInStore())
				{
					currentPlayer.outfitMule(Mule.Type.SMITHORE);
				}
				currentPlayer.setInStore(true);
				break;

			case 8:
				if (currentPlayer.isHoldingMule() && !currentPlayer.isInStore() && Mule.Type.CRYSTITE.equals(currentPlayer.getHoldingMule().getType()))
				{
					currentPlayer.deOutfitMule(Mule.Type.CRYSTITE);
					currentPlayer.setInStore(true);
				}
				else if (currentPlayer.isHoldingMule() && !currentPlayer.isInStore())
				{
					currentPlayer.outfitMule(Mule.Type.CRYSTITE);
				}
				currentPlayer.setInStore(true);
				break;

			case 9:
				marketScreen();
				break;

			case 10:
				break;
			case 11:
				currentPlayer.setInStore(false);
			}
		} 	
	}
}
