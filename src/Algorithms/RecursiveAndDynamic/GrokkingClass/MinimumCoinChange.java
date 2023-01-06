package Algorithms.RecursiveAndDynamic.GrokkingClass;

import java.util.Arrays;

public class MinimumCoinChange {

    // Recursive
    public static int minimumCoinChange(int[] coins, int target, int index) {
        if (target == 0)
            return 0;
        if (index >= coins.length || coins.length == 0)
            return Integer.MAX_VALUE;
        int countOne = Integer.MAX_VALUE;

        if (target >= coins[index]){
            int res = minimumCoinChange(coins, target - coins[index], index);
            if(res != Integer.MAX_VALUE)
                countOne = res +1;

        }
        int countTwo = minimumCoinChange(coins, target, index + 1);

        return Math.min(countOne,countTwo);
    }

    public static int minimumCoinChange(int[] coins, int amount) {
        int[] dp = new int[amount +1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {

                if (i >= coins[j])
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }

        }
        return dp[amount - 1] == max ? -1: dp[amount -1];
    }
}
