package e1.gameObjects;

import e1.gameObjects.utils.Pair;
import e1.movement.KnightMovementStrategy;
import e1.movement.MovementStrategy;

public class Knight extends AbstractGameObject {
    MovementStrategy knightMovementStrategy;

    public Knight(Pair<Integer, Integer> position) {
        super(position);
        this.knightMovementStrategy = new KnightMovementStrategy();
    }
}
