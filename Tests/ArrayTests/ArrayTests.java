package ArrayTests;

import Algorithms.Arrays.MaximumUnits;
import Algorithms.BloomBerg.BrowserHistory;
import Algorithms.Graphs.BSTUtility;
import Algorithms.Graphs.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class ArrayTests {

    @Test
    public void MaximumUnits() {
        int[][] boxTypes = new int[][]{{4,2},{5,5},{4,1},{1,4},{2,5},{1,3},{5,3},{1,5},{5,5},{1,1}};
        MaximumUnits.maximumUnits(boxTypes, 24);
    }

    @Test
    public void BrowserHistory() {
        BrowserHistory b = new BrowserHistory("jrbilt.com");
        b.visit("uiza.com");
        b.forward(3);
        b.forward(3);
        b.visit("fveyl.com");
        b.visit("hyhqfqf.com");
        b.back(3);
        b.visit("cccs.com");
        b.visit("bivz.com");
        b.forward(6);
        b.back(1);

        System.out.println();
    }
}
