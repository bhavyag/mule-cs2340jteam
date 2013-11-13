package model;

import java.awt.*;
import java.net.URL;

/**
 * ABSTRACT CLASS BOARD holds the methods all boards will use, all boards have a 2d array of tiles.
 * @author Chris
 *
 */
public abstract class Board
{
    public Tile[][] map;

    /**
     * METHOD get this boards map
     * @return this boards map
     */
    public Tile[][] getMap()
    {
        return this.map;
    }

    /**
     * METHOD toString
     * @return the name of this boards map.
     */
    public abstract String toString();

    /**
     * Sets the owner of the tile, if possible
     *
     * @param p the player attempting to own the tile
     * @param point the coordinates of the tile
     * @return whether or not the ownership was successful
     */
    public boolean setOwner(Player p, Point point) {
        return map[(int)point.getX()][(int)point.getY()].setOwner(p);
    }

    /**
     * METHOD Gets the owner of a tile based on its x and y coordinates in the grid
     * @param x is the x coordinate of the tile
     * @param y is the y coordinate of the tile
     * @return the Player that owns the tile
     */
    public Player getOwnerXY(int x,int y){
    	if(map[x][y].getOwner()!=null)
    	{
    		return map[x][y].getOwner();
    	} 
    	else
    	{
    		System.out.println("Tile does not have owner.");
    		return null;
    	}
    }
    
    /**
     * METHOD get mule type of mule on tile based on x and y coordinates of tile
     * @param x coordinate
     * @param y coordinate
     * @return mule type for mule on tile or null if no mule
     */
    public Mule.Type getMuleTypeXY(int x,int y){
    	if(map[x][y].getMuleType()!=null)
    	{
    		return map[x][y].getMuleType();
    	} 
    	else
    	{
    		return null;
    	}
    }
    
    /**
     * METHOD to get get type of tile based on x and y coordinates
     * @param x coordinate
     * @param y coordinate
     * @return the type of the tile
     */
    public Tile.Type getTypeXY(int x,int y){
    	return map[x][y].getType();
    }
    
    /**
     * Allows a player to purchase a tile
     *
     * @param p the player attempting to purchase the tile
     * @param point the coordinates of the tile
     * @return whether or not the purchase was successful
     */
    public boolean purchaseTile(Player p, Point point) {
        return map[(int)point.getX()][(int)point.getY()].buy(p);
    }

    public URL getTileBorderPath(Point point) {
        return map[(int)point.getX()][(int)point.getY()].getBorderPath();
    }
}
