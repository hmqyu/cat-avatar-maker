package model.addons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccessoryTest {

    private Accessory constructorCA;
    private Accessory oneItemCA;
    private Accessory multiItemCA;
    private Accessory oneFilledCA;
    private Accessory filledCA;
    private Accessory removeCA;

    @BeforeEach
    void runBefore() {
        constructorCA = new Accessory();
        oneItemCA = new Accessory();
        multiItemCA = new Accessory();
        oneFilledCA = new Accessory();
        filledCA = new Accessory();
        removeCA = new Accessory();

        oneFilledCA.addAccessory("hat");

        filledCA.addAccessory("hat");
        filledCA.addAccessory("scarf");
        filledCA.addAccessory("bag");

        removeCA.addAccessory("hat");
        removeCA.addAccessory("scarf");
        removeCA.addAccessory("bag");
        removeCA.addAccessory("wings");
        removeCA.addAccessory("horns");
    }

    @Test
    void testConstructor() {
        assertEquals("", constructorCA.getAllAccessories());
        assertEquals("", oneItemCA.getAllAccessories());
        assertEquals("", multiItemCA.getAllAccessories());
    }

    @Test
    void testAddCatAccessory() {
        assertTrue(oneItemCA.addAccessory("hat"));

        assertTrue(multiItemCA.addAccessory("hat"));
        assertTrue(multiItemCA.addAccessory("scarf"));
        assertTrue(multiItemCA.addAccessory("bag"));

        assertFalse(filledCA.addAccessory("hat"));
        assertFalse(filledCA.addAccessory("scarf"));
        assertFalse(filledCA.addAccessory("bag"));
        assertTrue(filledCA.addAccessory("wings"));
        assertTrue(filledCA.addAccessory("horns"));
    }

    @Test
    void testRemoveCatAccessory() {
        assertTrue(removeCA.removeAccessory("hat"));

        assertEquals("scarf, bag, wings, and horns", removeCA.getAllAccessories());

        assertTrue(removeCA.removeAccessory("scarf"));
        assertTrue(removeCA.removeAccessory("bag"));
        assertTrue(removeCA.removeAccessory("wings"));
        assertTrue(removeCA.removeAccessory("horns"));

        assertEquals("", removeCA.getAllAccessories());

        assertFalse(removeCA.removeAccessory("wings"));
        assertFalse(removeCA.removeAccessory("horns"));
    }

    @Test
    void testRemoveAllAccessories() {
        constructorCA.removeAccessories();
        assertEquals("", constructorCA.getAllAccessories());

        removeCA.removeAccessories();
        assertEquals("", removeCA.getAllAccessories());
    }

    @Test
    void testGetAllAccessories() {
        assertEquals("", constructorCA.getAllAccessories());
        assertEquals("", oneItemCA.getAllAccessories());
        assertEquals("hat", oneFilledCA.getAllAccessories());
        assertEquals("hat, scarf, and bag", filledCA.getAllAccessories());
        assertEquals("hat, scarf, bag, wings, and horns", removeCA.getAllAccessories());
    }

}
