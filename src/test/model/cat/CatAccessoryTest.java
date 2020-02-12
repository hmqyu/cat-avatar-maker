package model.cat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatAccessoryTest {

    private CatAccessory constructorCA;
    private CatAccessory oneItemCA;
    private CatAccessory multiItemCA;
    private CatAccessory oneFilledCA;
    private CatAccessory filledCA;
    private CatAccessory removeCA;

    @BeforeEach
    void runBefore() {
        constructorCA = new CatAccessory();
        oneItemCA = new CatAccessory();
        multiItemCA = new CatAccessory();
        oneFilledCA = new CatAccessory();
        filledCA = new CatAccessory();
        removeCA = new CatAccessory();

        oneFilledCA.addCatAccessory("hat");

        filledCA.addCatAccessory("hat");
        filledCA.addCatAccessory("scarf");
        filledCA.addCatAccessory("bag");

        removeCA.addCatAccessory("hat");
        removeCA.addCatAccessory("scarf");
        removeCA.addCatAccessory("bag");
        removeCA.addCatAccessory("wings");
        removeCA.addCatAccessory("horns");
    }

    @Test
    void testConstructor() {
        assertEquals("", constructorCA.getAllCatAccessories());
        assertEquals("", oneItemCA.getAllCatAccessories());
        assertEquals("", multiItemCA.getAllCatAccessories());
    }

    @Test
    void testAddCatAccessory() {
        assertTrue(oneItemCA.addCatAccessory("hat"));

        assertTrue(multiItemCA.addCatAccessory("hat"));
        assertTrue(multiItemCA.addCatAccessory("scarf"));
        assertTrue(multiItemCA.addCatAccessory("bag"));

        assertFalse(filledCA.addCatAccessory("hat"));
        assertFalse(filledCA.addCatAccessory("scarf"));
        assertFalse(filledCA.addCatAccessory("bag"));
        assertTrue(filledCA.addCatAccessory("wings"));
        assertTrue(filledCA.addCatAccessory("horns"));
    }

    @Test
    void testRemoveCatAccessory() {
        assertTrue(removeCA.removeCatAccessory("hat"));

        assertEquals("scarf, bag, wings, and horns", removeCA.getAllCatAccessories());

        assertTrue(removeCA.removeCatAccessory("scarf"));
        assertTrue(removeCA.removeCatAccessory("bag"));
        assertTrue(removeCA.removeCatAccessory("wings"));
        assertTrue(removeCA.removeCatAccessory("horns"));

        assertEquals("", removeCA.getAllCatAccessories());

        assertFalse(removeCA.removeCatAccessory("wings"));
        assertFalse(removeCA.removeCatAccessory("horns"));
    }

    @Test
    void testRemoveAllCatAccessories() {
        constructorCA.removeAllCatAccessories();
        assertEquals("", constructorCA.getAllCatAccessories());

        removeCA.removeAllCatAccessories();
        assertEquals("", removeCA.getAllCatAccessories());
    }

    @Test
    void testGetAllCatAccessories() {
        assertEquals("", constructorCA.getAllCatAccessories());
        assertEquals("", oneItemCA.getAllCatAccessories());
        assertEquals("hat", oneFilledCA.getAllCatAccessories());
        assertEquals("hat, scarf, and bag", filledCA.getAllCatAccessories());
        assertEquals("hat, scarf, bag, wings, and horns", removeCA.getAllCatAccessories());
    }

}
