package model;

import java.net.URL;
import java.awt.Point;
import java.util.ArrayList;

/**
 * CLASS Player. Holds the data for each player.
 *
 */
public class Player {
	/**
	 * ENUM for player color
	 */
	public static enum Color {
		RED("red", Player.class.getResource("/sprites/tiles/Border-Red.png"), Player.class.getResource("/sprites/players/PlayerRed.png")),
		YELLOW("yellow", Player.class.getResource("/sprites/tiles/Border-Yellow.png"),Player.class.getResource("/sprites/players/PlayerYellow.png") ),
		GREEN("green", Player.class.getResource("/sprites/tiles/Border-Green.png"), Player.class.getResource("/sprites/players/PlayerGreen.png")),
		PURPLE("purple", Player.class.getResource("/sprites/tiles/Border-Purple.png"), Player.class.getResource("/sprites/players/PlayerPurple.png") );

		private String name;
		private URL borderImagePath;
		private URL playerImagePath;
        private URL muleImagePath;

		Color(String name, URL borderImagePath, URL playerImagePath) {
			this.name = name;
			this.borderImagePath = borderImagePath;
			this.playerImagePath = playerImagePath;
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
	}

	/**
	 * ENUM for player race
	 */
	public static enum Race {
		BUZZITE("Buzzite"),
		UGAITE("Ugaite"),
		BONZIOD("Bonziod"),
		FLAPPER("Flapper"),
		HUMAN("Human");

		private String name;

		Race(String name) {
			this.name = name;
		}

		public String toString() {
			return name;
		}
	}

	private static int totalPlayers = 0;
	private static final Race[] races = {Race.HUMAN, Race.FLAPPER, Race.BONZIOD, Race.UGAITE, Race.BUZZITE};
	private static final Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.PURPLE};

	private int playerNum;
	private String name;
	private Color color;
	private Race race;
	private int money;
	private int energy, smithore, food, crystite;
	private ArrayList<Tile> playerTiles;
	private int score;
	private ArrayList<Mule> mules;
	private Mule holdingMule;
	private boolean inStore;

	private Point playerPos;

	/**
	 */
	public Player(int startingMoney) {
		totalPlayers ++;
		this.playerNum = totalPlayers;
		playerPos = new Point(396,180);

		// This is the standard starting set-up
		// TODO: Should change based on difficulty level
		this.money = startingMoney;
		this.food = 4;
		this.smithore = 0;
		this.energy = 2;
		this.crystite = 0;
		this.mules = new ArrayList<Mule>();
		this.holdingMule = null;
		this.score = startingMoney; //should use proper formula based on starting goods
		this.inStore = false;
	}
	
	public Mule getHoldingMule()
	{
		return holdingMule;
	}

	public void setInStore(boolean inStore)
	{
		this.inStore = inStore;
	}

	public boolean isInStore()
	{
		return inStore;
	}

	public boolean isHoldingMule()
	{
		return holdingMule != null;
	}

	public boolean outfitMule (Mule.Type type)
	{
		if (holdingMule != null)
		{
			holdingMule.setType(type);
			money -= type.getCost();
			System.out.println("" + type + " mule outfitted!");
			return true;
		}
		else
		{
			System.out.println("Player is not currently holding a mule!");
			return false;
		}
	}
	
	public boolean deOutfitMule (Mule.Type type)
	{
		if (holdingMule != null)
		{
			money += (int) (.8 * type.getCost());
			holdingMule.setType(null);
			System.out.println("" + type + " mule de-outfitted!");
			return true;
		}		
		else
		{
			System.out.println("Player is not currently holding a mule!");
			return false;
		}
	}

	public boolean placeMule()
	{
		if (holdingMule != null)
		{
			mules.add(holdingMule);
			holdingMule = null;
			return true; 
		}
		else
		{
			System.out.println("Player is not currently holding a mule!");
			return false;
		}
	}

	/**
	 * METHOD to get this player's position on the board
	 * @return this player's position.
	 */
	public Point getPlayerPos()
	{
		return this.playerPos;
	}

	/**
	 * Method to set the player's position
	 * @param p
	 */
	public void setPlayerPos(Point p)
	{
		this.playerPos = p;
	}

	public void resetPlayerPos()
	{
		this.playerPos = new Point(396,180);
	}

	/**
	 * Get this players money
	 * @ret	the money of the player
	 */
	public int getMoney() {
		return money;
	}

	public void addMoney(int m)
	{
		this.money += m;
	}

	/**
	 * Get the total number of players
	 * @return the total number of players
	 */
	public static int getTotalPlayers() {
		return totalPlayers;
	}

	/**
	 * Get this players number
	 * @return the players number
	 */
	public int getPlayerNum() {
		return playerNum;
	}

	/**
	 * Set this players name
	 * @param name what to make the players name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * METHOD Get this players name
	 * @return the players name
	 */
	public String getPlayerName() {
		return name;
	}

	/**
	 * METHOD Set this players color
	 * @param color what to make the players color
	 */
	public void setColor(int color) {
		this.color = colors[color];
	}

	/**
	 * METHODGet this players color
	 * @return	the color of the player
	 */
	public Color getColor() {
		return color;
	}


	/**
	 * METHOD Set this players race
	 * @param race what to make this players race
	 */
	public void setRace(int race) {
		this.race = races[race];
	}

	/**
	 * METHOD Get this players race
	 * @return	the race of the player
	 */
	public Race getRace() {
		return race;
	}

	/**
	 * METHOD Get this players energy
	 * @return	the energy of the player
	 */
	public int getEnergy() {
		return energy;
	}

	/**
	 * METHOD Get this players smithore
	 * @return	the smithore of the player
	 */
	public int getSmithore() {
		return smithore;
	}


	/**
	 * METHOD Get this players food
	 * @return	the food of the player
	 */
	public int getFood() {
		return food;
	}

	/**
	 * METHOD Get this players crystite
	 * @return	the crystite of the player
	 */
	public int getCrystite() {
		return crystite;
	}

	/**
	 * METHOD Get this players number of mules
	 * @return the number of mules of the player
	 */
	public int getNumMules() {
		return mules.size();
	}

	/**
	 * Purchases an item and handles the money exchange
	 *
	 * @param item the item to be purchased
	 */
	public boolean purchase(Purchasable item) {
		if (item.getPrice() <= money) {
			if (item instanceof Mule)
			{
				if (holdingMule == null)
				{
					money -= item.getPrice();
					holdingMule = new Mule(((Mule) item).getOwner());
					System.out.println("Player purchased a mule!");
					return true;
				}
				else
				{
					//System.out.println("Player has already purchased a mule!");
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


	public boolean sellHoldingMule()
	{
		if (holdingMule != null)
		{
			money += 80; //holdingMule.getPrice();
			holdingMule = null;
			System.out.println("Holding mule sold!");
			return true;
		}
		else
		{
			System.out.println("Can't sell mule!");
			return false;
		}
	}

	/**
	 * METHOD Update player position when key for upward movement is pressed.
	 */
	public void moveUp()
	{
		int x = (int)this.playerPos.getX();
		int y = (int)this.playerPos.getY();
		this.playerPos.setLocation(x, y-5);
	}

	/**
	 * METHOD Update player position when key for leftward movement is pressed.
	 */
	public void moveLeft()
	{
		int x = (int)this.playerPos.getX();
		int y = (int)this.playerPos.getY();
		this.playerPos.setLocation(x-5, y);
	}

	/**
	 * METHOD Update player position when key for downward movement is pressed.
	 */
	public void moveDown()
	{
		int x = (int)this.playerPos.getX();
		int y = (int)this.playerPos.getY();
		this.playerPos.setLocation(x, y+5);
	}

	/**
	 * METHOD Update player position when key for rightward movement is pressed.
	 */
	public void moveRight()
	{
		int x = (int)this.playerPos.getX();
		int y = (int)this.playerPos.getY();
		this.playerPos.setLocation(x+5, y);
	}

	/**
	 * METHOD Gives a String representation of the player
	 * @return a string describing the player's attributes
	 */
	public String toString() {
		return "Player " + playerNum + " is a " + color + " " + race + " named " + name + "\n" + "money: " + money +"\n" + "score: " + score;
	}

	/**
	 * METHOD Update player's score calculated by:
	 *  money + (500*land plots + mule value) + 35*mules + smithore*price + food*price + energy*price + crystite*price
	 *  see: http://bringerp.free.fr/RE/Mule/mule_document.html#ScoreComputing
	 */
	public void updateScore() {
		this.score = 0; //reset score
		//Add land score
		/*for(int i = 0;i<playerTiles.size();i++){
    		score+=500;
    		//TODO: This should be 500 per plot + the value of any mules set on plots
    		//e.g. - food:525, energy:550, smithore:575, crystite:600
    	}*/
		//Add money score
		this.score += money;
		//Add goods score
		// TODO: Needs to multiply goods by their current price
		//this.score += (mules.size() *35 + smithore*50 + food*30 + energy*25 + crystite*50);
	}

	/**
	 * METHOD Gets player's score calculated by:
	 *  money + (500*land plots + mule value) + 35*mules + smithore*price + food*price + energy*price + crystite*price 
	 * @return int score value
	 */
	public int getScore(){
		return score;
	}
}
