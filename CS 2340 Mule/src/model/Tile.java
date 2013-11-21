package model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.URL;

public class Tile implements Purchasable, Savable {
	/**
	 * ENUM for Tile type
	 */
	public static enum Type {
		MOUNTAINONE("mountain 1", Tile.class
				.getResource("/sprites/tiles/Mountain-Tile.png"), 10), MOUNTAINTWO(
				"mountain 2", Tile.class
						.getResource("/sprites/tiles/Mountain-2-Tile.png"), 10), MOUNTAINTHREE(
				"mountain 3", Tile.class
						.getResource("/sprites/tiles/Mountain-3-Tile.png"), 10), PLAINS(
				"plains", Tile.class
						.getResource("/sprites/tiles/Plains-Tile.png"), 10), RIVER(
				"river", Tile.class
						.getResource("/sprites/tiles/River-Tile.png"), 10), TOWN(
				"town", Tile.class
						.getResource("/sprites/tiles/Town-Center-Tile.png"), 10);

		private String type;
		private URL imgPath;
		private int price;

		Type(String myType, URL imgPath, int price) {
			this.type = myType;
			this.imgPath = imgPath;
			this.price = price;
		}

		public String toString() {
			return type;
		}

		public int getPrice() {
			return price;
		}
	}

	private Type type;
	private Player owner;
	private String ownerId;
	private String muleId;
	private boolean ownable;
	private Mule mule;

	public Tile() {
	}

	/**
	 * CONTRUCTOR for Tiles
	 */
	public Tile(Type type) {
		this.type = type;
		this.ownable = true;
		this.owner = null;
	}

	/**
	 * CONSTRUCTOR for specifying whether the tile is ownable
	 * 
	 * @param type
	 *            the type of tile
	 * @param ownable
	 *            whether or not someone can purchase this tile
	 */
	public Tile(Type type, boolean ownable) {
		this.type = type;
		this.ownable = ownable;
	}

	/**
	 * METHOD allows a player to purchase a tile
	 * 
	 * @param p
	 *            the purchasing player
	 * @return true if the transaction was successful, false otherwise
	 */
	public boolean buy(Player p) {
		if (ownable && owner == null) {
			if (p.purchase(this)) {
				this.owner = p;
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("cannot own tile");
			return false;
		}
	}

	/**
	 * METHOD sets the owner of the tile if possible
	 * 
	 * @param p
	 *            the potential owner of the tile
	 * @return true if the ownership was successful, false otherwise
	 */
	public boolean setOwner(Player p) {
		if (ownable && owner == null) {
			this.owner = p;
			return true;
		} else {
			System.out.println("cannot own tile");
			return false;
		}
	}

	public Player getOwner() {
		return owner;
	}

	/**
	 * METHOD that applies a specific mule to a tile
	 * 
	 * @param m
	 *            is the mule being set on the tile
	 */
	public void setMule(Mule m) {
		mule = m;
	}

	public String getMuleId() {
		return muleId;
	}

	/**
	 * METHOD that gets the mule from the tile if there is one
	 * 
	 * @return type of mule on tile or null if no mule
	 */
	public Mule.Type getMuleType() {
		if (mule != null) {
			return mule.getType();
		} else {
			System.out.println("No mule on this tile.");
			return null;
		}
	}

	/**
	 * METHOD that gets the type of the tile
	 * 
	 * @return the type of the tile
	 */
	public Tile.Type getType() {
		return type;
	}

	/**
	 * METHOD gives the path to the border image of this tile's type
	 * 
	 * @return the path to the border image
	 */
	public URL getBorderPath() {
		if (this.owner == null) {
			return null;
		} else {
			return this.owner.getColor().getBorderImagePath();
		}
	}

	/**
	 * METHOD gives the path to the tile image of this tile's type
	 * 
	 * @return the path to the tile image
	 */
	public URL getImagePath() {
		return this.type.imgPath;
	}

	public String getOwnerId() {
		return ownerId;
	}

	@Override
	public int getPrice() {
		return this.type.getPrice();
	}

	@Override
	public String toJson() {
		JSONObject json = new JSONObject();

		if (owner != null) {
			json.put("playerId", owner.toString());
		} else {
			json.put("playerId", null);
		}

		if (mule != null) {
			json.put("muleId", mule.toString());
		} else {
			json.put("muleId", null);
		}

		json.put("type", type.toString());
		json.put("ownable", ownable);

		return json.toString();
	}

	@Override
	public Object fromJson(String jsonString) throws ParseException {
		JSONObject json = (JSONObject) new JSONParser().parse(jsonString);
		Tile tile = new Tile();

		tile.ownable = (Boolean) json.get("ownable");
		tile.ownerId = (String) json.get("playerId");
		tile.muleId = (String) json.get("muleId");

		for (Type t : Type.values()) {
			if (json.get("type").equals(t.toString())) {
				tile.type = t;
			}
		}

		return tile;
	}
}
