package model.cat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatDirectionTest {
    private CatDirection constructorCD;
    private CatDirection flipCD;
    private CatDirection turnCD;
    private CatDirection bothCD;

    @BeforeEach
    void runBefore() {
        constructorCD = new CatDirection();
        flipCD = new CatDirection();
        turnCD = new CatDirection();
        bothCD = new CatDirection();
    }

    @Test
    void testConstructor() {
        assertEquals("forward", constructorCD.getFacing());
        assertEquals("right", constructorCD.getSide());

        assertEquals("forward", turnCD.getFacing());
        assertEquals("right", turnCD.getSide());
    }

    @Test
    void testFlip() {
        flipCD.flip();
        assertEquals("forward", flipCD.getFacing());
        assertEquals("left", flipCD.getSide());

        flipCD.flip();
        assertEquals("forward", flipCD.getFacing());
        assertEquals("right", flipCD.getSide());
    }

    @Test
    void testTurn() {
        turnCD.turn();
        assertEquals("backward", turnCD.getFacing());
        assertEquals("right", turnCD.getSide());

        turnCD.turn();
        assertEquals("forward", turnCD.getFacing());
        assertEquals("right", turnCD.getSide());
    }

    @Test
    void testFlipAndTurn() {
        bothCD.flip();
        bothCD.turn();
        assertEquals("backward", bothCD.getFacing());
        assertEquals("left", bothCD.getSide());

        bothCD.turn();
        bothCD.flip();
        assertEquals("forward", bothCD.getFacing());
        assertEquals("right", bothCD.getSide());
    }

}
