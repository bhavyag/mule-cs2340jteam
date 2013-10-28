package model;

import java.net.URL;
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
        RED("red", Player.class.getResource("/sprites/tiles/Border-Red.png")),
        YELLOW("yellow", Player.class.getResource("/sprites/tiles/Border-Yellow.png")),
        GREEN("green", Player.class.getResource("/sprites/tiles/Border-Green.png")),
        PURPLE("purple", Player.class.getResource("/sprites/tiles/Border-Purple.png"));

        private String name;
        private URL borderImagePath;

        Color(String name, URL borderImagePath) {
            this.name = name;
            this.borderImagePath = borderImagePath;
        }

        public String toString() {
            return name;
        }

        public URL getBorderImagePath() {
            return borderImagePath;
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

    /**
     * CONSTRUCTOR for Players
     */
    public Player(int startingMoney) {
        totalPlayers ++;
        this.playerNum = totalPlayers;

        this.money = startingMoney;
    }

    /**
     * Get this players money
     * @ret	the money of the player
     */
    public int getMoney() {
        return money;
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
     * Get this players name
     * @return the players name
     */
    public String getPlayerName() {
        return name;
    }

    /**
     * Set this players color
     * @param color what to make the players color
     */
    public void setColor(int color) {
        this.color = colors[color];
    }

    /**
     * Get this players color
     * @ret	the color of the player
     */
    public String getColor() {
        return color.toString();
    }


    /**
     * Set this players race
     * @param race what to make this players race
     */
    public void setRace(int race) {
        this.race = races[race];
    }
    
    /**
     * Get this players race
     * @ret	the race of the player
     */
    public String getRace() {
        return race.toString();
    }
  
    /**
     * Get this players energy
     * @ret	the energy of the player
     */
    public int getEnergy() {
        return energy;
    }
    
    /**
     * Get this players smithore
     * @ret	the smithore of the player
     */
    public int getSmithore() {
        return smithore;
    }
    
    
    /**
     * Get this players food
     * @ret	the food of the player
     */
    public int getFood() {
        return food;
    }
    
    /**
     * Get this players crystite
     * @ret	the crystite of the player
     */
    public int getCrystite() {
        return crystite;
    }
    /**
     * Purchases an item and handles the money exchange
     *
     * @param item the item to be purchased
     */
    public boolean purchase(Purchasable item) {
        if (item.getPrice() <= money) {
            money -= item.getPrice();
            return true;
        } else {
            System.out.println("Not enough money");
            return false;
        }
    }

    /**
     * Gives a String representation of the player
     * @return a string describing the player's attributes
     */
    public String toString() {
        return "Player " + playerNum + " is a " + color + " " + race + " named " + name + "\n" + "money: " + money;
    }
}
