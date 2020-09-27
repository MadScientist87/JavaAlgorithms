package Algorithms.BitManipulation;

public class Insertion {
    public static int insertNumber(int n, int m, int i, int j)
    {
        // Clear the bits i through j
        n = clearBitIthroughJ(i,n,j);

        // shift m up the number of lower places i.e 2
        // Then or it against the original number so we can see it inserted.
        n = n | (m << i);

        return n;
    }

    public static int clearBit(int i, int n)
    {
        n = n & ~(1<<i);

        return n;
    }

    public static int clearBitIthroughJ(int i, int n, int j)
    {
        // This gives us a mask of all 1s in equal to the distance of j - i, i.e. 6 - 2 is 4 (1111)
        // (1111) is 15 in binary
        int mask = (2 ^ (j -i)) -1;

        // We shift the mask into place then negate the mask. This will give us the opposite
        // so when we & we should zero out all the places in n that we designated by the mask
        n = n & ~(mask<<i);

        return n;
    }
}
