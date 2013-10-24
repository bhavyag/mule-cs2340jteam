package model;

public abstract class Board
{
    protected Tile[][] map = new Tile[9][5];

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
}
