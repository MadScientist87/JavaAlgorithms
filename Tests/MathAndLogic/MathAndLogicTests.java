package MathAndLogic;

import Algorithms.MathAndLogic.*;
import Algorithms.MathAndLogic.SieveOfEratosthenes;
import Algorithms.Sorting.MyBubbleSort;
import org.junit.Assert;
import org.junit.Test;

public class MathAndLogicTests {
    @Test
    public void sieveOfEratosthenes() {
        var answer = SieveOfEratosthenes.sieveOfEratosthenes(4);
        Assert.assertArrayEquals(answer, new boolean[]{false, false, true, true, false});
    }

    @Test
    public void gcd() {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        int answer = gcd.gcd(10, 4);
        Assert.assertEquals(answer, 2);

    }

    @Test
    public void isRectangle() {
        boolean answer = IsRectangleFromPoints.isRectangle(new Point(1,0), new Point(3,0), new Point(1,2), new Point(3,2));
        Assert.assertTrue(answer);

    }

}
