/**
 * 
 */
package model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.URL;

/**
 * @author Bhavya
 * 
 */
public class Mule implements Purchasable, Savable {

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

	private static int numMules = 0;

	private Player owner;
	private String ownerId;
	private int id;
	private Type type;
	private int price;

	public Mule() {

	}

	public Mule(Player owner) {
		this.owner = owner;
		this.price = 150;
		this.type = null;
		numMules++;
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

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwner(Player p) {
		this.owner = p;
	}

	public String getId() {
		return new Integer(id).toString();
	}

	@Override
	public String toJson() {
		JSONObject json = new JSONObject();

		if (owner != null) {
			json.put("playerId", owner.toString());
		} else {
			json.put("playerId", null);
		}

		json.put("type", type.toString());
		json.put("price", price);
		json.put("id", id);

		return json.toString();
	}

	@Override
	public Object fromJson(String jsonString) throws ParseException {
		JSONObject json = (JSONObject) new JSONParser().parse(jsonString);
		Mule mule = new Mule();

		mule.price = ((Long) json.get("price")).intValue();
		mule.ownerId = (String) json.get("playerId");
		mule.id = ((Long) json.get("id")).intValue();

		if (((Long) json.get("id")).intValue() > numMules) {
			numMules = ((Long) json.get("id")).intValue();
		}

		for (Type t : Type.values()) {
			if (json.get("type").equals(t.toString())) {
				mule.type = t;
			}
		}

		return mule;
	}
}
