package model;

public class Market 
{
	protected static int energy, smithore, food, crystite;
	
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
