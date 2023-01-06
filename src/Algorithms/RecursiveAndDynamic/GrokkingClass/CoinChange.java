package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class CoinChange {
    // Recursive
    public static int coinChange(int[] coins, int target, int index) {
        if (target == 0)
            return 1;
        if (index >= coins.length || target <= 0)
            return 0;
        int countOne = 0;
        int countTwo = 0;
        if (target >= coins[index])
            countOne = coinChange(coins, target - coins[index], index);
        countTwo = coinChange(coins, target, index + 1);

        return countOne + countTwo;
    }

    // Recursive top down
    public static int coinChange(int[] coins, int target, int index, Integer[][] dp) {
        if (target == 0)
            return 1;
        if (index >= coins.length || target <= 0)
            return 0;
        if (dp[index][target] == null) {
            int countOne = 0;
            int countTwo = 0;
            if (target >= coins[index])
                countOne = coinChange(coins, target - coins[index], index);
            countTwo = coinChange(coins, target, index + 1);
            dp[index][target] = countOne + countTwo;
        }

        return dp[index][target];
    }

    // bottom up
    public static int coinChange(int[] coins, int target) {
        if (coins.length == 0 || target <= 0)
            return 0;

        Integer[][] dp = new Integer[coins.length][target + 1];

        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= target; j++) {

                if (j >= coins[i])
                    dp[i][j] = dp[i][j - coins[i]] + 1;
                if (i > 0)
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[coins.length - 1][target];
    }
}
