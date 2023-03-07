package e1.gameObjects.factory;

import e1.gameObjects.GameObject;
import e1.gameObjects.implementation.Knight;
import e1.gameObjects.implementation.Pawn;
import e1.gameObjects.utils.Pair;
import e1.gameObjects.movement.MovementStrategy;

public class GameObjectFactoryImpl implements GameObjectFactory {
    @Override
    public GameObject createKnight(Pair<Integer, Integer> position) {
        return new Knight(position, new MovementStrategy() {
            @Override
            public boolean canMove(Pair<Integer, Integer> currentPosition, int row, int col) {
                if (row < 0 || col < 0) {
                    throw new IndexOutOfBoundsException();
                }
                int x = row - currentPosition.getX();
                int y = col - currentPosition.getY();
                return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
            }

            @Override
            public void onMove() {}
        });
    }

    @Override
    public GameObject createPawn(Pair<Integer, Integer> position) {
        return new Pawn(position, new MovementStrategy() {
            @Override
            public boolean canMove(Pair<Integer, Integer> currentPosition, int row, int col) {
                return false;
            }

            @Override
            public void onMove() {}
        });
    }
}

