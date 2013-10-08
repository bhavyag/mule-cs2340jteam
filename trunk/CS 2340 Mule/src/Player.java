/**
 * Created with IntelliJ IDEA.
 * User: craigrmccown
 * Date: 10/7/13
 * Time: 8:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private String name;
    private Color color;
    private Race race;

    public static enum Color {
        RED, YELLOW, GREEN, PURPLE
    }
    public static enum Race {
        BUZZITE, UGAITE, BONZIOD, FLAPPER, HUMAN
    }

    public Player(String name, Color color, Race race) {
        this.name = name;
        this.color = color;
        this.race = race;
    }
}
