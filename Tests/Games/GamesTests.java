package Games;

import Algorithms.Games.TicTacToe;
import Algorithms.Graphs.MinHeap;
import org.junit.Assert;
import org.junit.Test;

public class GamesTests {
    @Test
    public void ticTacToe() {
        TicTacToe obj = new TicTacToe(2);
  obj.move(0,1,1);
        obj.move(1,1,2);
        obj.move(1,0,1);
    }
}
