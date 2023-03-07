package e1.gameObjects.implementation;

import e1.gameObjects.AbstractGameObject;
import e1.gameObjects.utils.Pair;
import e1.gameObjects.movement.MovementStrategy;

public class Pawn extends AbstractGameObject {

    public Pawn(Pair<Integer, Integer> position, MovementStrategy movementStrategy) {
        super(position, movementStrategy);
    }

    @Override
    public void move(int row, int col) {
    }
}
