package e1.gameObjects;

import e1.gameObjects.utils.Pair;
import e1.movement.MovementStrategy;

public class Pawn extends AbstractGameObject {

    public Pawn(Pair<Integer, Integer> position, MovementStrategy movementStrategy) {
        super(position, movementStrategy);
    }

    @Override
    public void move(int row, int col) {}
}
