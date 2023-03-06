package e1;

import e1.gameObjects.GameObject;
import e1.gameObjects.factory.GameObjectFactory;
import e1.gameObjects.factory.GameObjectFactoryImpl;
import e1.gameObjects.utils.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameObjectTest {

    protected GameObject knight;
    protected GameObject pawn;
    protected GameObjectFactory gameObjectFactory;

    private static final int INIT_X_PAWN = 2;
    private static final int INIT_Y_PAWN = 1;
    private static final int INIT_X_KNIGHT = 0;
    private static final int INIT_Y_KNIGHT = 0;

    Pair<Integer,Integer> initPawnPos = new Pair<>(INIT_X_PAWN, INIT_Y_PAWN);
    Pair<Integer,Integer> initKnightPos = new Pair<>(INIT_X_KNIGHT, INIT_Y_KNIGHT);

    @BeforeEach
    void initFactory(){
        this.gameObjectFactory = new GameObjectFactoryImpl();
        this.pawn = gameObjectFactory.createPawn(initPawnPos);
        this.knight = gameObjectFactory.createKnight(initKnightPos);
    }

    @Test
    void testInitialPositions() {
        assertEquals(this.knight.getPosition(), initKnightPos);
        assertEquals(this.pawn.getPosition(), initPawnPos);
    }

    @Test
    void testGameObjectMove() {
        Pair<Integer, Integer> destination = new Pair<>(initKnightPos.getX() + 1, initKnightPos.getY() + 2);
        this.knight.move(1, 2);
        assertEquals(this.knight.getPosition(), destination);
    }

    @Test
    void testGameObjectFailingMove() {
        Pair<Integer, Integer> destination = new Pair<>(initKnightPos.getX() + 2, initKnightPos.getY() + 2);
        this.knight.move(2, 2);
        assertEquals(this.knight.getPosition(), initKnightPos);
    }

    @Test
    void testGameObjectIllegalMove() {
        assertThrows(IndexOutOfBoundsException.class,() -> this.knight.move(-1, 0));
        assertThrows(IndexOutOfBoundsException.class,() -> this.knight.move(0, -1));
        assertEquals(this.pawn.getPosition(), initPawnPos);
    }

    @Test
    void testPawnMovement() {
        this.pawn.move(2,3);
        assertEquals(this.pawn.getPosition(), initPawnPos);
    }

}
