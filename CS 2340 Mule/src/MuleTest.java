import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.*;
import view.game.*;

import javax.swing.*;

import org.junit.Test;

public class MuleTest {

	GameFrame gameView;
	PlayerQueue players;
	Player player;

	/*
	 * Chris's Tests
	 */

	private static void sendData(Player player, GameFrame gameView) {
		int[][] marketInfo = new int[4][4];

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

		gameView.getMarketPanel().setUpMarket(marketInfo);
	}

	// test buying from market
	@Test
	public void testMarketBuy() {
		gameView = new GameFrame(1);
		players = new PlayerQueue(1, 0);
		player = players.getCurrentPlayer();
		player.setName("CHRIS");
		gameView.getMarketPanel().onClickTrade(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int[][] data = gameView.getMarketPanel().getMarketData();
				if (player.getMoney() + data[2][0] >= 0) {
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
				} else {
					System.out.println();
				}
			}
		}

		);

		// set player resources
		player.setFood(0);
		player.setSmithore(0);
		player.setEnergy(0);
		player.setCrystite(0);
		player.incrementMoney(-10000);

		// set store resources
		Market.setMarketFood(10);
		Market.setMarketSmithore(10);
		Market.setMarketEnergy(10);
		Market.setMarketCrystite(10);

		// buying when player has no money
		sendData(player, gameView);

		gameView.getMarketPanel().getBuyFoodButton().doClick(10);
		gameView.getMarketPanel().getBuySmithoreButton().doClick(10);
		gameView.getMarketPanel().getBuyEnergyButton().doClick(10);
		gameView.getMarketPanel().getBuyCrystiteButton().doClick(10);
		gameView.getMarketPanel().getTradeButton().doClick(10);

		assertEquals(0, player.getFood());
		assertEquals(0, player.getSmithore());
		assertEquals(0, player.getEnergy());
		assertEquals(0, player.getCrystite());

		// buying when there's nothing to buy
		player.incrementMoney(10000);

		Market.setMarketFood(0);
		Market.setMarketSmithore(0);
		Market.setMarketEnergy(0);
		Market.setMarketCrystite(0);

		sendData(player, gameView);
		gameView.getMarketPanel().getBuyFoodButton().doClick(10);
		gameView.getMarketPanel().getBuySmithoreButton().doClick(10);
		gameView.getMarketPanel().getBuyEnergyButton().doClick(10);
		gameView.getMarketPanel().getBuyCrystiteButton().doClick(10);
		gameView.getMarketPanel().getTradeButton().doClick(10);

		assertEquals(0, player.getFood());
		assertEquals(0, player.getSmithore());
		assertEquals(0, player.getEnergy());
		assertEquals(0, player.getCrystite());

		// selling when there is nothing to sell

		player.setFood(0);
		player.setSmithore(0);
		player.setEnergy(0);
		player.setCrystite(0);

		Market.setMarketFood(0);
		Market.setMarketSmithore(0);
		Market.setMarketEnergy(0);
		Market.setMarketCrystite(0);

		sendData(player, gameView);
		gameView.getMarketPanel().getSellFoodButton().doClick(10);
		gameView.getMarketPanel().getSellSmithoreButton().doClick(10);
		gameView.getMarketPanel().getSellEnergyButton().doClick(10);
		gameView.getMarketPanel().getSellCrystiteButton().doClick(10);
		gameView.getMarketPanel().getTradeButton().doClick(10);

		assertEquals(0, Market.getMarketFood());
		assertEquals(0, Market.getMarketSmithore());
		assertEquals(0, Market.getMarketEnergy());
		assertEquals(0, Market.getMarketCrystite());
	}
	
	@Test
	public void testMapOneGen()
	{
		Board board = BoardFactory.constructBoard(0);
		assertEquals(Tile.Type.PLAINS, board.getMap()[0][0].getType());
		assertEquals(Tile.Type.MOUNTAINONE, board.getMap()[0][2].getType());
		assertEquals(Tile.Type.MOUNTAINTWO, board.getMap()[3][1].getType());
		assertEquals(Tile.Type.MOUNTAINTHREE, board.getMap()[0][6].getType());
		assertEquals(Tile.Type.RIVER, board.getMap()[0][4].getType());
		assertEquals(Tile.Type.TOWN, board.getMap()[2][4].getType());
	}
	
	@Test
	public void testMapTwoGen()
	{
		Board board = BoardFactory.constructBoard(1);
		assertEquals(Tile.Type.PLAINS, board.getMap()[0][0].getType());
		assertEquals(Tile.Type.MOUNTAINONE, board.getMap()[0][3].getType());
		assertEquals(Tile.Type.MOUNTAINTWO, board.getMap()[3][1].getType());
		assertEquals(Tile.Type.MOUNTAINTHREE, board.getMap()[0][8].getType());
		assertEquals(Tile.Type.RIVER, board.getMap()[1][0].getType());
		assertEquals(Tile.Type.TOWN, board.getMap()[2][4].getType());
	}
	
	@Test
	public void testTileSprites()
	{
		Tile p = new Tile(Tile.Type.PLAINS);
		Tile m1 = new Tile(Tile.Type.MOUNTAINONE);
		Tile m2 = new Tile(Tile.Type.MOUNTAINTWO);
		Tile m3 = new Tile(Tile.Type.MOUNTAINTHREE);
		Tile r = new Tile(Tile.Type.RIVER);
		Tile t = new Tile(Tile.Type.TOWN);
		
		assertEquals(Tile.class.getResource("/sprites/tiles/Plains-Tile.png"), p.getImagePath());
		assertEquals(Tile.class.getResource("/sprites/tiles/Mountain-Tile.png"), m1.getImagePath());
		assertEquals(Tile.class.getResource("/sprites/tiles/Mountain-2-Tile.png"), m2.getImagePath());
		assertEquals(Tile.class.getResource("/sprites/tiles/Mountain-3-Tile.png"), m3.getImagePath());
		assertEquals(Tile.class.getResource("/sprites/tiles/River-Tile.png"), r.getImagePath());
		assertEquals(Tile.class.getResource("/sprites/tiles/Town-Center-Tile.png"), t.getImagePath());
	}

	/*
	 * Bhavya's Tests:
	 * 
	 * buying land random events
	 */

	PlayerQueue playerQ2;
	Board board;

	@Test
	public void initializeTestsBhavya() {
		playerQ2 = new PlayerQueue(1, 600);

		playerQ2.getCurrentPlayer().setFood(30);
		playerQ2.getCurrentPlayer().setEnergy(30);
		playerQ2.getCurrentPlayer().setSmithore(30);
		playerQ2.getCurrentPlayer().setCrystite(30);

		board = BoardFactory.constructBoard(0);

		checkEdgeCollisions();
		checkBuyingLand();
		// call tests after this
	}

	/*
	 * private String testRandomEvents() { return
	 * RandomEvent.performRandom(playerQ2, playerQ2.getCurrentIndex()); }
	 */

	// player collision checking with edge of screen:
	
	public void checkEdgeCollisions() {
		boolean topCheck = true, bottomCheck = true, leftCheck = true, rightCheck = true;
		for (int i = 0; i < 401; i++) {
			playerQ2.getCurrentPlayer().moveUp();
			if (playerQ2.getCurrentPlayer().getPlayerPos().y < 0)
				topCheck = false;
		}

		for (int i = 0; i < 401; i++) {
			playerQ2.getCurrentPlayer().moveDown();
			if (playerQ2.getCurrentPlayer().getPlayerPos().y > 400)
				bottomCheck = false;
		}

		for (int i = 0; i < 785; i++) {
			playerQ2.getCurrentPlayer().moveRight();
			if (playerQ2.getCurrentPlayer().getPlayerPos().x > 781)
				rightCheck = false;
		}

		for (int i = 0; i < 785; i++) {
			playerQ2.getCurrentPlayer().moveLeft();
			if (playerQ2.getCurrentPlayer().getPlayerPos().x < 0)
				leftCheck = false;
		}

		assertTrue(topCheck);
		assertTrue(bottomCheck);
		assertTrue(rightCheck);
		assertTrue(leftCheck);
	}
	
	 
	
	public void checkBuyingLand() {
		board.setOwner(playerQ2.getCurrentPlayer(), new Point(0, 0));
		board.setOwner(playerQ2.getCurrentPlayer(), new Point(1, 1));
		board.setOwner(playerQ2.getCurrentPlayer(), new Point(2, 2));
		board.setOwner(playerQ2.getCurrentPlayer(), new Point(3, 3));
		board.setOwner(playerQ2.getCurrentPlayer(), new Point(4, 4));
		board.setOwner(playerQ2.getCurrentPlayer(), new Point(3, 5));
		board.setOwner(playerQ2.getCurrentPlayer(), new Point(2, 6));
		board.setOwner(playerQ2.getCurrentPlayer(), new Point(1, 7));
		board.setOwner(playerQ2.getCurrentPlayer(), new Point(0, 6));
		board.setOwner(playerQ2.getCurrentPlayer(), new Point(1, 5));

		assertTrue(board.getMap()[0][0].getOwner() == playerQ2
				.getCurrentPlayer());
		assertTrue(board.getMap()[1][1].getOwner() == playerQ2
				.getCurrentPlayer());
		assertTrue(board.getMap()[2][2].getOwner() == playerQ2
				.getCurrentPlayer());
		assertTrue(board.getMap()[3][3].getOwner() == playerQ2
				.getCurrentPlayer());
		assertTrue(board.getMap()[4][4].getOwner() == playerQ2
				.getCurrentPlayer());
		assertTrue(board.getMap()[3][5].getOwner() == playerQ2
				.getCurrentPlayer());
		assertTrue(board.getMap()[2][6].getOwner() == playerQ2
				.getCurrentPlayer());
		assertTrue(board.getMap()[1][7].getOwner() == playerQ2
				.getCurrentPlayer());
		assertTrue(board.getMap()[0][6].getOwner() == playerQ2
				.getCurrentPlayer());
		assertTrue(board.getMap()[1][5].getOwner() == playerQ2
				.getCurrentPlayer());

	}
	
	/*
	 * T.J.'s tests
	 *
	 * scoreSort
	 * 
	 */
	
	PlayerQueue playerQ3 = new PlayerQueue(4, 600);
	
	public void testsTJ(){		
		boolean one=false,two=true,three=true,four=true;
		
		playerQ3.get(0).setName("P1");
		playerQ3.get(1).setName("P2");
		playerQ3.get(2).setName("P3");
		playerQ3.get(3).setName("P4");
		
		playerQ3.get(0).setRace(0);
		playerQ3.get(1).setRace(1);
		playerQ3.get(2).setRace(2);
		playerQ3.get(3).setRace(3);
		
		playerQ3.get(0).setColor(0);
		playerQ3.get(1).setColor(1);
		playerQ3.get(2).setColor(2);
		playerQ3.get(3).setColor(3);
		
		playerQ3.get(0).setFood(10);
		playerQ3.get(1).setFood(20);
		playerQ3.get(2).setFood(0);
		playerQ3.get(3).setFood(5);
		
		playerQ3.scoreSort();
		
		if(playerQ3.get(0).getRace().equals(Player.Race.BONZIOD)){
			if(playerQ3.get(1).getRace().equals(Player.Race.UGAITE)){
				if(playerQ3.get(2).getRace().equals(Player.Race.HUMAN)){
					one=true;
				}
			}
		}
		
		playerQ3.get(0).setRace(0);
		playerQ3.get(1).setRace(1);
		playerQ3.get(2).setRace(2);
		playerQ3.get(3).setRace(3);
		
		playerQ3.get(0).setFood(2);
		playerQ3.get(1).setFood(5);
		playerQ3.get(2).setFood(1);
		playerQ3.get(3).setFood(0);
		playerQ3.get(0).setEnergy(2);
		playerQ3.get(1).setEnergy(5);
		playerQ3.get(2).setEnergy(1);
		playerQ3.get(3).setEnergy(0);
		
		playerQ3.scoreSort();
		
		if(playerQ3.get(0).getRace().equals(Player.Race.UGAITE)){
			if(playerQ3.get(1).getRace().equals(Player.Race.BONZIOD)){
				if(playerQ3.get(2).getRace().equals(Player.Race.HUMAN)){
					two=true;
				}
			}
		}
		
		playerQ3.get(0).setRace(0);
		playerQ3.get(1).setRace(1);
		playerQ3.get(2).setRace(2);
		playerQ3.get(3).setRace(3);
		
		playerQ3.get(0).setFood(1);
		playerQ3.get(1).setFood(2);
		playerQ3.get(2).setFood(3);
		playerQ3.get(3).setFood(4);
		playerQ3.get(0).setEnergy(8);
		playerQ3.get(1).setEnergy(7);
		playerQ3.get(2).setEnergy(6);
		playerQ3.get(3).setEnergy(5);
		playerQ3.get(0).setSmithore(9);
		playerQ3.get(1).setSmithore(10);
		playerQ3.get(2).setSmithore(12);
		playerQ3.get(3).setSmithore(11);
		//P1 -> 1*30 + 8*25 + 9*50  = 680 HUMAN
		//P2 -> 2*30 + 7*25 + 10*50 = 735 FLAPPER
		//P3 -> 3*30 + 6*25 + 12*50 = 840 BONZIOD
		//P3 -> 4*30 + 5*25 + 11*50 = 795 UGAITE
		
		playerQ3.scoreSort();
		
		if(playerQ3.get(0).getRace().equals(Player.Race.HUMAN)){
			if(playerQ3.get(1).getRace().equals(Player.Race.FLAPPER)){
				if(playerQ3.get(2).getRace().equals(Player.Race.UGAITE)){
					three=true;
				}
			}
		}
		
		playerQ3.get(0).setRace(0);
		playerQ3.get(1).setRace(1);
		playerQ3.get(2).setRace(2);
		playerQ3.get(3).setRace(3);
		
		playerQ3.get(0).incrementMoney(10000);
		playerQ3.get(1).incrementMoney(5000);
		playerQ3.get(2).incrementMoney(2500);
		playerQ3.get(3).incrementMoney(1000);
		
		playerQ3.scoreSort();
		
		if(playerQ3.get(0).getRace().equals(Player.Race.UGAITE)){
			if(playerQ3.get(1).getRace().equals(Player.Race.BONZIOD)){
				if(playerQ3.get(2).getRace().equals(Player.Race.FLAPPER)){
					four=true;
				}
			}
		}
		
		
		assertTrue(one);
		assertTrue(two);
		assertTrue(three);
		assertTrue(four);
	}

}
