/**
 * Created with IntelliJ IDEA.
 * User: craigrmccown
 * Date: 10/7/13
 * Time: 8:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    public static enum Color {
        RED, YELLOW, GREEN, PURPLE
    }
    public static enum Race {
        BUZZITE, UGAITE, BONZIOD, FLAPPER, HUMAN
    }

    private static int totalPlayers = 0;
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

    public void setColor(Color color) {
        this.color = color;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
