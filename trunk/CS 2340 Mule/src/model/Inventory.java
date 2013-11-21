package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * CLASS INVENTORY holds purchasable items
 */
public class Inventory {
	private HashMap<String, ArrayList<Purchasable>> inventory;

	/**
	 * CONSTRUCTOR for initializing the inventory
	 */
	public Inventory() {
		this.inventory = new HashMap<String, ArrayList<Purchasable>>();
	}

	/**
	 * METHOD adds an item to the inventory
	 * 
	 * @param item
	 *            the item to be added to the inventory
	 */
	public void addItem(Purchasable item) {
		if (inventory.get(item.getClass().getName()) == null) {
			inventory.put(item.getClass().getName(),
					new ArrayList<Purchasable>());
		}

		inventory.get(item.getClass().getName()).add(item);
	}

	/**
	 * METHOD gets a list of items of a certain type
	 * 
	 * @param className
	 *            the name of the class that the requested items are instances
	 *            of
	 * @return the requested items, null if none are available
	 */
	public ArrayList<Purchasable> getItems(String className) {
		return inventory.get(className);
	}
}
