package BitManipulation;

import org.junit.Assert;
import org.junit.Test;

public class BitManipulationTests {
    @Test
    public void insertion() {


        var answer = Algorithms.BitManipulation.Insertion.insertNumber(1088,19,2,6);

        Assert.assertEquals(answer, 1100);

        answer = Algorithms.BitManipulation.Insertion.insertNumber(1024,19,2,6);

        Assert.assertEquals(answer, 1100);

        answer = Algorithms.BitManipulation.Insertion.insertNumber(1027,19,2,6);

        Assert.assertEquals(answer, 1103);
    }

    @Test
    public void printBinaryToString() {
        var answer = Algorithms.BitManipulation.BinaryToString.printBinary(0.72, 3);
        System.out.println();
    }

    @Test
    public void flipBitToWin() {
        var answer = Algorithms.BitManipulation.FlipBitToWin.checkBits(1775);
        System.out.println();
    }

    @Test
    public void conversion() {
        var answer = Algorithms.BitManipulation.Conversion.numberOfBitsNeededToConvert(29,15);
        System.out.println();
    }

    @Test
    public void nextNumber() {
        var answer = Algorithms.BitManipulation.GetNextNumber.getNext(5);
        System.out.println();
    }
}
