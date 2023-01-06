package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class NumberOfFactors {
    public static int numberOfFactors(int n) {
        if (n == 0)
            return 1; // base case, we don't need to subtract any thing, so there is only one way

        if (n == 1)
            return 1; // we can subtract 1 to be left with zero, and that is the only way

        if (n == 2)
            return 1; // we can subtract 1 twice to get zero and that is the only way

        if (n == 3)
            return 2; // '3' can be expressed as {1,1,1}, {3}

        int countOne = numberOfFactors(n - 1);
        int countTwo = numberOfFactors(n - 3);
        int countThree = numberOfFactors(n - 4);

        return countOne + countTwo + countThree;
    }

    public static int numberOfFactors(int n, Integer[] dp) {
        if (n == 0)
            return 1; // base case, we don't need to subtract any thing, so there is only one way

        if (n == 1)
            return 1; // we can subtract 1 to be left with zero, and that is the only way

        if (n == 2)
            return 1; // we can subtract 1 twice to get zero and that is the only way

        if (n == 3)
            return 2; // '3' can be expressed as {1,1,1}, {3}

        if (dp[n] == null) {
            int countOne = numberOfFactors(n - 1);
            int countTwo = numberOfFactors(n - 3);
            int countThree = numberOfFactors(n - 4);
            dp[n] = countOne + countTwo + countThree;
        }

        return dp[n];
    }

    public static int numberOfFactorsDp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }

        return dp[n];
    }
}
