package model;

import org.json.simple.parser.ParseException;

/**
 * CLASS Map2 for the default map
 * 
 * @author Chris
 * 
 */
public class Map2 extends Board {

	/**
	 * CONSTRUCTOR that sets the map's map equal to a predefined 2d array of
	 * tiles.
	 */
	protected Map2() {
		this.map = new Tile[][] {
				{ new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
						new Tile(Tile.Type.PLAINS),
						new Tile(Tile.Type.MOUNTAINONE),
						new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
						new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
						new Tile(Tile.Type.MOUNTAINTHREE) },
				{ new Tile(Tile.Type.RIVER), new Tile(Tile.Type.RIVER),
						new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
						new Tile(Tile.Type.PLAINS),
						new Tile(Tile.Type.MOUNTAINONE),
						new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
						new Tile(Tile.Type.PLAINS) },
				{ new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.RIVER),
						new Tile(Tile.Type.RIVER), new Tile(Tile.Type.RIVER),
						new Tile(Tile.Type.TOWN, false),
						new Tile(Tile.Type.RIVER), new Tile(Tile.Type.RIVER),
						new Tile(Tile.Type.RIVER), new Tile(Tile.Type.PLAINS) },
				{ new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.MOUNTAINTWO),
						new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
						new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
						new Tile(Tile.Type.MOUNTAINTWO),
						new Tile(Tile.Type.RIVER), new Tile(Tile.Type.RIVER) },
				{ new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
						new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
						new Tile(Tile.Type.MOUNTAINONE),
						new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
						new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS) } };
	}

	/**
	 * METHOD to return a string representing this map
	 * 
	 * @return the string version of the map
	 */
	public String toString() {
		return "map 2";
	}
}
