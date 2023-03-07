package e1;

import e1.gameObjects.GameEntity;
import e1.gameObjects.GameObject;
import e1.gameObjects.factory.GameObjectFactory;
import e1.gameObjects.factory.GameObjectFactoryImpl;
import e1.gameObjects.utils.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class BaseTest {
    protected GameObject knight;
    protected GameObject pawn;
    protected GameObjectFactory gameObjectFactory;
    protected Logics logic;
    protected static final int SIZE = 5;
    protected static final int INIT_X_PAWN = 2;
    protected static final int INIT_Y_PAWN = 1;
    protected static final int INIT_X_KNIGHT = 0;
    protected static final int INIT_Y_KNIGHT = 0;

    Pair<Integer, Integer> initPawnPos = new Pair<>(INIT_X_PAWN, INIT_Y_PAWN);
    Pair<Integer, Integer> initKnightPos = new Pair<>(INIT_X_KNIGHT, INIT_Y_KNIGHT);

    @BeforeEach
    void init() {
        this.gameObjectFactory = new GameObjectFactoryImpl();
        this.pawn = gameObjectFactory.createPawn(initPawnPos);
        this.knight = gameObjectFactory.createKnight(initKnightPos);
        this.logic = new LogicsImpl(SIZE, initPawnPos, initKnightPos);
    }

    @Test
    public void testKnightPosition() {
        assertTrue(this.logic.hasGameObject(GameEntity.KNIGHT, 0, 0));
    }

    @Test
    public void testPawnPosition() {
        assertTrue(this.logic.hasGameObject(GameEntity.PAWN, initPawnPos.getX(), initPawnPos.getY()));
    }
}