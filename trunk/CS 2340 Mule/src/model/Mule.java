/**
 * 
 */
package model;

/**
 * @author Bhavya
 *
 */
public class Mule implements Purchasable{

	public static enum Type
	{
		FOOD("food", 25),
		ENERGY("energy", 50),
		SMITHORE("smithore", 75),
		CRYSTITE("crystite", 100);

		private String type;
		private int cost;
		
		Type(String type, int cost) {
			this.type = type;
			this.cost = cost;
		}
		
		public String toString()
		{
			return type;
		}
		
		public int getCost()
		{
			return cost;
		}
	}
	
	
	private Player owner;
	private Type type;
	
	public Mule(Player owner)
	{
		this.owner = owner;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	public Type getType()
	{
		return type;
	}
	
	public void setType(Type type)
	{
		this.type = type;
	}
	
	public int getPrice()
	{
		return this.type.getCost();
	}
	
}
