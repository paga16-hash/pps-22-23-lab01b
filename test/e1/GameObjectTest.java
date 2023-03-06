package e1;

import e1.gameObjects.GameObject;
import e1.gameObjects.factory.GameObjectFactory;
import e1.gameObjects.factory.GameObjectFactoryImpl;
import e1.gameObjects.utils.Pair;
import org.junit.jupiter.api.BeforeEach;

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
}
