package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, ArrayList<Purchasable>> inventory;

    public Inventory() {
        this.inventory = new HashMap<String, ArrayList<Purchasable>>();
    }

    public void addItem(Purchasable item) {
        if (inventory.get(item.getClass().getName()) == null) {
            inventory.put(item.getClass().getName(), new ArrayList<Purchasable>());
        }

        inventory.get(item.getClass().getName()).add(item);
    }

    public ArrayList<Purchasable> getItems(String className) {
        return inventory.get(className);
    }
}
