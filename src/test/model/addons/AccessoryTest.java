package model.addons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AccessoryTest {

    private Accessory constructorCA;
    private Accessory persistenceEmptyListCA;
    private Accessory persistenceEmptyStringCA;
    private Accessory persistenceFilledCA;
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

        ArrayList<String> emptyList = new ArrayList<>();
        persistenceEmptyListCA = new Accessory(emptyList);

        ArrayList<String> emptyString = new ArrayList<>();
        emptyString.add("");
        persistenceEmptyStringCA = new Accessory(emptyString);

        ArrayList<String> accessories = new ArrayList<>();
        accessories.add("hat");
        accessories.add("scarf");
        accessories.add("horns");
        persistenceFilledCA = new Accessory(accessories);

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
        assertEquals(new ArrayList<>(), persistenceEmptyListCA.getAllAccessories());
        assertEquals(new ArrayList<>(), persistenceEmptyStringCA.getAllAccessories());

        ArrayList<String> persistenceTest = new ArrayList<>();
        persistenceTest.add("hat");
        persistenceTest.add("scarf");
        persistenceTest.add("horns");
        assertEquals(persistenceTest, persistenceFilledCA.getAllAccessories());
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
