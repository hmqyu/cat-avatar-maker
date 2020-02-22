package model.cat;

import persistence.SaveData;

import java.io.PrintWriter;
import java.util.ArrayList;

// Represents a collection of cats that have been made
public class CatCollection implements SaveData {
    ArrayList<Cat> collection;

    // EFFECTS: creates a collection to store cat information
    public CatCollection() {
        collection = new ArrayList<>();
    }

    public CatCollection(ArrayList<Cat> collection) {
        this.collection = collection;
    }

    // MODIFIES: this
    // EFFECTS: adds cat to collection
    public void addToCollection(Cat cat) {
        collection.add(cat);
    }

    // EFFECTS: returns the number of items in collection
    public int numOfItems() {
        return collection.size();
    }

    // REQUIRES: num < collection.size()
    // EFFECTS: returns cat at given index in collection
    public Cat getCatFromCollection(int num) {
        return collection.get(num);
    }

    // EFFECTS: returns collection
    public ArrayList<Cat> getCollection() {
        return collection;
    }

    @Override
    public void save(PrintWriter printWriter) {
        for (Cat cat : collection) {
            cat.save(printWriter);
        }
    }
}
