package model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.URL;
import java.awt.Point;
import java.util.ArrayList;

/**
 * CLASS Player. Holds the data for each player.
 * 
 */
public class Player implements Savable {

	private static int totalPlayers = 0;
	private static final Race[] races = { Race.HUMAN, Race.FLAPPER,
			Race.BONZOID, Race.UGAITE, Race.BUZZITE };
	private static final Color[] colors = { Color.RED, Color.YELLOW,
			Color.GREEN, Color.PURPLE };

	private int playerNum;
	private String name;
	private Color color;
	private Race race;
	private int money;
	private int energy, smithore, food, crystite;
	private int score;
	private ArrayList<Mule> mules;
	private Mule holdingMule;
	private boolean inStore;
	private boolean facingRight;
	private Point playerPos;

	/**
	 * ENUM for player color
	 */
	public static enum Color {
		RED(
				"red",
				Player.class.getResource("/sprites/tiles/Border-Red.png"),
				Player.class.getResource("/sprites/players/PlayerRed.png"),
				Player.class
						.getResource("/sprites/mule/player-with-mule-RED.png"),
				Player.class
						.getResource("/sprites/mule/player-with-mule-RED-FLIPPED.png")), YELLOW(
				"yellow",
				Player.class.getResource("/sprites/tiles/Border-Yellow.png"),
				Player.class.getResource("/sprites/players/PlayerYellow.png"),
				Player.class
						.getResource("/sprites/mule/player-with-mule-YELLOW.png"),
				Player.class
						.getResource("/sprites/mule/player-with-mule-YELLOW-FLIPPED.png")

		), GREEN(
				"green",
				Player.class.getResource("/sprites/tiles/Border-Green.png"),
				Player.class.getResource("/sprites/players/PlayerGreen.png"),
				Player.class
						.getResource("/sprites/mule/player-with-mule-GREEN.png"),
				Player.class
						.getResource("/sprites/mule/player-with-mule-GREEN-FLIPPED.png")

		), PURPLE(
				"purple",
				Player.class.getResource("/sprites/tiles/Border-Purple.png"),
				Player.class.getResource("/sprites/players/PlayerPurple.png"),
				Player.class
						.getResource("/sprites/mule/player-with-mule-PURPLE.png"),
				Player.class
						.getResource("/sprites/mule/player-with-mule-PURPLE-FLIPPED.png"));

		private String name;
		private URL borderImagePath;
		private URL playerImagePath;
		private URL muleImagePath;
		private URL flippedMuleImagePath;

		Color(String name, URL borderImagePath, URL playerImagePath,
				URL muleImagePath, URL flippedMuleImagePath) {
			this.name = name;
			this.borderImagePath = borderImagePath;
			this.playerImagePath = playerImagePath;
			this.muleImagePath = muleImagePath;
			this.flippedMuleImagePath = flippedMuleImagePath;
		}

		public String toString() {
			return name;
		}

		public URL getBorderImagePath() {
			return borderImagePath;
		}

		public URL getPlayerImagePath() {
			return playerImagePath;
		}

		public URL getMuleImagePath() {
			return muleImagePath;
		}

		public URL getFlippedMuleImagePath() {
			return flippedMuleImagePath;
		}
	}

	/**
	 * ENUM for player race
	 */
	public static enum Race {
		BUZZITE("Buzzite"), UGAITE("Ugaite"), BONZOID("Bonzoid"), FLAPPER(
				"Flapper"), HUMAN("Human");

		private String name;

		Race(String name) {
			this.name = name;
		}

		public String toString() {
			return name;
		}
	}

	public Player() {
	}

	/**
	 */
	public Player(int startingMoney) {
		totalPlayers++;
		this.playerNum = totalPlayers;
		playerPos = new Point(396, 180);

		// This is the standard starting set-up
		// TODO: Should change based on difficulty level
		this.money = startingMoney;
		this.food = 2;
		this.smithore = 1;
		this.energy = 2;
		this.crystite = 0;
		this.mules = new ArrayList<Mule>();
		this.holdingMule = null;
		this.score = startingMoney; // should use proper formula based on
									// starting goods
		this.inStore = false;
		this.facingRight = true;
	}

	public Mule getHoldingMule() {
		return holdingMule;
	}

	public void setInStore(boolean inStore) {
		this.inStore = inStore;
	}

	public boolean isInStore() {
		return inStore;
	}

	public boolean isHoldingMule() {
		return holdingMule != null;
	}

	public boolean outfitMule(Mule.Type type) {
		if (holdingMule != null) {
			holdingMule.setType(type);
			money -= type.getCost();
			System.out.println("" + type + " mule outfitted!");
			return true;
		} else {
			System.out.println("Player is not currently holding a mule!");
			return false;
		}
	}

	public boolean deOutfitMule(Mule.Type type) {
		if (holdingMule != null) {
			money += (int) (.8 * type.getCost());
			holdingMule.setType(null);
			System.out.println("" + type + " mule de-outfitted!");
			return true;
		} else {
			System.out.println("Player is not currently holding a mule!");
			return false;
		}
	}

	public void addMule(Mule m) {
		mules.add(m);
	}

	public boolean placeMule(Tile tile) {
		if (holdingMule != null) {
			mules.add(holdingMule);
			tile.setMule(holdingMule);
			holdingMule = null;
			return true;
		} else {
			System.out.println("Player is not currently holding a mule!");
			return false;
		}
	}

	public URL getImagePath() {
		return this.holdingMule == null ? this.color.getPlayerImagePath()
				: this.facingRight ? this.color.getFlippedMuleImagePath()
						: this.color.getMuleImagePath();
	}

	/**
	 * METHOD to get this player's position on the board
	 * 
	 * @return this player's position.
	 */
	public Point getPlayerPos() {
		return this.playerPos;
	}

	/**
	 * Method to set the player's position
	 * 
	 * @param p
	 */
	public void setPlayerPos(Point p) {
		this.playerPos = p;
	}

	public void resetPlayerPos() {
		this.playerPos = new Point(396, 180);
	}

	/**
	 * Get this players money
	 * 
	 * @ret the money of the player
	 */
	public int getMoney() {
		return money;
	}

	public void incrementMoney(int m) {
		this.money += m;
	}

	/**
	 * Get the total number of players
	 * 
	 * @return the total number of players
	 */
	public static int getTotalPlayers() {
		return totalPlayers;
	}

	/**
	 * Get this players number
	 * 
	 * @return the players number
	 */
	public int getPlayerNum() {
		return playerNum;
	}

	/**
	 * Set this players name
	 * 
	 * @param name
	 *            what to make the players name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * METHOD Get this players name
	 * 
	 * @return the players name
	 */
	public String getPlayerName() {
		return name;
	}

	/**
	 * METHOD Set this players color
	 * 
	 * @param color
	 *            what to make the players color
	 */
	public void setColor(int color) {
		this.color = colors[color];
	}

	/**
	 * METHODGet this players color
	 * 
	 * @return the color of the player
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * METHOD Set this players race
	 * 
	 * @param race
	 *            what to make this players race
	 */
	public void setRace(int race) {
		this.race = races[race];
	}

	/**
	 * METHOD Get this players race
	 * 
	 * @return the race of the player
	 */
	public Race getRace() {
		return race;
	}

	/**
	 * METHOD Get this players energy
	 * 
	 * @return the energy of the player
	 */
	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int i) {
		if (i < 0) {
			this.energy = 0;
			return;
		}
		this.energy = i;
	}

	/**
	 * METHOD Get this players smithore
	 * 
	 * @return the smithore of the player
	 */
	public int getSmithore() {
		return smithore;
	}

	public void setSmithore(int i) {
		if (i < 0) {
			this.smithore = 0;
			return;
		}
		this.smithore = i;
	}

	/**
	 * METHOD Get this players food
	 * 
	 * @return the food of the player
	 */
	public int getFood() {
		return food;
	}

	public void setFood(int i) {
		if (i < 0) {
			this.food = 0;
			return;
		}
		this.food = i;
	}

	/**
	 * METHOD Get this players crystite
	 * 
	 * @return the crystite of the player
	 */
	public int getCrystite() {
		return crystite;
	}

	/**
	 * METHOD Set this players food
	 * 
	 * @param food
	 *            the food of the player
	 */
	public void incrementFood(int food) {
		if (this.food + food < 0) {
			this.food = 0;
			return;
		}
		this.food += food;
	}

	/**
	 * METHOD Set this players energy
	 * 
	 * @param energy
	 *            the energy of the player
	 */
	public void incrementEnergy(int energy) {
		if (this.energy + energy < 0) {
			this.energy = 0;
			return;
		}
		this.energy += energy;
	}

	/**
	 * METHOD Set this players smithore
	 * 
	 * @param smithore
	 *            the smithore of the player
	 */
	public void incrementSmithore(int smithore) {
		if (this.smithore + smithore < 0) {
			this.smithore = 0;
			return;
		}
		this.smithore += smithore;
	}

	/**
	 * METHOD Set this players crystite
	 * 
	 * @param crystite
	 *            the crystite of the player
	 */
	public void incrementCrystite(int crystite) {
		if (this.crystite + crystite < 0) {
			this.crystite = 0;
			return;
		}
		this.crystite += crystite;

	}

	public void setCrystite(int i) {
		if (i < 0) {
			this.crystite = 0;
			return;
		}
		this.crystite = i;
	}

	/**
	 * METHOD Get this players number of mules
	 * 
	 * @return the number of mules of the player
	 */
	public int getNumMules() {
		return mules.size();
	}

	/**
	 * Purchases an item and handles the money exchange
	 * 
	 * @param item
	 *            the item to be purchased
	 */
	public boolean purchase(Purchasable item) {
		if (item.getPrice() <= money) {
			if (item instanceof Mule) {
				if (holdingMule == null) {
					money -= item.getPrice();
					holdingMule = new Mule(((Mule) item).getOwner());
					System.out.println("Player purchased a mule!");
					return true;
				} else {
					// System.out.println("Player has already purchased a mule!");
					return false;
				}
			}

			money -= item.getPrice();

		} else {
			System.out.println("Not enough money");
			return false;
		}
		return false;
	}

	public boolean sellHoldingMule() {
		if (holdingMule != null) {
			money += 80; // holdingMule.getPrice();
			holdingMule = null;
			System.out.println("Holding mule sold!");
			return true;
		} else {
			System.out.println("Can't sell mule!");
			return false;
		}
	}

	/**
	 * METHOD Update player position when key for upward movement is pressed.
	 */
	public void moveUp() {
		if (this.playerPos.y > 0) {
			int x = (int) this.playerPos.getX();
			int y = (int) this.playerPos.getY();
			this.playerPos.setLocation(x, y - 5);
		}
	}

	/**
	 * METHOD Update player position when key for leftward movement is pressed.
	 */
	public void moveLeft() {
		if (this.playerPos.x - 5 > 0) {
			this.facingRight = false;
			int x = (int) this.playerPos.getX();
			int y = (int) this.playerPos.getY();
			this.playerPos.setLocation(x - 5, y);
		}
	}

	/**
	 * METHOD Update player position when key for downward movement is pressed.
	 */
	public void moveDown() {
		if (this.playerPos.y < 349) {
			int x = (int) this.playerPos.getX();
			int y = (int) this.playerPos.getY();
			this.playerPos.setLocation(x, y + 5);
		}
	}

	/**
	 * METHOD Update player position when key for rightward movement is pressed.
	 */
	public void moveRight() {
		if (this.playerPos.x < 781) {
			this.facingRight = true;
			int x = (int) this.playerPos.getX();
			int y = (int) this.playerPos.getY();
			this.playerPos.setLocation(x + 5, y);
		}
	}

	/**
	 * METHOD Gives a String representation of the player
	 * 
	 * @return a string describing the player's attributes
	 */
	public String toString() {
		return "" + color + race + name;
	}

	/**
	 * METHOD Update player's score calculated by: money + (500*land plots +
	 * mule value) + 35*mules + smithore*price + food*price + energy*price +
	 * crystite*price see:
	 * http://bringerp.free.fr/RE/Mule/mule_document.html#ScoreComputing
	 */
	public void updateScore() {
		score = 0; // reset score
		// Add land score
		/*
		 * for(int i = 0;i<playerTiles.size();i++){
		 * 
		 * if(playerTiles.get(i).getMuleType()!=null) {
		 * if(playerTiles.get(i).getMuleType()==Mule.Type.FOOD) { score+=525; }
		 * else if(playerTiles.get(i).getMuleType()==Mule.Type.ENERGY) {
		 * score+=550; } else
		 * if(playerTiles.get(i).getMuleType()==Mule.Type.SMITHORE) {
		 * score+=575; } else
		 * if(playerTiles.get(i).getMuleType()==Mule.Type.FOOD) { score+=600; }
		 * } else { score+=500; }
		 * 
		 * }
		 */
		// Add money score
		score += money;
		// Add goods score
		// TODO: Needs to multiply goods by their current price
		score += (mules.size() *35 + smithore*50 + food*30 + energy*25 + crystite*50);
	}

	/**
	 * METHOD Gets player's score calculated by: money + (500*land plots + mule
	 * value) + 35*mules + smithore*price + food*price + energy*price +
	 * crystite*price
	 * 
	 * @return int score value
	 */
	public int getScore() {
		return score;
	}

	@Override
	public String toJson() {
		JSONObject json = new JSONObject();

		json.put("playerNum", new Integer(playerNum));
		json.put("name", name);
		json.put("color", color.toString());
		json.put("race", race.toString());
		json.put("energy", new Integer(playerNum));
		json.put("food", new Integer(food));
		json.put("crystite", new Integer(crystite));
		json.put("money", new Integer(money));
		json.put("smithore", new Integer(smithore));
		json.put("score", new Integer(food));
		json.put("id", this.toString());

		return json.toString();
	}

	public ArrayList<Mule> getMules() {
		return mules;
	}

	@Override
	public Object fromJson(String jsonStr) throws ParseException {
		JSONObject json = (JSONObject) new JSONParser().parse(jsonStr);
		Player player = new Player();

		player.playerNum = ((Long) json.get("playerNum")).intValue();
		player.name = (String) json.get("name");
		player.energy = ((Long) json.get("energy")).intValue();
		player.food = ((Long) json.get("food")).intValue();
		player.crystite = ((Long) json.get("crystite")).intValue();
		player.money = ((Long) json.get("money")).intValue();
		player.score = ((Long) json.get("score")).intValue();
		player.score = ((Long) json.get("smithore")).intValue();

		for (Color c : Color.values()) {
			if (json.get("color").equals(c.toString())) {
				player.color = c;
			}
		}

		for (Race r : Race.values()) {
			if (json.get("race").equals(r.toString())) {
				player.race = r;
			}
		}

		player.mules = new ArrayList<Mule>();
		player.playerPos = new Point(396, 180);
		player.inStore = false;
		player.facingRight = true;

		return player;
	}

}
