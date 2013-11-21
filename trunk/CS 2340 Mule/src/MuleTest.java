import static org.junit.Assert.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.*;
import view.game.*;

import javax.swing.*;

import org.junit.Test;

public class MuleTest 
{

	GameFrame gameView;
	PlayerQueue players;
	Player player;
	
	/*
	 * Chris's Tests
	 */
	
	private static void sendData(Player player, GameFrame gameView)
	{
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
	
	//test buying from market
	@Test
	public void testMarketBuy()
	{
		gameView = new GameFrame(1);
		players = new PlayerQueue(1, 0);
		player = players.getCurrentPlayer();
		player.setName("CHRIS");
		gameView.getMarketPanel().onClickTrade(
				new MouseAdapter() 
				{
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						int[][] data = gameView.getMarketPanel().getMarketData();
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
						else
						{
							System.out.println();
						}
					}
				}
				
				);

		//set player resources
		player.setFood(0);
		player.setSmithore(0);
		player.setEnergy(0);
		player.setCrystite(0);
		player.incrementMoney(-10000);
		
		//set store resources
		Market.setMarketFood(10);
		Market.setMarketSmithore(10);
		Market.setMarketEnergy(10);
		Market.setMarketCrystite(10);

	//buying when player has no money
		sendData( player, gameView);
		
		gameView.getMarketPanel().getBuyFoodButton().doClick(10);
		gameView.getMarketPanel().getBuySmithoreButton().doClick(10);
		gameView.getMarketPanel().getBuyEnergyButton().doClick(10);
		gameView.getMarketPanel().getBuyCrystiteButton().doClick(10);
		gameView.getMarketPanel().getTradeButton().doClick(10);

		assertEquals(0, player.getFood());
		assertEquals(0, player.getSmithore() );
		assertEquals(0, player.getEnergy());
		assertEquals(0, player.getCrystite());
		
	//buying when there's nothing to buy
		player.incrementMoney(10000);
		
		Market.setMarketFood(0);
		Market.setMarketSmithore(0);
		Market.setMarketEnergy(0);
		Market.setMarketCrystite(0);
		
		sendData( player, gameView);
		gameView.getMarketPanel().getBuyFoodButton().doClick(10);
		gameView.getMarketPanel().getBuySmithoreButton().doClick(10);
		gameView.getMarketPanel().getBuyEnergyButton().doClick(10);
		gameView.getMarketPanel().getBuyCrystiteButton().doClick(10);
		gameView.getMarketPanel().getTradeButton().doClick(10);
		
		assertEquals(0, player.getFood());
		assertEquals(0, player.getSmithore() );
		assertEquals(0,player.getEnergy());
		assertEquals(0, player.getCrystite());
		
	//selling when there is nothing to sell
		
		player.setFood(0);
		player.setSmithore(0);
		player.setEnergy(0);
		player.setCrystite(0);
		
		Market.setMarketFood(0);
		Market.setMarketSmithore(0);
		Market.setMarketEnergy(0);
		Market.setMarketCrystite(0);
		
		sendData( player, gameView);
		gameView.getMarketPanel().getSellFoodButton().doClick(10);
		gameView.getMarketPanel().getSellSmithoreButton().doClick(10);
		gameView.getMarketPanel().getSellEnergyButton().doClick(10);
		gameView.getMarketPanel().getSellCrystiteButton().doClick(10);
		gameView.getMarketPanel().getTradeButton().doClick(10);
		
		assertEquals( 0, Market.getMarketFood());
		assertEquals(0, Market.getMarketSmithore());
		assertEquals(0, Market.getMarketEnergy());
		assertEquals( 0, Market.getMarketCrystite());
	}







	/*
	 * Bhavya's Tests:
	 * 
	 * buying land
	 * random events
	 */

	PlayerQueue playerQ2 = new PlayerQueue(1, 600);
	
	@Test
	public void initializeTestsBhavya()
	{
		playerQ2.getCurrentPlayer().setFood(30);
		playerQ2.getCurrentPlayer().setEnergy(30);
		playerQ2.getCurrentPlayer().setSmithore(30);
		playerQ2.getCurrentPlayer().setCrystite(30);
		
		checkEdgeCollisions();
		//call tests after this
	}

	/*
	private String testRandomEvents()
	{
		return RandomEvent.performRandom(playerQ2, playerQ2.getCurrentIndex());
	}*/
	
	
	//player collision checking with edge of screen:
	public void checkEdgeCollisions()
	{
		boolean topCheck = true, bottomCheck = true, leftCheck = true, rightCheck = true;
		for (int i = 0; i < 401; i++)
		{
			playerQ2.getCurrentPlayer().moveUp();
			if (playerQ2.getCurrentPlayer().getPlayerPos().y < 0)
				topCheck = false;
		}
		
		for (int i = 0; i < 401; i++)
		{
			playerQ2.getCurrentPlayer().moveDown();
			if (playerQ2.getCurrentPlayer().getPlayerPos().y > 400)
				bottomCheck = false;
		}
		
		for (int i = 0; i < 785; i++)
		{
			playerQ2.getCurrentPlayer().moveRight();
			if (playerQ2.getCurrentPlayer().getPlayerPos().x > 781)
				rightCheck = false;
		}
		
		for (int i = 0; i < 785; i++)
		{
			playerQ2.getCurrentPlayer().moveLeft();
			if (playerQ2.getCurrentPlayer().getPlayerPos().x < 0)
				leftCheck = false;
		}
		
		assertTrue(topCheck);
		assertTrue(bottomCheck);
		assertTrue(rightCheck);
		assertTrue(leftCheck);
	}

}