/**
 * 
 */
package model;

/**
 * @author Bhavya
 *
 */
public class Mule {

	public static enum Type
	{
		ENERGY("energy"),
		FOOD("food"),
		SMITHORE("smithore"),
		CRYSTITE("crystite");

		private String type;
		
		Type(String type) {
			this.type = type;
		}
		
		public String toString()
		{
			return type;
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
	
}
