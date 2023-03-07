package e1.gameObjects.movement;

import e1.gameObjects.utils.Pair;

public interface MovementStrategy {

    boolean canMove(Pair<Integer, Integer> currentPosition, int row, int col);

    void onMove();

}
