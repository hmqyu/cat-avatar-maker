package model.cat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatDirectionTest {
    private CatDirection constructorCD;
    private CatDirection persistenceCD;
    private CatDirection flipRightCD;
    private CatDirection flipLeftCD;

    @BeforeEach
    void runBefore() {
        constructorCD = new CatDirection();
        flipRightCD = new CatDirection();
        flipLeftCD = new CatDirection();
        flipLeftCD.flip();

        persistenceCD = new CatDirection("right");
    }

    @Test
    void testConstructor() {
        assertEquals("left", constructorCD.getSide());
    }

    @Test
    void testPersistenceConstructor() {
        assertEquals("right", persistenceCD.getSide());
    }

    @Test
    void testFlip() {
        flipRightCD.flip();
        assertEquals("right", flipRightCD.getSide());

        flipLeftCD.flip();
        assertEquals("left", flipLeftCD.getSide());
    }
}
