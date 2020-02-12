package model.cat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {
    private Cat constructorCat;
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

        changeMultipleCat = new Cat();
        changeMultipleCat.changeName("Al");
        changeMultipleCat.changeBase("red");
        changeMultipleCat.changePattern("calico");
        changeMultipleCat.changeNose("mauve");
        changeMultipleCat.changeEyes("green");
    }

    @Test
    void testConstructor() {
        assertEquals("your cat", constructorCat.getName());
        assertEquals("white", constructorCat.getBase());
        assertEquals("solid", constructorCat.getPattern());
        assertEquals("pink", constructorCat.getNose());
        assertEquals("yellow", constructorCat.getEyes());
        assertEquals("forward and to the right", constructorCat.getDirection());
        assertEquals("no accessories", constructorCat.getAllAccessories());
        assertEquals("empty", constructorCat.getBackground());
    }

    @Test
    void testSetters() {
        assertEquals("Al", changeMultipleCat.getName());
        assertEquals("red", changeMultipleCat.getBase());
        assertEquals("calico", changeMultipleCat.getPattern());
        assertEquals("mauve", changeMultipleCat.getNose());
        assertEquals("green", changeMultipleCat.getEyes());
    }

    @Test
    void testDirection() {
        assertEquals("forward and to the right", changeDirectionCat.getDirection());

        changeDirectionCat.flipDirection();
        assertEquals("forward and to the left", changeDirectionCat.getDirection());

        changeDirectionCat.turnDirection();
        assertEquals("backward and to the left", changeDirectionCat.getDirection());

        changeDirectionCat.flipDirection();
        changeDirectionCat.turnDirection();
        assertEquals("forward and to the right", changeDirectionCat.getDirection());
    }

    @Test
    void testAccessories() {
        assertEquals("no accessories", changeAccessoriesCat.getAllAccessories());

        assertTrue(changeAccessoriesCat.addAccessory("hat"));
        assertTrue(changeAccessoriesCat.addAccessory("scarf"));
        assertTrue(changeAccessoriesCat.addAccessory("bag"));
        assertTrue(changeAccessoriesCat.addAccessory("wings"));
        assertEquals("hat, scarf, bag, and wings", changeAccessoriesCat.getAllAccessories());

        assertFalse(changeAccessoriesCat.addAccessory("hat"));
        assertFalse(changeAccessoriesCat.addAccessory("scarf"));
        assertEquals("hat, scarf, bag, and wings", changeAccessoriesCat.getAllAccessories());

        assertTrue(changeAccessoriesCat.removeAccessory("hat"));
        assertTrue(changeAccessoriesCat.removeAccessory("wings"));
        assertEquals("scarf, and bag", changeAccessoriesCat.getAllAccessories());

        assertFalse(changeAccessoriesCat.removeAccessory("hat"));
        assertFalse(changeAccessoriesCat.removeAccessory("tomato"));
        assertEquals("scarf, and bag", changeAccessoriesCat.getAllAccessories());
    }

    @Test
    void testBackground() {
        assertTrue(changeBackgroundCat.emptyBackground());

        assertTrue(changeBackgroundCat.changeBackground("forest"));
        assertEquals("forest", changeBackgroundCat.getBackground());
        assertFalse(changeBackgroundCat.emptyBackground());

        assertTrue(changeBackgroundCat.changeBackground("nighttime"));
        assertEquals("nighttime", changeBackgroundCat.getBackground());
        assertFalse(changeBackgroundCat.emptyBackground());

        changeBackgroundCat.removeBackground();
        assertEquals("empty", changeBackgroundCat.getBackground());
        assertTrue(changeBackgroundCat.emptyBackground());
    }

}