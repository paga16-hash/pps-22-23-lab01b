package e1.movement;

public class NoMovementStrategy implements MovementStrategy {
    @Override
    public boolean onMove() {
        return false;
    }

    @Override
    public void move(int row, int col) {
    }

    @Override
    public boolean canMove(int row, int col) {
        return false;
    }
}
