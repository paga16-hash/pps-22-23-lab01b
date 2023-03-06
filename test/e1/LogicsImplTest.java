package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LogicsImplTest {

    private static final int SIZE = 5;
    private Logics logic;

    @BeforeEach
    public void initGUI() {
        Pair<Integer,Integer> pawnPos = new Pair<>(2, 1);
        Pair<Integer,Integer> knightPos = new Pair<>(0, 0);
        this.logic = new LogicsImpl(SIZE, pawnPos, knightPos);
    }

    @Test
    public void testKnightPosition() {
        assertTrue(this.logic.hasKnight(0, 0));
    }

    @Test
    public void testAllowedKnightMove() {
        this.logic.hit(2, 1);
        assertTrue(this.logic.hasKnight(2, 1));
    }

    @Test
    public void testNotAllowedKnightMove() {
        assertFalse(this.logic.hit(2, 2));
        assertTrue(this.logic.hasKnight(0, 0));
    }

    @Test
    public void testIllegalKnightMove() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(-1, 0));
        assertTrue(this.logic.hasKnight(0, 0));
    }

    @Test
    public void testPawnPosition() {
        assertTrue(this.logic.hasPawn(2, 1));
    }

    @Test
    public void testGameVictory() {
        assertEquals(this.logic.hit(2, 1), this.logic.hasPawn(2, 1));
    }

}