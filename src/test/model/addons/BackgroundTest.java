package model.addons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BackgroundTest {
    private Background constructorBG;
    private Background persistenceBG;
    private Background changingBG;
    private Background deleteBG;
    private Background noBG;
    private Background yesBG;

    @BeforeEach
    void runBefore() {
        constructorBG = new Background();
        changingBG = new Background();
        deleteBG = new Background();
        noBG = new Background();
        yesBG = new Background();

        persistenceBG = new Background("Nighttime");

        deleteBG.changeBackground("Home");
        yesBG.changeBackground("Forest");

    }

    @Test
    void testConstructor() {
        assertEquals("Empty", constructorBG.getBackground());
        assertEquals("Empty", changingBG.getBackground());
        assertEquals("Empty", noBG.getBackground());
    }

    @Test
    void testPersistenceConstructor() {
        assertEquals("Nighttime", persistenceBG.getBackground());
    }

    @Test
    void testChangingBackground() {
        assertTrue(changingBG.changeBackground("Beach"));
        assertTrue(changingBG.changeBackground("Forest"));
        assertTrue(changingBG.changeBackground("Home"));
        assertTrue(changingBG.changeBackground("Nighttime"));

        assertFalse(changingBG.changeBackground("empty"));
        assertFalse(changingBG.changeBackground("Volcano"));
        assertFalse(changingBG.changeBackground("Beac"));
        assertFalse(changingBG.changeBackground("forest"));
    }

    @Test
    void testDeleteBackground() {
        deleteBG.deleteBackground();
        assertEquals("Empty", deleteBG.getBackground());

        noBG.deleteBackground();
        assertEquals("Empty", noBG.getBackground());
    }

    @Test
    void testNoBackground() {
        assertTrue(constructorBG.noBackground());
        assertTrue(noBG.noBackground());

        assertFalse(yesBG.noBackground());
    }

}
