package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class MinJumpsWithFee {
    // recursive
    public static int minimumJumpsToReachEnd(int[] fees, int index, int maxStairCount) {
        if (index > fees.length - 1)
            return 0;

        int minFee = Integer.MAX_VALUE;
        int maxSteps = maxStairCount;
        while (maxSteps > 0) {
            minFee = Math.min(minFee,  fees[index]+ minimumJumpsToReachEnd(fees, maxSteps + index, maxStairCount));
            maxSteps -= 1;
        }
        return minFee == Integer.MAX_VALUE ? -1 : minFee;
    }

    // top down
    public static int minimumJumpsToReachEnd(int[] fees, int index, int maxStairCount, Integer[] dp) {
        if (index > fees.length - 1)
            return 0;

        if (dp[index] != null) {
            return dp[index];
        }

        int minFee = Integer.MAX_VALUE;
        int maxSteps = maxStairCount;
        while (maxSteps > 0) {
            minFee = Math.min(minFee,  fees[index]+ minimumJumpsToReachEnd(fees, maxSteps + index, maxStairCount,dp));
            maxSteps -= 1;
        }
        dp[index] = minFee;
        return dp[index] == Integer.MAX_VALUE ? -1 : dp[index];
    }

    // Bottom up approach
    public static int minimumJumpsToReachEnd(int[] fees) {
        int[] dp = new int[fees.length +1];
        dp[0] = 0;
        dp[1] = fees[0];
        dp[2] = dp[3] = fees[0];

        for(int i = 3; i < fees.length;i++ ){
            dp[i+1] = Math.min(dp[i] + fees[i],Math.min( dp[i-1] + fees[i-1],dp[i-2] + fees[i-2]) );
        }
        return dp[fees.length];
    }
}
