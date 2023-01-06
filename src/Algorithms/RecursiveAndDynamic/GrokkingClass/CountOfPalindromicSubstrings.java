package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class CountOfPalindromicSubstrings {
    public static int longestPalindromicSubstring(String word) {
        boolean[][] isPalindrome = new boolean[word.length()][word.length()];
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            isPalindrome[i][i] = true;
            counter++;
        }

        for (int startIndex = word.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < word.length(); endIndex++) {
                if (word.charAt(startIndex) == word.charAt(endIndex)) {
                    if (endIndex - startIndex == 1 || isPalindrome[startIndex + 1][endIndex - 1])
                        isPalindrome[startIndex][endIndex] = true;
                    counter++;
                }
            }
        }
        return counter;
    }


}
