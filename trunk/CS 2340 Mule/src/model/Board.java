package model;

import util.Shared.Color;

/**
 * ABSTRACT CLASS BOARD holds the methods all boards will use, all boards have a 2d array of tiles.
 * @author Chris
 *
 */
public abstract class Board
{
    protected Tile[][] map;

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

    public void setOwner(Player p, int x, int y) {
        map[x][y].setOwner(p);
    }

    public Color getTileColor(int x, int y) {
        return map[x][y].getTileColor();
    }
}
