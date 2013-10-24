package model;

import java.net.URL;

/**
 * CLASS Tile. For representing the data of each tile on the map.
 * @author Chris
 *
 */
public class Tile
{
	/**
	 * ENUM for the tile's border color.
	 * @author Chris
	 *
	 */
	public static enum TileColor {
        RED("red",Tile.class.getResource("/sprites/tiles/Border-Red.png")),
        YELLOW("yellow",Tile.class.getResource("/sprites/tiles/Border-Yellow.png")),
        GREEN("green",Tile.class.getResource("/sprites/tiles/Border-Green.png")),
        PURPLE("purple",Tile.class.getResource("/sprites/tiles/Border-Purple.png")),
        DEFAULT("default",Tile.class.getResource("/sprites/tiles/Border-Default.png"));

        private String tileColor;
        private URL borderPath;

        TileColor(String tileColor,URL url) {
            this.tileColor = tileColor;
            this.borderPath = url;
        }

        public String toString() {
            return tileColor;
        }
        
        public URL getBorderPath() {
            return borderPath;
        }  
	}
        
    /**
     * ENUM for Tile type
     */
    public static enum Type {
        MOUNTAINONE("mountain 1", Tile.class.getResource("/sprites/tiles/Mountain-Tile.png"), 10),
        MOUNTAINTWO("mountain 2", Tile.class.getResource("/sprites/tiles/Mountain-2-Tile.png"), 10),
        MOUNTAINTHREE("mountain 3", Tile.class.getResource("/sprites/tiles/Mountain-3-Tile.png"), 10),
        PLAINS("plains", Tile.class.getResource("/sprites/tiles/Plains-Tile.png"), 10),
        RIVER("river", Tile.class.getResource("/sprites/tiles/River-Tile.png"), 10),
        TOWN("town", Tile.class.getResource("/sprites/tiles/Town-Center-Tile.png"), 10);

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

        public URL getImgPath() {
            return imgPath;
        }

        public int getPrice() {
            return price;
        }
    }

    private TileColor tileColor;
    private Type type;
    private Player owner;

    /**
     * CONTRUCTOR for Tiles
     */
    public Tile(Type type)
    {
    	this.type = type;
    	this.tileColor = TileColor.DEFAULT;
    }

    /**
     * METHOD to set the owner of the tile to the player passed in
     * @param p the new owner
     */
    public void setOwner(Player p)
    {
    	this.owner = p;
    }

    /**
     * METHOD to get the owner of this tile
     * @return the owner of this tile
     */
    public Player getOwner()
    {
    	return owner;
    }

    /**
     * METHOD to tell whether the tile is owned or not
     * @return boolean of whether the tile is owned by a player.
     */
    public boolean isOwned() {
        return owner == null;
    }
    
    /**
     * METHOD to get the type of this tile
     * @return the type of this tile
     */
    public Type getType()
    {
    	return this.type;
    }
    
    /**
     * METHOD to get this tile's border color
     * @return this tile's border color
     */
    public TileColor getTileColor()
    {
    	return this.tileColor;
    }
    
    /**
     * METHOD to set this tile's border color
     * @param tileColor this tile's new border color
     */
    public void setTileColor(TileColor tileColor)
    {
    	this.tileColor = tileColor;
    }
}

	
	
