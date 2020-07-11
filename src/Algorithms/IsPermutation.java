package Algorithms;

import java.util.Arrays;

public class IsPermutation {
    public static boolean IsWordAPermutation(String phraseOne, String prhaseTwo )
    {
        if(phraseOne.length()!= prhaseTwo.length())
            return false;

        char[] cArrayOne = phraseOne.toCharArray();
        char[] cArrayTwo = prhaseTwo.toCharArray();
        Arrays.sort(cArrayOne);
        Arrays.sort(cArrayTwo);
        for (int i = 0; i < phraseOne.length(); i++) {

            if(cArrayOne[i] != cArrayTwo[i])
                return false;
        }
        return  true;
    }
}
