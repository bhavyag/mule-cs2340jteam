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
		
		

}