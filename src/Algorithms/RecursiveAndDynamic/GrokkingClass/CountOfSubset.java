package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class CountOfSubset {
    public static int countOfSubset(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        return countOfSubset(nums, target, 0, 0, new Integer[nums.length][sum + 1]);
    }

    public static int countOfSubset(int[] nums, int target, int index, int sum, Integer[][] dp) {
        if (sum == target) {
            return 1;
        }

        if (nums.length == 0 || index >= nums.length) {
            return 0;
        }
        int countOne = 0;
        int countTwo = 0;
        if (dp[index][sum] == null) {
            countOne = countOfSubset(nums, target, index + 1, sum + nums[index], dp);
            countTwo = countOfSubset(nums, target, index + 1, sum, dp);
            dp[index][sum] = countOne + countTwo;
        }


        return dp[index][sum];
    }

    public static int countSubSetSumBottomUp(int[] nums, int target) {
        int sum = target;
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

    public static int countSubSetSumBottomUpLessSpace(int[] nums, int target) {
        int sum = target;
        int dp[] = new int[sum + 1];
        dp[0] = 1;

        for (int i = 1; i <= sum; i++) {
            if (nums[0] == i)
                dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            // count up from the bottom
            for (int j = sum; j >= 0; j--) {

                // include the count if it does not exceed the number
                if (j >= nums[i])
                    dp[j] += dp[j - nums[i]];
            }
        }

        return dp[sum];
    }
}
