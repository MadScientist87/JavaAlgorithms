package Games;

import Algorithms.BloomBerg.CandyCrush;
import Algorithms.BloomBerg.FindTheWinner;
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

    @Test
    public void CandyCrush() {
        CandyCrush cc = new CandyCrush();
        int[][] board = new int[][] {{110,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},{5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}};
        int[][] boardResult = cc.candyCrush(board);
    }

    @Test
    public void FindTheWinner() {
        FindTheWinner findTheWinner = new FindTheWinner();
        int answer = findTheWinner.findTheWinner(5,3);

        //Assert.assertEquals(answer, 3);
        System.out.println();

    }
}
