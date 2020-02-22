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

        persistenceBG = new Background("nighttime");

        deleteBG.changeBackground("garden");
        yesBG.changeBackground("forest");

    }

    @Test
    void testConstructor() {
        assertEquals("empty", constructorBG.getBackground());
        assertEquals("empty", changingBG.getBackground());
        assertEquals("empty", noBG.getBackground());
    }

    @Test
    void testPersistenceConstructor() {
        assertEquals("nighttime", persistenceBG.getBackground());
    }

    @Test
    void testChangingBackground() {
        assertTrue(changingBG.changeBackground("beach"));
        assertTrue(changingBG.changeBackground("city"));
        assertTrue(changingBG.changeBackground("forest"));
        assertTrue(changingBG.changeBackground("garden"));
        assertTrue(changingBG.changeBackground("nighttime"));

        assertFalse(changingBG.changeBackground("empty"));
        assertFalse(changingBG.changeBackground("volcano"));
        assertFalse(changingBG.changeBackground("beac"));
        assertFalse(changingBG.changeBackground("Forest"));
    }

    @Test
    void testDeleteBackground() {
        deleteBG.deleteBackground();
        assertEquals("empty", deleteBG.getBackground());

        noBG.deleteBackground();
        assertEquals("empty", noBG.getBackground());
    }

    @Test
    void testNoBackground() {
        assertTrue(constructorBG.noBackground());
        assertTrue(noBG.noBackground());

        assertFalse(yesBG.noBackground());
    }

}
