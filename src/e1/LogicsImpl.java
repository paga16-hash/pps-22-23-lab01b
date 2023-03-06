package e1;

import e1.gameObjects.GameObject;
import e1.gameObjects.factory.GameObjectFactory;
import e1.gameObjects.factory.GameObjectFactoryImpl;
import e1.gameObjects.utils.Pair;

import java.net.StandardSocketOptions;
import java.util.*;

public class LogicsImpl implements Logics {

	private final GameObjectFactory gameObjectFactory = new GameObjectFactoryImpl();
	private final GameObject knight;
	private final GameObject pawn;
	private final Random random = new Random();
	private final int size;

    public LogicsImpl(int size) {
    	this.size = size;
		this.pawn = gameObjectFactory.createPawn(randomEmptyPosition());
		this.knight = gameObjectFactory.createKnight(randomEmptyPosition());
    }

	public LogicsImpl(int size, Pair<Integer, Integer> pawnPos, Pair<Integer, Integer> knightPos) {
		this.size = size;
		this.pawn = gameObjectFactory.createPawn(pawnPos);
		this.knight = gameObjectFactory.createKnight(knightPos);
	}

	//TODO da spostare nel gestore del gioco, dove ci saranno gli hasPawn, hasQualcosa ecc...
	private final Pair<Integer,Integer> randomEmptyPosition() {
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	return this.pawn != null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }

	@Override
	public boolean hit(int row, int col) {
		knight.move(row, col);
		return checkVictory();
	}

	private boolean checkVictory() {
		return this.pawn.getPosition().equals(this.knight.getPosition());
	}

	@Override
	public boolean hasKnight(int row, int col) {
		System.out.println("Pos: -> " + this.knight.getPosition());
		return this.knight.getPosition().equals(new Pair<>(row, col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}
}
