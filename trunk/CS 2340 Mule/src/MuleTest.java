import static org.junit.Assert.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.*;
import view.game.*;

import org.junit.Test;

public class MuleTest 
{

	MarketPanel marketPanel = new MarketPanel();
	GameFrame gameView = new GameFrame(4);
	PlayerQueue players = new PlayerQueue(1, 0);

	/*
	 * Chris's Tests
	 */
	
	//test buying from market
	@Test
	public void testMarketBuy()
	{
		Player player = players.getCurrentPlayer();
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
		marketPanel.getBuyFoodButton().doClick();
		marketPanel.getBuySmithoreButton().doClick();
		marketPanel.getBuyEnergyButton().doClick();
		marketPanel.getBuyCrystiteButton().doClick();
		marketPanel.getTradeButton().doClick();

		assertEquals(player.getFood(), 0);
		assertEquals(player.getSmithore(), 0);
		assertEquals(player.getEnergy(), 0);
		assertEquals(player.getCrystite(), 0);
		
		//buying when there's nothing to buy
		

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