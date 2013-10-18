package model;

public class Board
{
    private Tile[][] myMap;
    private String mapName;
    private final Tile[][] map1 = new Tile[9][5];
    private final Tile[][] map2 = new Tile[9][5];

    /**
     * CONSTRUCTOR for a Board
     * @param boardType an int representing the map that the board holds
     */
    public Board(int boardType)
    {
        switch(boardType)
        {
            case 0:
                this.myMap = map1;
                this.mapName = "map 1";
                break;
            case 1:
                this.myMap = map2;
                this.mapName = "map 2";
                break;
            default:
                this.myMap = map1;
                this.mapName = "map 1";
        }
    }

    /**
     * METHOD toString
     * @return the name of this boards map.
     */
    public String toString()
    {
        return this.mapName;
    }
}
