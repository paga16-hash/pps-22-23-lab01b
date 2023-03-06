package e1.gameObjects;

import e1.gameObjects.utils.Pair;
import e1.movement.MovementStrategy;

public interface GameObject {
    Pair<Integer, Integer> getPosition();

    int getX();

    int getY();
}
