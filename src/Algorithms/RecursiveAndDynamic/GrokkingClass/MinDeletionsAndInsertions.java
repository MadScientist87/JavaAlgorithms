package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class MinDeletionsAndInsertions {
    public static int[] MinDeletionsAndInsertions(String wordOne, String wordTwo) {
        int length = LongestCommonSubsequence.longestCommonSubsequence(wordOne, wordTwo);
        int[] answer = new int[2];
        answer[0] = wordOne.length() - length;
        answer[1] = wordTwo.length() - length;
        return answer;
    }
}
