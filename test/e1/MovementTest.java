package e1;

import e1.gameObjects.utils.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovementTest extends BaseTest {

    @Test
    void testAllowedGameObjectMove() {
        Pair<Integer, Integer> destination = new Pair<>(initKnightPos.getX() + 1, initKnightPos.getY() + 2);
        this.knight.move(1, 2);
        assertEquals(this.knight.getPosition(), destination);
    }

    @Test
    void testNotAllowedGameObjectMove() {
        Pair<Integer, Integer> destination = new Pair<>(initKnightPos.getX() + 2, initKnightPos.getY() + 2);
        this.knight.move(2, 2);
        assertEquals(this.knight.getPosition(), initKnightPos);
    }

    @Test
    void testIllegalGameObjectMove() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.knight.move(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> this.knight.move(0, -1));
        assertEquals(this.pawn.getPosition(), initPawnPos);
    }

    @Test
    void testPawnMovement() {
        this.pawn.move(2, 3);
        assertEquals(this.pawn.getPosition(), initPawnPos);
    }
}
