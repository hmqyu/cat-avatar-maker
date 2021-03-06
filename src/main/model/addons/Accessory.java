package model.addons;

import java.util.ArrayList;
import java.util.List;

// Represents accessories currently worn by a cat
public class Accessory {
    private List<String> accessories;   // the current list of accessories worn by a cat

    // EFFECTS: creates a new list of accessories
    public Accessory() {
        accessories = new ArrayList<>();
    }

    // EFFECTS: creates a list of accessories from accessories
    //          if accessories is empty or has "", a new list of accessories is created
    public Accessory(ArrayList<String> accessories) {
        if (accessories.isEmpty()) {
            this.accessories = new ArrayList<>();
        } else if (accessories.get(0).equals("")) {
            this.accessories = new ArrayList<>();
        } else {
            this.accessories = accessories;
        }
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

    // EFFECTS: returns accessories
    public List<String> getAllAccessories() {
        return accessories;
    }

    // MODIFIES: this
    // EFFECTS: if accessory is in accessories, removes it and returns true
    //          otherwise, returns false
    public boolean removeAccessory(String accessory) {
        return accessories.remove(accessory);
    }

    // MODIFIES: this
    // EFFECTS: clears accessories
    public void removeAllAccessories() {
        accessories.clear();
    }

}
