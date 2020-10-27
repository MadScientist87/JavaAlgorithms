package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class EqualSubsetPartition {
    static boolean found = false;

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 0)
            return helper(nums, sum / 2, 0);
        return false;

    }

    public static boolean helper(int[] nums, int sum, int index) {
        if (sum == 0)
            return true;
        if (index >= nums.length || nums.length == 0)
            return false;

        if (sum >= nums[index]) {
            if (helper(nums, sum - nums[index], index+1) == true)
                return true;
        }

        return helper(nums, sum, index+1);
    }

    public static boolean canPartitionOptimized(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 0) {
            Boolean[][] dp = new Boolean[nums.length][(sum / 2) + 1];
            return helperOptimized(nums, sum / 2, 0, dp);
        }

        return false;

    }

    public static boolean helperOptimized(int[] nums, int sum, int index, Boolean[][] dp) {
        if (sum == 0)
            return true;
        if (index >= nums.length || nums.length == 0)
            return false;

        if (dp[index][sum] == null) {
            if (sum >= nums[index]) {
                if (helperOptimized(nums, sum - nums[index], index++, dp) == true) {
                    dp[index][sum] = true;
                    return true;
                }
            }
        }

        dp[index][sum] = helperOptimized(nums, sum, index++, dp);
        return dp[index][sum];
    }

    public static boolean canPartitionOptimizedTwo(int[] nums) {
        int sum = 0;


        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;
        boolean dp[][] = new boolean[nums.length][sum + 1];

        // Setup first column, Set all rows of first column to true as they represent when no sum is
        // computed, zero can always be computed from nothing
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        // setup first row, check to see if item is equal to sum
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = nums[0] == i;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                // if the value above is == to the current sum set the current combo of sum and num value to true
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else {
                    // check if the current sum - the num value of the previous row is true or false and fill in the
                    // current value. E.G. if the current sum is 3 and the num value is two, check the row above
                    // for the sum of 1 and see what the value is there. That should tell you if you can
                    // make 3 from 1 and 2
                    if (j >= nums[i])
                        dp[i][j] = dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][sum];
    }
}
