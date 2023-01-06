package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class MinimumJumpsToReachEnd {
    // recursive
    public static int minimumJumpsToReachEnd(int[] nums, int index) {
        if (index >= nums.length - 1)
            return 0;

        int minJump = Integer.MAX_VALUE;
        int maxSteps = nums[index];
        while (maxSteps > 0) {
            minJump = Math.min(minJump, 1 + minimumJumpsToReachEnd(nums, maxSteps + index));
            maxSteps -= 1;
        }
        return minJump == Integer.MAX_VALUE ? -1 : minJump;
    }


    // top Down
    public static int minimumJumpsToReachEnd(int[] nums, int index, Integer[] dp) {
        if (index > nums.length - 1)
            return 0;

        if (dp[index] != null) {
            return dp[index];
        }

        int minJump = Integer.MAX_VALUE;
        int maxSteps = nums[index];
        while (maxSteps > 0) {
            minJump = Math.min(minJump, 1 + minimumJumpsToReachEnd(nums, maxSteps + index));
            maxSteps -= 1;
        }

        dp[index] = minJump;
        return dp[index] = dp[index] == Integer.MAX_VALUE ? -1 : dp[index];
    }

    // Bottom up approach
    public static int minimumJumpsToReachEnd(int[] nums) {
        if (nums.length < 2)
            return 0;

        int jumps = 1;
        int maxSteps = nums[0];
        int maxPosition = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // from the initial start continue looping until we reach the maxSteps we can travel
            // while looping we have already calculated the maxPosition we can arrive at by using
            // indexes between 1 and max steps.
            if (maxSteps < i) {
                ++jumps;
                maxSteps = maxPosition;
            }
            // Increase the max position we can go by adding the current index + the number of steps we can go
            // Compare that against the max number of steps we can already travel
            maxPosition = Math.max(maxPosition, nums[i] + i);
        }

        return jumps;
    }
}
