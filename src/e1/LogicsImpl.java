package e1;

import e1.gameObjects.GameObject;
import e1.gameObjects.Knight;
import e1.gameObjects.Pawn;
import e1.gameObjects.utils.Pair;

import java.util.*;

public class LogicsImpl implements Logics {

	private final Knight knight;
	private final Pawn pawn;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size) {
    	this.size = size;
		this.pawn = new Pawn(this.randomEmptyPosition());
		this.knight = new Knight(this.randomEmptyPosition());
    }

	public LogicsImpl(int size, Pair<Integer, Integer> pawnPos, Pair<Integer, Integer> knightPos) {
		this.size = size;
		this.pawn = new Pawn(pawnPos);
		this.knight = new Knight(knightPos);
	}

	private final Pair<Integer,Integer> randomEmptyPosition() {
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	return this.pawn != null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		//TODO || row >= this.size || col >= this.size
		if(knight.canMove(row, col)) {
			knight.move(row, col);
			return checkVictory();
		}
		return false;
	}

	private boolean checkVictory() {
		return this.pawn.getPosition().equals(this.knight.getPosition());
	}


	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row, col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}
}
