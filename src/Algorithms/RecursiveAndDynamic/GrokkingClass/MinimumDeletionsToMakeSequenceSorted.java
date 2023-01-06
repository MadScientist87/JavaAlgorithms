package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class MinimumDeletionsToMakeSequenceSorted {

    public static int minDeletions(int[] nums){
        if(nums.length == 0)
            return 0;

        int lis = longestIncreasingSubSequence(nums);
        return nums.length - lis;
    }

    public static int longestIncreasingSubSequence(int[] nums){
        if(nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int maxLength = 1;
        // set first dp cell to one because we start at j = 0 if the first i we encounter is greater than j we
        // we have a subsequence of length 2 already
        dp[0] =1;
        for(int i = 1; i < nums.length;i++){
            dp[i] =1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                    maxLength = Math.max(maxLength,dp[i]);
                }
            }
        }
        return maxLength;
    }
}
