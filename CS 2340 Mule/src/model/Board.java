package model;

import model.Tile.Type;

public abstract class Board
{
    private Tile[][] map = new Tile[9][5];

//    private final String[][] map1 = {{"P","P", "M1","P", "R","P", "M3","P","P"},
//    								 {"P", "M1","P","P", "R","P","P","P", "M3"},
//							    	 {"M3","P","P","P", "T","P","P","P", "M1"},
//							    	 {"P", "M2","P","P", "R","P", "M2","P","P"},
//							    	 {"P","P", "M2","P", "R","P","P","P", "M2"}
//    								};
//
//    private final String[][] map2 = {{"P","P", "P","M1", "P","P", "P","P","M3"},
//			 						 {"R", "R","P","P", "P","M1","P","P", "P"},
//							    	 {"P","R","R","R", "T","R","R","R", "P"},
//							    	 {"P", "M2","P","P", "P","P", "M2","R","R"},
//							    	 {"P","P", "P","P", "M1","P","P","P", "P"}
//									};
    
//    private void initializeMap(String[][] map) {
//    	for (int x = 0; x < map.length; x++) {
//    		for (int y = 0; y < map[x].length; y++) {
//
//    			switch(map[x][y])
//    			{
//    			case "P":
//    				myMap[x][y] = new Tile(Type.PLAINS);
//    				break;
//    			case "R":
//    				myMap[x][y] = new Tile(Type.RIVER);
//    				break;
//    			case "M1":
//    				myMap[x][y] = new Tile(Type.MOUNTAINONE);
//    				break;
//    			case "M2":
//    				myMap[x][y] = new Tile(Type.MOUNTAINTWO);
//    				break;
//    			case "M3":
//    				myMap[x][y] = new Tile(Type.MOUNTAINTHREE);
//    				break;
//    			case "T":
//    				myMap[x][y] = new Tile(Type.TOWN);
//    				break;
//    			}
//    		}
//    	}
//    }

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
