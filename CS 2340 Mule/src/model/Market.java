package model;

/**
 * CLASS to hold both the amount of resources the store currently has, as well as their buying and selling prices
 * @author Chris
 *
 */
public class Market 
 {
	
	private Market()
	{
		
	}
	protected static int energy = 0,
						smithore = 0,
						food = 0,
						crystite = 0,
						buyEnergyPrice = -200,
						sellEnergyPrice = 150,
						buyFoodPrice = -100,
						sellFoodPrice = 50,
						buySmithorePrice = -300,
						sellSmithorePrice = 250,
						buyCrystitePrice = -400,
						sellCrystitePrice = 350;
	
	public static int getBuyFoodPrice()
	{
		return buyFoodPrice;
	}
	
	public static int getSellFoodPrice()
	{
		return sellFoodPrice;
	}
	
	public static int getBuySmithorePrice()
	{
		return buySmithorePrice;
	}
	
	public static int getSellSmithorePrice()
	{
		return sellSmithorePrice;
	}
	
	public static int getBuyEnergyPrice()
	{
		return buyEnergyPrice;
	}
	
	public static int getSellEnergyPrice()
	{
		return sellEnergyPrice;
	}
	
	public static int getBuyCrystitePrice()
	{
		return buyCrystitePrice;
	}
	
	public static int getSellCrystitePrice()
	{
		return sellCrystitePrice;
	}
	
	public static int getMarketFood()
	{
		return food;
	}
	
	public static int getMarketSmithore()
	{
		return smithore;
	}
	
	public static int getMarketEnergy()
	{
		return energy;
	}
	
	public static int getMarketCrystite()
	{
		return crystite;
	}
	
	public static void setMarketFood(int i)
	{
		food = i;
	}
	
	public static void setMarketSmithore(int i)
	{
		smithore = i;
	}
	
	public static void setMarketEnergy(int i)
	{
		energy = i;
	}
	
	public static void setMarketCrystite(int i)
	{
		crystite = i;
	}
}
