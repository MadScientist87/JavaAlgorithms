package Algorithms.BitManipulation;

public class Conversion {
    public static int numberOfBitsNeededToConvert(int numOne, int numTwo)
    {
        int diff = 0;
        for(int i = 1;i < 33;i++)
        {
            if(isBitSet(numOne,i) != isBitSet(numTwo, i))
                diff++;
        }
        return diff;
    }

    public static boolean isBitSet(int num, int position) {
        if (position >= 32)
            return false;

        int shift = 1 << position - 1;

        int shifted = shift & num;
        shifted = shifted >> position - 1;

        return shifted == 1;
    }
}
