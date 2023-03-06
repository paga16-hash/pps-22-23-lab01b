package e1.gameObjects.factory;

import e1.gameObjects.GameObject;
import e1.gameObjects.utils.Pair;

public interface GameObjectFactory {

    GameObject createKnight(Pair<Integer, Integer> position);

    GameObject createPawn(Pair<Integer, Integer> position);
}
