package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LogicsImplTest {

    private static final int SIZE = 5;
    private Logics logic;

    @BeforeEach
    public void initGUI() {
        Pair<Integer,Integer> pawnPos = new Pair<>(2, 1);
        Pair<Integer,Integer> knightPos = new Pair<>(0, 0);
        this.logic = new LogicsImpl(SIZE, pawnPos, knightPos);
    }

    //test to do: easy movement, position out of bound, .

    @Test
    public void testKnightMove() {
        this.logic.hit(2, 1);
        assertTrue(this.logic.hasKnight(2, 1));
    }


  
}