package Algorithms.RecursiveAndDynamic;

import java.util.ArrayList;
import java.util.HashSet;

public class Permutations {
    public static HashSet<String> permutations = new HashSet<>();

    public static String swap(String word, int i, int j)
    {
        var wordArray = word.toCharArray();

        var temp = wordArray[i];
        wordArray[i] = wordArray[j];
        wordArray[j] = temp;

        return String.valueOf(wordArray);
    }

    public static void generatePermutation(String word, int left, int right)
    {
        if(left == right)
            permutations.add(word);

        for(int i = left; i <= right; i++)
        {
            word = swap(word,left,i);
            generatePermutation(word,left+1,right);
            word = swap(word,left,i);
        }
    }
}
