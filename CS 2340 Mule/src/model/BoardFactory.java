package model;

/**
 * CLASS BOARDFACTORY. A Factory build pattern for all boards.
 * 
 * @author Chris
 * 
 */
public class BoardFactory {
	/**
	 * METHOD to create the correct board based on the number of the board
	 * input.
	 * 
	 * @param boardType
	 *            an int representing the map to be created
	 * @return the Board created based on its number.
	 */
	public static Board constructBoard(int boardType) {
		switch (boardType) {
		case 0:
			return new Map1();
		case 1:
			return new Map2();
		default:
			return null;
		}
	}
}
