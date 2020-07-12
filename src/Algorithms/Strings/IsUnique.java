package Algorithms.Strings;

import java.util.Arrays;

public class IsUnique {
    public static boolean IsAllCharactersUnique(String phrase)
    {
        char[] cArray = phrase.toCharArray();
        Arrays.sort(cArray);
        for (int current = 1; current < phrase.length(); current++) {
            int previous = current - 1;
            if(cArray[current] == cArray[previous])
                return false;
        }
        return  true;
    }
}


