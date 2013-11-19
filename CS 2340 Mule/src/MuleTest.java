import static org.junit.Assert.*;
import model.*;
import view.game.*;

import org.junit.Test;

public class MuleTest 
{

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	/*
	 * Chris's Tests
	 */
	Player playerChris = new Player(0);
	//test buying from market
	public void marketBuyTest()
	{
		MarketPanel marketPanel = new MarketPanel();
		//set player resources
		playerChris.setFood(0);
		playerChris.setSmithore(0);
		playerChris.setEnergy(0);
		playerChris.setCrystite(0);

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