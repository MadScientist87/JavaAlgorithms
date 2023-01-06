package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class LongestPalindromicSubsequence {
    // recursive
    public static int longestPalindromicSubsequence(String st, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        if (startIndex == endIndex)
            return 1;

        if (st.charAt(startIndex) == st.charAt(endIndex))
            return 2 + longestPalindromicSubsequence(st, startIndex + 1, endIndex - 1);

        int c1 = longestPalindromicSubsequence(st, startIndex + 1, endIndex);
        int c2 = longestPalindromicSubsequence(st, startIndex, endIndex - 1);
        return Math.max(c1, c2);
    }

    //TopDown
    public static int longestPalindromicSubsequence(Integer[][] dp, String st, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        if (startIndex == endIndex)
            return 1;

        if (dp[startIndex][endIndex] == null) {
            if (st.charAt(startIndex) == st.charAt(endIndex))
                dp[startIndex][endIndex] = 2 + longestPalindromicSubsequence(dp, st, startIndex + 1, endIndex - 1);
            else {
                int c1 = longestPalindromicSubsequence(dp, st, startIndex + 1, endIndex);
                int c2 = longestPalindromicSubsequence(dp, st, startIndex, endIndex - 1);
                dp[startIndex][endIndex] = Math.max(c1, c2);
            }

        }

        return dp[startIndex][endIndex];
    }

    // Bottom up
    public static int longestPalindromicSubsequence(String st) {
        int[][] dp = new int[st.length()][st.length()];

        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = 1;
        }

        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex +1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
                } else {
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
            }
        }
        return dp[0][st.length() - 1];
    }

}
