package e1.movement;

public interface MovementStrategy {

    boolean canMove(int row, int col);

    void move(int row, int col);

    boolean onMove();

}
