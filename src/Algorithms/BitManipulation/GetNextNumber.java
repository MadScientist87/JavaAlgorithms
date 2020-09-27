package Algorithms.BitManipulation;

public class GetNextNumber {
    public static int getNext(int num)
    {
        int c = num;
        int c1 = 0;
        int c0 = 0;

        while (c != 0 && (c & 1) == 0)
        {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1){
            c1++;
            c = c >> 1;
        }

        if(c1 + c0 == 0 || c1 > 31)
            return - 1;

        int p = c1 + c0;

        num |= 1 << p; // sets the leftmost zero bit to 1
        num &= ~((1 << p) -1); // sets all bits after the p bit to zero
        /* takes all the 1 bits we counted and shifts into position. We subtract one to account
           for the one we just added. We then subtract one after the shift to fill the rest of the
           slots with ones. We or this with the num to fill in the rest of the number.
         */
        num |= (1 << c1 -1) -1;

        return num;
    }

    public static int getPrev(int num)
    {
        int c = num;
        int countOfZeros = 0;
        int countOfOnes = 0;


        while ((c & 1) == 1){
            countOfOnes++;
            c = c >> 1;
        }

        if(countOfOnes == 0)
            return -1;

        while ((c & 1) == 0 && c !=0){
            countOfZeros++;
            c = c >> 1;
        }

        int p = countOfOnes + countOfZeros;
        num &= (~(0) << p + 1); // clear bits zero through p
        int mask = (1 << countOfOnes + 1) - 1; // create mask from the count of ones
        // shift the mask up by the number of zeros and or the mask against the number
        num |= (mask << countOfZeros - 1);
        return num;
    }
}
