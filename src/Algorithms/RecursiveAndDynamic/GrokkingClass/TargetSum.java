package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class TargetSum {
    public static int countSubSetSumBottomUp(int[] nums, int target) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum < target || (target + sum) % 2 != 0)
            return 0;

        sum = (target + sum) / 2;

        int dp[][] = new int[nums.length][sum + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= sum; i++) {
            if (nums[0] == i)
                dp[0][i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                // exclude the count
                dp[i][j] = dp[i - 1][j];
                // include the count if it does not exceed the number
                if (j >= nums[i])
                    dp[i][j] += dp[i - 1][j - nums[i]];
            }
        }

        return dp[nums.length - 1][sum];
    }
}
