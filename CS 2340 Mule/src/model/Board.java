package model;

import util.Shared.Color;

import java.awt.*;
import java.net.URL;

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

    public boolean setOwner(Player p, Point point) {
        return map[(int)point.getX()][(int)point.getY()].setOwner(p);
    }

    public boolean purchaseTile(Player p, Point point) {
        return map[(int)point.getX()][(int)point.getY()].buy(p);
    }

    public URL getTileBorderPath(Point point) {
        return map[(int)point.getX()][(int)point.getY()].getBorderPath();
    }
}
