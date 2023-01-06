package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class MinimumDeletionsInAStringPalindrome {
    // recursive
    public static int minimumDeletionsInAStringPalindrome(String st, int startIndex, int endIndex) {
       int len  = LongestPalindromicSubsequence.longestPalindromicSubsequence(st);
       return st.length() - len;
    }
}
