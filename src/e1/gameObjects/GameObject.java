package e1.gameObjects;

import e1.gameObjects.utils.Pair;

public interface GameObject {
    void initPosition(Integer row, Integer col);
    Pair<Integer, Integer> getPosition();

    int getX();

    int getY();
}
