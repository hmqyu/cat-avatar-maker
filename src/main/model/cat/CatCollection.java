package model.cat;

import persistence.SaveData;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Represents a collection of cats that have been saved
public class CatCollection implements SaveData {
    private List<Cat> collection;   // a list of cats that have been saved

    // EFFECTS: creates a collection to store cat information
    public CatCollection() {
        collection = new ArrayList<>();
    }

    // EFFECTS: creates a collection from a given list of Cat
    public CatCollection(ArrayList<Cat> collection) {
        this.collection = collection;
    }

    // MODIFIES: this
    // EFFECTS: adds cat to collection
    public void addToCollection(Cat cat) {
        collection.add(cat);
    }

    // REQUIRES: num < collection.size()
    // EFFECTS: returns the Cat at given index in collection
    public Cat getCatFromCollection(int num) {
        return collection.get(num);
    }

    // EFFECTS: returns collection
    public List<Cat> getCollection() {
        return collection;
    }

    // EFFECTS: saves each cat in collection to a file
    @Override
    public void save(PrintWriter printWriter) {
        for (Cat cat : collection) {
            cat.save(printWriter);
        }
    }
}
