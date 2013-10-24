package model;

import java.net.URL;

public class Tile implements Purchasable
{

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

        public int getPrice() {
            return price;
        }
    }

    private Type type;
    private Player owner;
    private boolean ownable;

    /**
     * CONTRUCTOR for Tiles
     */
    public Tile(Type type)
    {
    	this.type = type;
        this.ownable = true;
    }

    /**
     * CONSTRUCTOR for specifying whether the tile is ownable
     * @param type the type of tile
     * @param ownable whether or not someone can purchase this tile
     */
    public Tile(Type type, boolean ownable) {
        this.type = type;
        this.ownable = ownable;
    }

    /**
     * METHOD allows a player to purchase a tile
     *
     * @param p the purchasing player
     * @return true if the transaction was successful, false otherwise
     */
    public boolean buy(Player p)
    {
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
     * @param p the potential owner of the tile
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

    /**
     * METHOD gives the path to the border image of this tile's type
     *
     * @return the path to the border image
     */
    public URL getBorderPath()
    {
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

    @Override
    public int getPrice() {
        return this.type.getPrice();
    }
}

	
	
