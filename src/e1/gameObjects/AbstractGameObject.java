package e1.gameObjects;

import e1.gameObjects.utils.Pair;
import e1.movement.MovementStrategy;

public class AbstractGameObject implements GameObject {
    Pair<Integer, Integer> position;
    MovementStrategy movementStrategy;

    public AbstractGameObject(Pair<Integer, Integer> position, MovementStrategy movementStrategy) {
        this.position = position;
        this.movementStrategy = movementStrategy;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public int getX() {
        return this.position.getX();
    }

    @Override
    public int getY() {
        return this.position.getY();
    }

    public boolean canMove(int row, int col) {
        return this.movementStrategy.canMove(row, col);
    }

    public void move(int row, int col) {
        this.movementStrategy.move(row, col);
        this.position = new Pair<>(row, col);
    }

    public boolean onMove() {
        return this.movementStrategy.onMove();
    }
}
