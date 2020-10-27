package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class SubsetSum {
    public static boolean isSubSet(int[] nums, int sum, int index) {

        if (sum == 0) return true;

        if (index >= nums.length || nums.length == 0) return false;

        if (sum >= nums[index])
            if (isSubSet(nums, sum - nums[index], index + 1))
                return true;

        return isSubSet(nums, sum, index + 1);
    }

    public static boolean isSubSet(int[] nums, int sum) {
        return isSubSet(nums, sum, 0);
    }

    public static boolean isSubSetOptimized(int[] nums, int sum) {
        Boolean dp[][] = new Boolean[nums.length][sum + 1];
        return isSubSetOptimized(nums, sum, 0, dp);
    }

    public static boolean isSubSetOptimized(int[] nums, int sum, int index, Boolean[][] dp) {

        if (sum == 0) return true;

        if (index >= nums.length || nums.length == 0) return false;

        if (dp[index][sum] == null) {
            if (sum >= nums[index])
                if (isSubSet(nums, sum - nums[index], index + 1)) {
                    dp[index][sum - nums[index]] = true;
                    return true;
                }
        }

        dp[index][sum] = isSubSet(nums, sum, index + 1);
        return dp[index][sum];
    }

    public static boolean isSubSetOptimizedBottomUp(int[] nums, int sum) {
        boolean dp[][] = new boolean[nums.length][sum + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            if (nums[0] == i)
                dp[0][i] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (dp[i - 1][sum]) {
                    dp[i][j] = true;
                } else {
                    if (j >= nums[i])
                        if (dp[i - 1][j - nums[i]]) {
                            dp[i][j] = true;
                        }
                }
            }
        }
        return dp[nums.length - 1][sum];
    }
}
