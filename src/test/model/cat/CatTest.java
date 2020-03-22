package model.cat;

import model.addons.Accessory;
import model.addons.Background;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {
    private Cat constructorCat;
    private Cat persistenceCat;
    private Cat changeDirectionCat;
    private Cat changeAccessoriesCat;
    private Cat changeAccessoriesArticleCat;
    private Cat changeBackgroundCat;
    private Cat changeMultipleCat;

    @BeforeEach
    void runBefore() {
        constructorCat = new Cat();
        changeDirectionCat = new Cat();
        changeAccessoriesCat = new Cat();
        changeAccessoriesArticleCat = new Cat();
        changeBackgroundCat = new Cat();

        persistenceCat = new Cat("Heeny", "red", "tabby", "pink", "copper", "copper",
                new CatDirection("backward", "right"), new Accessory(),
                new Background("nighttime"));

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
        assertEquals("forward and to the right", constructorCat.getDirection());
        assertEquals("no accessories", constructorCat.getAllAccessories());
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
        assertEquals("backward and to the right", persistenceCat.getDirection());
        assertEquals("no accessories", persistenceCat.getAllAccessories());
        assertEquals("nighttime", persistenceCat.getBackground());
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
        assertEquals("a hat, a scarf, a bag, and wings", changeAccessoriesCat.getAllAccessories());

        assertFalse(changeAccessoriesCat.addAccessory("hat"));
        assertFalse(changeAccessoriesCat.addAccessory("scarf"));
        assertEquals("a hat, a scarf, a bag, and wings", changeAccessoriesCat.getAllAccessories());

        assertTrue(changeAccessoriesCat.removeAccessory("hat"));
        assertTrue(changeAccessoriesCat.removeAccessory("wings"));
        assertTrue(changeAccessoriesCat.removeAccessory("scarf"));
        assertEquals("a bag", changeAccessoriesCat.getAllAccessories());

        assertFalse(changeAccessoriesCat.removeAccessory("hat"));
        assertFalse(changeAccessoriesCat.removeAccessory("tomato"));
        assertEquals("a bag", changeAccessoriesCat.getAllAccessories());

        assertTrue(changeAccessoriesCat.addAccessory("amulet"));
        assertEquals("a bag, and an amulet", changeAccessoriesCat.getAllAccessories());

        changeAccessoriesCat.removeAllAccessories();
        assertEquals("no accessories", changeAccessoriesCat.getAllAccessories());
        constructorCat.removeAllAccessories();
        assertEquals("no accessories", changeAccessoriesCat.getAllAccessories());

        // testing addArticle
        changeAccessoriesArticleCat.addAccessory("apron");
        changeAccessoriesArticleCat.addAccessory("earring stud");
        changeAccessoriesArticleCat.addAccessory("ivory brooch");
        changeAccessoriesArticleCat.addAccessory("overcoat");
        changeAccessoriesArticleCat.addAccessory("undershirt");
        changeAccessoriesArticleCat.addAccessory("wool sweater");
        changeAccessoriesArticleCat.addAccessory("glasses");
        assertEquals("an apron, an earring stud, an ivory brooch, an overcoat, an undershirt," +
                " a wool sweater, and glasses", changeAccessoriesArticleCat.getAllAccessories());
    }

    @Test
    void testBackground() {
        assertTrue(changeBackgroundCat.emptyBackground());

        assertTrue(changeBackgroundCat.changeBackground("Forest"));
        assertEquals("Forest", changeBackgroundCat.getBackground());
        assertFalse(changeBackgroundCat.emptyBackground());

        assertTrue(changeBackgroundCat.changeBackground("Nighttime"));
        assertEquals("Nighttime", changeBackgroundCat.getBackground());
        assertFalse(changeBackgroundCat.emptyBackground());

        changeBackgroundCat.removeBackground();
        assertEquals("Empty", changeBackgroundCat.getBackground());
        assertTrue(changeBackgroundCat.emptyBackground());
    }

}