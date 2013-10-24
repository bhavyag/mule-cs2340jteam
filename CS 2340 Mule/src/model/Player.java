package model;

import java.util.ArrayList;

public class Player {
    /**
     * ENUM for player color
     */
    public static enum Color {
        RED("red"),
        YELLOW("yellow"),
        GREEN("green"),
        PURPLE("purple");

        private String name;

        Color(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
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
    private ArrayList<Tile> playerTiles;

    /**
     * CONSTRUCTOR for Players
     */
    public Player() {
        totalPlayers ++;
        this.playerNum = totalPlayers;
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
     * Set this players color
     * @param color what to make the players color
     */
    public void setColor(int color) {
        this.color = colors[color];
    }

    /**
     * Set this players race
     * @param race what to make this players race
     */
    public void setRace(int race) {
        this.race = races[race];
    }

    /**
     *
     * @return
     */
    public String toString() {
        return "Player " + playerNum + " is a " + color + " " + race + " named " + name;
    }
}