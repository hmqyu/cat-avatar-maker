package model.cat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatDirectionTest {
    private CatDirection constructorCD;
    private CatDirection flipRightCD;
    private CatDirection flipLeftCD;
    private CatDirection turnForwardCD;
    private CatDirection turnBackwardCD;
    private CatDirection bothCD;

    @BeforeEach
    void runBefore() {
        constructorCD = new CatDirection();
        flipRightCD = new CatDirection();
        flipLeftCD = new CatDirection();
        flipLeftCD.flip();
        turnForwardCD = new CatDirection();
        turnBackwardCD = new CatDirection();
        turnBackwardCD.turn();
        bothCD = new CatDirection();
    }

    @Test
    void testConstructor() {
        assertEquals("forward", constructorCD.getFacing());
        assertEquals("right", constructorCD.getSide());

        assertEquals("forward", bothCD.getFacing());
        assertEquals("right", bothCD.getSide());
    }

    @Test
    void testFlip() {
        flipRightCD.flip();
        assertEquals("forward", flipRightCD.getFacing());
        assertEquals("left", flipRightCD.getSide());

        flipLeftCD.flip();
        assertEquals("forward", flipLeftCD.getFacing());
        assertEquals("right", flipLeftCD.getSide());
    }

    @Test
    void testTurn() {
        turnForwardCD.turn();
        assertEquals("backward", turnForwardCD.getFacing());
        assertEquals("right", turnForwardCD.getSide());

        turnBackwardCD.turn();
        assertEquals("forward", turnBackwardCD.getFacing());
        assertEquals("right", turnBackwardCD.getSide());
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
