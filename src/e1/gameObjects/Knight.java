package e1.gameObjects;

import e1.gameObjects.utils.Pair;
import e1.movement.MovementStrategy;

public class Knight extends AbstractGameObject {

    public Knight(Pair<Integer, Integer> position, MovementStrategy movementStrategy) {
        super(position, movementStrategy);
    }
    @Override
    public void move(int row, int col) {
        if (this.movementStrategy.canMove(this.getPosition(), row, col)) {
            this.actualMove(row, col);
            this.movementStrategy.onMove();
        }
    }

    void actualMove(int row, int col) {
        setPosition(new Pair<>(row, col));
    }
}
