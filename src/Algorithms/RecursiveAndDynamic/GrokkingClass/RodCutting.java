package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class RodCutting {
    // Recursive function
    public static int rodCutting(int[] lengths, int[] prices, int rodLength, int index) {
        if (lengths.length != prices.length || rodLength <= 0 || index >= lengths.length)
            return 0;
        int profitOne = 0;
        int profitTwo = 0;

        if (rodLength >= lengths[index])
            profitOne = prices[index] + rodCutting(lengths, prices, rodLength - lengths[index], index);
        profitTwo = rodCutting(lengths, prices, rodLength, index + 1);

        return Math.max(profitOne, profitTwo);
    }

    // top down function
    public static int rodCutting(int[] lengths, int[] prices, int rodLength, int index, Integer[][] dp) {
        if (lengths.length != prices.length || rodLength <= 0 || index >= lengths.length)
            return 0;

        if (dp[index][rodLength] == null) {
            int profitOne = 0;
            int profitTwo = 0;

            if (rodLength >= lengths[index])
                profitOne = prices[index] + rodCutting(lengths, prices, rodLength - lengths[index], index);
            profitTwo = rodCutting(lengths, prices, rodLength, index + 1);
            dp[index][rodLength] = Math.max(profitOne, profitTwo);
        }


        return dp[index][rodLength];
    }


    // Bottom up solution
    public static int rodCutting(int[] lengths, int[] prices, int rodLength) {
        int[][] dp = new int[lengths.length][rodLength + 1];

        for (int i = 0; i < lengths.length; i++) {
            for (int j = 1; j <= rodLength; j++) {
                int profitOne = 0;
                int profitTwo = 0;
                if (j >= lengths[i])
                    profitOne = prices[i] + dp[i][j - lengths[i]];
                if (i > 0)
                    profitTwo = dp[i - 1][j];
                dp[i][j] = Math.max(profitOne, profitTwo);
            }
        }

        return dp[lengths.length - 1][rodLength];
    }
}
