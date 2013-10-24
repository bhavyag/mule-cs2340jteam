package model;

import java.net.URL;

public class Tile
{
    /**
     * ENUM for Tile type
     */
    public static enum Type {
        MOUNTAINONE("mountain 1", Tile.class.getResource("/sprites/tiles/Mountain-Tile.png")),
        MOUNTAINTWO("mountain 2", Tile.class.getResource("/sprites/tiles/Mountain-2-Tile.png")),
        MOUNTAINTHREE("mountain 3", Tile.class.getResource("/sprites/tiles/Mountain-3-Tile.png")),
        PLAINS("plains", Tile.class.getResource("/sprites/tiles/Plains-Tile.png")),
        RIVER("river", Tile.class.getResource("/sprites/tiles/River-Tile.png")),
        TOWN("town", Tile.class.getResource("/sprites/tiles/Town-Center-Tile.png"));

        private String type;
        private URL imgPath;

        Type(String myType, URL imgPath) {
            this.type = myType;
            this.imgPath = imgPath;
        }

        public String toString() {
            return type;
        }

        public URL getImgPath() {
            return imgPath;
        }
    }

    private Type type;
    private Player owner;

    /**
     * CONTRUCTOR for Tiles
     */
    public Tile(Type type)
    {
    	this.type = type;
    }

    public void setOwner(Player p)
    {
    	this.owner = p;
    }

    public Player getOwner()
    {
    	return owner;
    }
}
