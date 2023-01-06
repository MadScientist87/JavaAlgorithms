package Algorithms.MathAndLogic;

public class IntegerPalindrome {
    public static boolean isPalindrome(int x) {
        if(x == 10 || x < 0)
            return false;

        int reversedInt = 0;
        int originalInt = x;
        while(x > 0){
            reversedInt = reversedInt * 10 + x % 10;
            x = x /10;
        }

        return (originalInt == reversedInt || originalInt == reversedInt / 10);
    }
}
