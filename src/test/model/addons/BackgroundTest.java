package model.addons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BackgroundTest {
    private Background constructorBG;
    private Background persistenceBG;
    private Background changingBG;
    private Background noBG;

    @BeforeEach
    void runBefore() {
        constructorBG = new Background();
        changingBG = new Background();
        noBG = new Background();
        persistenceBG = new Background("Nighttime");
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
        changingBG.changeBackground("Beach");
        assertEquals("Beach", changingBG.getBackground());

        changingBG.changeBackground("Forest");
        assertEquals("Forest", changingBG.getBackground());


        changingBG.changeBackground("Home");
        assertEquals("Home", changingBG.getBackground());


        changingBG.changeBackground("Nighttime");
        assertEquals("Nighttime", changingBG.getBackground());
    }

}
