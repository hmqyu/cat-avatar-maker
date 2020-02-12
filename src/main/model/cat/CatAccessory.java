package model.cat;

import java.util.ArrayList;

public class CatAccessory {
    private ArrayList<String> accessories;

    public CatAccessory() {
        accessories = new ArrayList<>();
    }

    public boolean addCatAccessory(String accessory) {
        if (accessories.contains(accessory)) {
            return false;
        }

        accessories.add(accessory);
        return true;
    }

    public String getAllCatAccessories() {
        int count;
        String allAccessories = "";

        if (accessories.size() == 0) {
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

    public boolean removeCatAccessory(String accessory) {
        return accessories.remove(accessory);
    }

    public void removeAllCatAccessories() {
        accessories = new ArrayList<>();
    }

}
