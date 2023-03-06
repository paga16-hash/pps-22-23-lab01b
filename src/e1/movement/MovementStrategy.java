package e1.movement;

public interface MovementStrategy {

    boolean canMove();

    void move();

    boolean onMove();
}
