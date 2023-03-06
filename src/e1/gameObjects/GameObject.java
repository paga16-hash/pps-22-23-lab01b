package e1.gameObjects;

import e1.gameObjects.utils.Pair;

public interface GameObject {
    Pair<Integer, Integer> getPosition();
    void setPosition(Pair<Integer, Integer> position);

    int getX();

    int getY();

    void move(int row, int col);

}
