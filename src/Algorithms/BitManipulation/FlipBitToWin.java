package Algorithms.BitManipulation;

public class FlipBitToWin {

    static int bits = 0;

    public static boolean isBitSet(int num, int position) {
        if (position >= 32)
            return false;

        int shift = 1 << position - 1;

        int shifted = shift & num;
        shifted = shifted >> position - 1;

        return shifted == 1;
    }

    public static int checkBits(int num) {
        for (int i = 1; i < 33; i++) {
            if (!isBitSet(num, i)) {
                expandAroundCenter(num,i);
            }
        }
        return bits;
    }

    public static void expandAroundCenter(int num, int position) {
        int i = position-1, j = position + 1;
        boolean jFoundZero = false;
        boolean iFoundZero = false;
        int currentBits = 0;
        while (i > 0 || j <= 32) {

            if (j <= 32 && !jFoundZero) {
                if (isBitSet(num, j))
                    currentBits++;
                else
                    jFoundZero = true;

            }
            if(i > 0 && !iFoundZero) {
                if (isBitSet(num, i))
                    currentBits++;
                else
                    iFoundZero = true;

            }
            i--;
            j++;
        }

       bits =  Math.max(currentBits + 1,bits);
    }
}
