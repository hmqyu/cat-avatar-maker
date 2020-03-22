package model.cat;

import model.addons.Accessory;
import model.addons.Background;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CatCollectionTest {
    private ArrayList<Cat> persistenceList = new ArrayList<>();
    private ArrayList<String> heenyAccessories = new ArrayList<>();
    private ArrayList<String> alAccessories = new ArrayList<>();
    private Cat holly = new Cat();
    private Cat heeny;
    private Cat al;

    private CatCollection constructorC;
    private CatCollection persistenceC;
    private CatCollection oneCatC;
    private CatCollection multiCatC;

    @BeforeEach
    void runBefore() {
        persistenceList.add(holly);
        persistenceList.add(al);
        holly.changeName("Holly");
        heenyAccessories.add("bag");
        alAccessories.add("horns");
        alAccessories.add("amulet");
        heeny = new Cat("Heeny", "red", "tabby", "pink", "copper", "copper",
                new CatDirection("backward", "right"), new Accessory(heenyAccessories),
                new Background("garden"));
        al = new Cat("Al", "red", "solid", "pink", "yellow", "yellow",
                new CatDirection("forward", "left"), new Accessory(alAccessories),
                new Background("nighttime"));

        constructorC = new CatCollection();
        persistenceC = new CatCollection(persistenceList);
        oneCatC = new CatCollection();
        multiCatC = new CatCollection();

        oneCatC.addToCollection(holly);

        multiCatC.addToCollection(holly);
        multiCatC.addToCollection(heeny);
        multiCatC.addToCollection(al);
    }

    @Test
    void testConstructor() {
        assertEquals(new ArrayList<Cat>(), constructorC.getCollection());
    }

    @Test
    void testPersistenceConstructor() {
        assertEquals(persistenceList, persistenceC.getCollection());
    }

    @Test
    void testOneInCollection() {
        assertEquals(1, oneCatC.numOfCats());
        assertEquals(holly, oneCatC.getCatFromCollection(0));

        oneCatC.addToCollection(al);
        assertEquals(2, oneCatC.numOfCats());
        assertEquals(holly, oneCatC.getCatFromCollection(0));
        assertEquals(al, oneCatC.getCatFromCollection(1));

        oneCatC.addToCollection(heeny);
        assertEquals(3, oneCatC.numOfCats());
        assertEquals(holly, oneCatC.getCatFromCollection(0));
        assertEquals(al, oneCatC.getCatFromCollection(1));
        assertEquals(heeny, oneCatC.getCatFromCollection(2));
    }

    @Test
    void testMultipleInCollection() {
        assertEquals(3, multiCatC.numOfCats());
        assertEquals(holly, multiCatC.getCatFromCollection(0));
        assertEquals(heeny, multiCatC.getCatFromCollection(1));
        assertEquals(al, multiCatC.getCatFromCollection(2));
    }

}
