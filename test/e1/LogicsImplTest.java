package e1;

import e1.gameObjects.GameEntity;
import e1.gameObjects.utils.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LogicsImplTest {
    private static final int SIZE = 5;
    private Logics logic;
    private static final int INIT_X_PAWN = 2;
    private static final int INIT_Y_PAWN = 1;
    private static final int INIT_X_KNIGHT = 0;
    private static final int INIT_Y_KNIGHT = 0;

    Pair<Integer, Integer> initPawnPos = new Pair<>(INIT_X_PAWN, INIT_Y_PAWN);
    Pair<Integer, Integer> initKnightPos = new Pair<>(INIT_X_KNIGHT, INIT_Y_KNIGHT);

    @BeforeEach
    public void initGUI() {
        this.logic = new LogicsImpl(SIZE, initPawnPos, initKnightPos);
    }

    @Test
    public void testKnightPosition() {
        assertTrue(this.logic.hasGameObject(GameEntity.KNIGHT, 0, 0));
    }

    @Test
    public void testAllowedKnightMove() {
        this.logic.hit(2, 1);
        assertTrue(this.logic.hasGameObject(GameEntity.KNIGHT, 2, 1));
    }

    @Test
    public void testNotAllowedKnightMove() {
        assertFalse(this.logic.hit(2, 2));
        assertTrue(this.logic.hasGameObject(GameEntity.KNIGHT, initKnightPos.getX(), initKnightPos.getY()));
    }

    @Test
    public void testIllegalKnightMove() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(-1, 0));
        assertTrue(this.logic.hasGameObject(GameEntity.KNIGHT, initKnightPos.getX(), initKnightPos.getY()));
    }

    @Test
    public void testPawnPosition() {
        assertTrue(this.logic.hasGameObject(GameEntity.PAWN, initPawnPos.getX(), initPawnPos.getY()));
    }

    @Test
    public void testGameVictory() {
        assertEquals(this.logic.hit(2, 1), this.logic.hasGameObject(GameEntity.PAWN, initPawnPos.getX(), initPawnPos.getY()));
    }
}