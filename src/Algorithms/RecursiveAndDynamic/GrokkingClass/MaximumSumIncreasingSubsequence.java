package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class MaximumSumIncreasingSubsequence {
    public static int maximumSumIncreasingSubsequence(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j] + nums[i]) {
                    dp[i] = dp[j] + nums[i];
                }
            }
            maxSum = Math.max(dp[i], maxSum);
        }

        return maxSum;
    }
}
