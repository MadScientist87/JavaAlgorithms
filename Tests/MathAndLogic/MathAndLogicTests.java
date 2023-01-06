package MathAndLogic;

import Algorithms.BloomBerg.MatrixMultiplication;
import Algorithms.MathAndLogic.*;
import Algorithms.MathAndLogic.SieveOfEratosthenes;
import Algorithms.Sorting.MyBubbleSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void mostVisitedPattern() {
        String[] username = new String[]{"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = new int[]{1,2,3,4,5,6,7,8,9,10};
        String[] website = new String[]{"home","about","career","home","cart","maps","home","home","about","career"};
        List<String> answer = MostVisitedPattern.mostVisitedPattern(username,timestamp,website);
        System.out.println();
        //Assert.assertTrue(answer);

    }

    @Test
    public void fastExponentiation() {
        double answer = FastExponentiation.myPow(2,-3);
        System.out.println();
        //Assert.assertTrue(answer);

    }

    @Test
    public void integerPalindrome() {
        boolean answser = IntegerPalindrome.isPalindrome(5);
        System.out.println();
        //Assert.assertTrue(answer);

    }

    @Test
    public void MatrixMultiplication() {
        MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
        int[][] mat1 = new int[][] {{1,-5}};
        int[][] mat2 = new int[][] {{12},{-1}};

        matrixMultiplication.multiply(mat1,mat2);

    }
}
