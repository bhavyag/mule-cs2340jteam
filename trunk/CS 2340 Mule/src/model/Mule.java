/**
 * 
 */
package model;

import java.net.URL;

/**
 * @author Bhavya
 * 
 */
public class Mule implements Purchasable {

	public static enum Type {
		FOOD("food", 25, Player.class
				.getResource("/sprites/tiles/food-mule-tile.png")), ENERGY(
				"energy", 50, Player.class
						.getResource("/sprites/tiles/energy-mule-tile.png")), SMITHORE(
				"smithore", 75, Player.class
						.getResource("/sprites/tiles/smithore-mule-tile.png")), CRYSTITE(
				"crystite", 100, Player.class
						.getResource("/sprites/tiles/crystite-mule-tile.png"));

		private String type;
		private int cost;
		private URL iconImagePath;

		Type(String type, int cost, URL imagePath) {
			this.type = type;
			this.cost = cost;
			this.iconImagePath = imagePath;
		}

		public String toString() {
			return type;
		}

		public int getCost() {
			return cost;
		}

		public URL getIconImagePath() {
			return iconImagePath;
		}

		public boolean equals(Type type) {
			if (type == null) {
				return false;
			} else {
				return this.type.equals(type.toString());
			}
		}
	}

	private Player owner;
	private Type type;
	private int price;

	public Mule(Player owner) {
		this.owner = owner;
		this.price = 150;
		this.type = null;
	}

	public Player getOwner() {
		return owner;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
		if (type != null) {
			this.price += type.getCost();
		}
	}

	public int getPrice() {
		return price;
	}

}
