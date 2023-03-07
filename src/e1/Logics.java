package e1;

import e1.gameObjects.GameEntity;

public interface Logics {

    /**
     * attempt to move Knight on position row,col, if possible
     *
     * @param row row
     * @param col col
     * @return whether the pawn has been hit
     */
    boolean hit(int row, int col);

    /**
     * @param row row
     * @param col col
     * @return whether position row,col has the passed GameEntity
     */
    boolean hasGameObject(GameEntity gameEntity, int row, int col);
}
