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

		public boolean equals(Type type)
		{
			if (type == null)
			{
				return false;
			}
			else
			{
				return this.type.equals(type.toString());
			}
		}
	}


	private Player owner;
	private Type type;
	private int price;

	public Mule(Player owner)
	{
		this.owner = owner;
		this.price = 150;
		this.type = null;
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
		if (type != null)
			this.price += type.getCost();
	}

	public int getPrice()
	{
		return price;
	}

}
