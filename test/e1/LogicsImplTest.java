package e1;

import e1.gameObjects.GameEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsImplTest extends BaseTest {

    @Test
    public void testAllowedKnightHit() {
        this.logic.hit(2, 1);
        assertTrue(this.logic.hasGameObject(GameEntity.KNIGHT, 2, 1));
    }

    @Test
    public void testNotAllowedKnightHit() {
        assertFalse(this.logic.hit(2, 2));
        assertTrue(this.logic.hasGameObject(GameEntity.KNIGHT, initKnightPos.getX(), initKnightPos.getY()));
    }

    @Test
    public void testIllegalKnightHit() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(-1, 0));
        assertTrue(this.logic.hasGameObject(GameEntity.KNIGHT, initKnightPos.getX(), initKnightPos.getY()));
    }

    @Test
    public void testGameVictory() {
        assertEquals(this.logic.hit(2, 1), this.logic.hasGameObject(GameEntity.PAWN, initPawnPos.getX(), initPawnPos.getY()));
    }
}