package Algorithms.RecursiveAndDynamic.GrokkingClass;

import java.util.Arrays;

public class MaximumRibbonCut {
    // Recursive
    public static int maximumRibbonCut(int[] ribbons, int maxLength, int index) {
        if (ribbons.length == 0 || index >= ribbons.length || maxLength < 0)
            return Integer.MIN_VALUE;

        if (maxLength == 0)
            return 0;
        int countOne = Integer.MIN_VALUE;
        int countTwo = 0;
        if (maxLength >= ribbons[index]) {
            int res = maximumRibbonCut(ribbons, maxLength - ribbons[index], index);
            if (res != Integer.MIN_VALUE)
                countOne = res + 1;
        }

        countTwo = maximumRibbonCut(ribbons, maxLength, index + 1);

        return Math.max(countOne, countTwo);
    }

    // Top down
    public static int maximumRibbonCut(int[] ribbons, int maxLength, int index, Integer[][] dp) {
        if (ribbons.length == 0 || index >= ribbons.length || maxLength < 0)
            return Integer.MIN_VALUE;

        if (maxLength == 0)
            return 0;
        int countOne = Integer.MIN_VALUE;
        int countTwo = 0;
        if (dp[index][maxLength] == null) {
            if (maxLength >= ribbons[index]) {
                int res = maximumRibbonCut(ribbons, maxLength - ribbons[index], index);
                if (res != Integer.MIN_VALUE)
                    countOne = res + 1;
            }
            countTwo = maximumRibbonCut(ribbons, maxLength, index + 1);

            dp[index][maxLength] = Math.max(countOne, countTwo);
        }

        return dp[index][maxLength];
    }

    // Top down
    public static int maximumRibbonCut(int[] ribbons, int maxLength) {
        if (ribbons.length == 0 || maxLength < 0)
            return 0;
        int[] dp = new int[maxLength + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= maxLength; i++) {
            for (int j = 0; j < ribbons.length; j++) {
                if (i >= ribbons[j]) {
                    dp[i] = Math.max(dp[i], dp[i - ribbons[j]] + 1);
                }
            }
        }

        return dp[maxLength] == Integer.MIN_VALUE ? -1 : dp[maxLength];
    }

    // Top down with two d array
    public static int maximumRibbonCut2d(int[] ribbons, int maxLength) {
        if (ribbons.length == 0 || maxLength < 0)
            return 0;
        int[][] dp = new int[ribbons.length][maxLength + 1];

        for (int i = 0; i < ribbons.length; i++) {
            for (int j = 0; j <= maxLength; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < ribbons.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < ribbons.length; i++) {
            for (int j = 1; j <= maxLength; j++) {
                if (i > 0)
                    dp[i][j] = dp[i - 1][j];
                if (j >= ribbons[i] && dp[i][j - ribbons[i]] != Integer.MIN_VALUE)
                    dp[i][j] = Math.max(dp[i][j - ribbons[i]] + 1, dp[i][j]);
            }
        }

        return dp[ribbons.length - 1][maxLength];
    }
}
