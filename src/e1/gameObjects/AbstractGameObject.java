package e1.gameObjects;

import e1.gameObjects.utils.Pair;

public class AbstractGameObject implements GameObject {
    Pair<Integer, Integer> position;

    public AbstractGameObject(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public void initPosition(Integer row, Integer col) {
        this.position = new Pair<>(row, col);
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
}
