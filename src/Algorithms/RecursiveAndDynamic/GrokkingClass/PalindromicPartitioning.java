package Algorithms.RecursiveAndDynamic.GrokkingClass;

import java.util.Collections;
import java.util.PriorityQueue;

public class PalindromicPartitioning {

    public static int palindromicPartitioning(String word) {
        boolean[][] isPalindrome = new boolean[word.length()][word.length()];

        for (int i = 0; i < word.length(); i++) {
            isPalindrome[i][i] = true;
        }

        for (int startIndex = word.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < word.length(); endIndex++) {
                if (word.charAt(startIndex) == word.charAt(endIndex)) {
                    if (endIndex - startIndex == 1 || isPalindrome[startIndex + 1][endIndex - 1])
                        isPalindrome[startIndex][endIndex] = true;
                }
            }
        }

        int[] cuts = new int[word.length()];

        for (int startIndex = word.length() - 1; startIndex >= 0; startIndex--) {
            int mincut = word.length();
            for (int endIndex = word.length() - 1; endIndex >= startIndex; endIndex--) {
                if (isPalindrome[startIndex][endIndex])
                    mincut = endIndex == word.length() -1 ? 0 : Math.min(mincut, 1 + cuts[endIndex + 1]);
            }
            cuts[startIndex] = mincut;
        }
        return cuts[0];

    }


}
