package model.cat;

import model.addons.Accessory;
import model.addons.Background;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {
    private Cat constructorCat;
    private Cat persistenceCat;
    private Cat changeDirectionCat;
    private Cat changeAccessoriesCat;
    private Cat changeBackgroundCat;
    private Cat changeMultipleCat;

    @BeforeEach
    void runBefore() {
        constructorCat = new Cat();
        changeDirectionCat = new Cat();
        changeAccessoriesCat = new Cat();
        changeBackgroundCat = new Cat();

        persistenceCat = new Cat("Heeny", "red", "tabby", "pink", "copper", "copper",
                new CatDirection("right"), new Accessory(),
                new Background("Nighttime"));

        changeMultipleCat = new Cat();
        changeMultipleCat.changeName("Al");
        changeMultipleCat.changeBase("red");
        changeMultipleCat.changePattern("calico");
        changeMultipleCat.changeSkin("mauve");
        changeMultipleCat.changeLeftEye("green");
        changeMultipleCat.changeRightEye("green");
    }

    @Test
    void testConstructor() {
        assertEquals("your cat", constructorCat.getName());
        assertEquals("White", constructorCat.getBase());
        assertEquals("Solid", constructorCat.getPattern());
        assertEquals("Pink", constructorCat.getSkin());
        assertEquals("Yellow", constructorCat.getLeftEye());
        assertEquals("Yellow", constructorCat.getRightEye());
        assertEquals("left", constructorCat.getDirection());
        assertEquals(new ArrayList<>(), constructorCat.getAccessories());
        assertEquals("Empty", constructorCat.getBackground());
    }

    @Test
    void testPersistenceConstructor() {
        assertEquals("Heeny", persistenceCat.getName());
        assertEquals("red", persistenceCat.getBase());
        assertEquals("tabby", persistenceCat.getPattern());
        assertEquals("pink", persistenceCat.getSkin());
        assertEquals("copper", persistenceCat.getLeftEye());
        assertEquals("copper", persistenceCat.getRightEye());
        assertEquals("right", persistenceCat.getDirection());
        assertEquals(new ArrayList<>(), persistenceCat.getAccessories());
        assertEquals("Nighttime", persistenceCat.getBackground());
    }

    @Test
    void testSetters() {
        assertEquals("Al", changeMultipleCat.getName());
        assertEquals("red", changeMultipleCat.getBase());
        assertEquals("calico", changeMultipleCat.getPattern());
        assertEquals("mauve", changeMultipleCat.getSkin());
        assertEquals("green", changeMultipleCat.getLeftEye());
    }

    @Test
    void testDirection() {
        assertEquals("left", changeDirectionCat.getDirection());
        changeDirectionCat.flipDirection();
        assertEquals("right", changeDirectionCat.getDirection());
    }

    @Test
    void testAccessories() {
        ArrayList<String> testAccessoriesList = new ArrayList<>();
        assertEquals(testAccessoriesList, changeAccessoriesCat.getAccessories());

        assertTrue(changeAccessoriesCat.addAccessory("hat"));
        assertTrue(changeAccessoriesCat.addAccessory("scarf"));
        assertTrue(changeAccessoriesCat.addAccessory("bag"));
        assertTrue(changeAccessoriesCat.addAccessory("wings"));
        testAccessoriesList.add("hat");
        testAccessoriesList.add("scarf");
        testAccessoriesList.add("bag");
        testAccessoriesList.add("wings");
        assertEquals(testAccessoriesList, changeAccessoriesCat.getAccessories());

        assertFalse(changeAccessoriesCat.addAccessory("hat"));
        assertFalse(changeAccessoriesCat.addAccessory("scarf"));
        assertEquals(testAccessoriesList, changeAccessoriesCat.getAccessories());

        assertTrue(changeAccessoriesCat.removeAccessory("hat"));
        assertTrue(changeAccessoriesCat.removeAccessory("wings"));
        assertTrue(changeAccessoriesCat.removeAccessory("scarf"));
        testAccessoriesList.remove("hat");
        testAccessoriesList.remove("scarf");
        testAccessoriesList.remove("wings");
        assertEquals(testAccessoriesList, changeAccessoriesCat.getAccessories());

        assertFalse(changeAccessoriesCat.removeAccessory("hat"));
        assertFalse(changeAccessoriesCat.removeAccessory("tomato"));
        assertEquals(testAccessoriesList, changeAccessoriesCat.getAccessories());

        assertTrue(changeAccessoriesCat.addAccessory("amulet"));
        testAccessoriesList.add("amulet");
        assertEquals(testAccessoriesList, changeAccessoriesCat.getAccessories());
    }

    @Test
    void testBackground() {
        changeBackgroundCat.changeBackground("Forest");
        assertEquals("Forest", changeBackgroundCat.getBackground());

        changeBackgroundCat.changeBackground("Nighttime");
        assertEquals("Nighttime", changeBackgroundCat.getBackground());

        changeBackgroundCat.changeBackground("city");
        assertEquals("city", changeBackgroundCat.getBackground());
    }

}