package model.cat;

import java.util.ArrayList;

// Represents wearable cat accessories
public class CatAccessory {
    private ArrayList<String> accessories;   // the current list of cat accessories

    // EFFECTS: creates a new list of cat accessories
    public CatAccessory() {
        accessories = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: if accessory is in accessories, returns false
    //          otherwise, adds it to accessories and returns true
    public boolean addCatAccessory(String accessory) {
        if (accessories.contains(accessory)) {
            return false;
        }

        accessories.add(accessory);
        return true;
    }

    // EFFECTS: if accessories is empty, returns an empty string
    //          if accessories is a size of one, returns just that accessory
    //          if accessories is a size of two or more, returns accessories in the form of a string
    public String getAllCatAccessories() {
        int count;
        String allAccessories = "";

        if (accessories.isEmpty()) {
            return allAccessories;
        }

        if (accessories.size() == 1) {
            return accessories.get(0);
        }

        for (count = 0; count < (accessories.size() - 1); count++) {
            allAccessories += accessories.get(count) + ", ";
        }

        allAccessories += "and " + accessories.get(count);
        return allAccessories;
    }

    // MODIFIES: this
    // EFFECTS: if accessory is in accessories, removes it and returns true
    //          otherwise, returns false
    public boolean removeCatAccessory(String accessory) {
        return accessories.remove(accessory);
    }

    // MODIFIES: this
    // EFFECTS: clears accessories
    public void removeAllCatAccessories() {
        accessories.clear();
    }

}
