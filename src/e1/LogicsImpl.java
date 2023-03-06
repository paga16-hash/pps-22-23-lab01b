package e1;

import e1.gameObjects.GameObject;
import e1.gameObjects.Knight;
import e1.gameObjects.Pawn;
import e1.gameObjects.utils.Pair;

import java.util.*;

public class LogicsImpl implements Logics {
	
	//private final Pair<Integer,Integer> pawn;
	//private Pair<Integer,Integer> knight;
	private GameObject knight;
	private final GameObject pawn;
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
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn != null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if(canMove(row, col)){
			move(row, col);
			return onMove();
		}
		return false;
	}

	private boolean onMove() {
		return this.pawn.getPosition().equals(this.knight.getPosition());
	}

	private void move(int row, int col) {
		int x = row - this.knight.getX();
		int y = col - this.knight.getY();
		if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
			this.knight = new Knight(new Pair<>(row, col));
		}
	}

	private boolean canMove(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		return true;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}
}
