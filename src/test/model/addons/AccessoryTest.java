package model.addons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AccessoryTest {

    private Accessory constructorCA;
    private Accessory persistenceCA;
    private Accessory persistenceEmptyCA;
    private Accessory oneItemCA;
    private Accessory multiItemCA;
    private Accessory filledCA;
    private Accessory removeCA;

    @BeforeEach
    void runBefore() {
        constructorCA = new Accessory();
        oneItemCA = new Accessory();
        multiItemCA = new Accessory();
        filledCA = new Accessory();
        removeCA = new Accessory();

        ArrayList<String> accessories = new ArrayList<>();
        accessories.add("hat");
        accessories.add("scarf");
        accessories.add("horns");
        persistenceCA = new Accessory(accessories);

        ArrayList<String> emptyAccessories = new ArrayList<>();
        emptyAccessories.add("");
        persistenceEmptyCA = new Accessory(emptyAccessories);

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
        assertEquals(new ArrayList<>(), constructorCA.getAllAccessories());
        assertEquals(new ArrayList<>(), oneItemCA.getAllAccessories());
        assertEquals(new ArrayList<>(), multiItemCA.getAllAccessories());
    }

    @Test
    void testPersistenceConstructor() {
        ArrayList<String> persistenceTest = new ArrayList<>();
        persistenceTest.add("hat");
        persistenceTest.add("scarf");
        persistenceTest.add("horns");
        assertEquals(persistenceTest, persistenceCA.getAllAccessories());

        assertEquals(new ArrayList<>(), persistenceEmptyCA.getAllAccessories());
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

        ArrayList<String> removeCAModified = new ArrayList<>();
        removeCAModified.add("scarf");
        removeCAModified.add("bag");
        removeCAModified.add("wings");
        removeCAModified.add("horns");
        assertEquals(removeCAModified, removeCA.getAllAccessories());

        assertTrue(removeCA.removeAccessory("scarf"));
        assertTrue(removeCA.removeAccessory("bag"));
        assertTrue(removeCA.removeAccessory("wings"));
        assertTrue(removeCA.removeAccessory("horns"));

        assertEquals(new ArrayList<>(), removeCA.getAllAccessories());

        assertFalse(removeCA.removeAccessory("wings"));
        assertFalse(removeCA.removeAccessory("horns"));
    }

    @Test
    void testRemoveAllAccessories() {
        constructorCA.removeAllAccessories();
        assertEquals(new ArrayList<>(), constructorCA.getAllAccessories());

        removeCA.removeAllAccessories();
        assertEquals(new ArrayList<>(), removeCA.getAllAccessories());
    }

}
