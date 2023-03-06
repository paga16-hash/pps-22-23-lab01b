package e1.gameObjects;

import e1.gameObjects.utils.Pair;
import e1.movement.NoMovementStrategy;

public class Pawn extends AbstractGameObject {

    public Pawn(Pair<Integer, Integer> position) {
        super(position, new NoMovementStrategy());
    }
}
