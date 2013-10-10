package model;

public class Player {
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

    public Player() {
        totalPlayers ++;
        this.playerNum = totalPlayers;
    }

    public static int getTotalPlayers() {
        return totalPlayers;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(int color) {
        this.color = colors[color];
    }

    public void setRace(int race) {
        this.race = races[race];
    }

    public String toString() {
        return "Player " + playerNum + " is a " + color + " " + race + " named " + name;
    }
}
