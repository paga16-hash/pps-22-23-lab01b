package e1.movement;

import e1.gameObjects.Knight;
import e1.gameObjects.utils.Pair;

public class KnightMovementStrategy implements MovementStrategy {

    @Override
    public boolean onMove() {
        return false;
    }

    @Override
    public void move(int row, int col) {
        int x = row - this.getX();
        int y = col - this.knight.getY();
        if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
            this.knight = new Knight(new Pair<>(row, col));
        }
    }

    @Override
    public boolean canMove(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }
}
