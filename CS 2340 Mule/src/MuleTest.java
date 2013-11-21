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
	PlayerQueue players = new PlayerQueue(1, 600);

	/*
	 * Chris's Tests
	 */
	
	//test buying from market
	public void marketBuyTest()
	{
		
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

		//buying when there's nothing to buy

	}







	/*
	 * Bhavya's Tests:
	 * 
	 * buying land
	 * random events
	 */

	PlayerQueue playerQ2 = new PlayerQueue(1, 600);
	
	public void initializeTestsBhavya()
	{
		playerQ2.getCurrentPlayer().setFood(30);
		playerQ2.getCurrentPlayer().setEnergy(30);
		playerQ2.getCurrentPlayer().setSmithore(30);
		playerQ2.getCurrentPlayer().setCrystite(30);
		
		//call tests after this
	}

	private String testRandomEvents()
	{
		return RandomEvent.performRandom(playerQ2, playerQ2.getCurrentIndex());
	}
	
	//player collision checking with edge of screen:

}