package model.addons;

import java.util.ArrayList;

// Represents accessories currently worn by a cat
public class Accessory {
    private ArrayList<String> accessories;   // the current list of accessories worn by a cat

    // EFFECTS: creates a new list of accessories
    public Accessory() {
        accessories = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: if accessory is in accessories, returns false
    //          otherwise, adds it to accessories and returns true
    public boolean addAccessory(String accessory) {
        if (accessories.contains(accessory)) {
            return false;
        }

        accessories.add(accessory);
        return true;
    }

    // EFFECTS: if accessories is empty, returns an empty string
    //          if accessories is a size of one, returns just that accessory
    //          if accessories is a size of two or more, returns accessories in the form of a string
    public String getAllAccessories() {
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
    public boolean removeAccessory(String accessory) {
        return accessories.remove(accessory);
    }

    // MODIFIES: this
    // EFFECTS: clears accessories
    public void removeAccessories() {
        accessories.clear();
    }

}
