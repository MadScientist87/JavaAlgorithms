package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class LongestIncreasingSubsequence {
    // recursive
    public static int longestIncreasingSubsequence(int[] nums, int currentIndex, int previousIndex) {

        if (currentIndex == nums.length)
            return 0;

        int c1 = 0;

        if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
            c1 = 1 + longestIncreasingSubsequence(nums, currentIndex + 1, currentIndex);


        int c2 = longestIncreasingSubsequence(nums, currentIndex + 1, previousIndex);

        return Math.max(c1, c2);
    }

    // top down
    public static int longestIncreasingSubsequence(int[] nums, int currentIndex, int previousIndex, Integer[][] dp) {

        if (currentIndex == nums.length)
            return 0;

        if (dp[currentIndex][previousIndex + 1] == null) {
            int c1 = 0;

            if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
                c1 = 1 + longestIncreasingSubsequence(nums, currentIndex + 1, currentIndex);


            int c2 = longestIncreasingSubsequence(nums, currentIndex + 1, previousIndex);

            dp[currentIndex][previousIndex + 1] = Math.max(c1, c2);
        }
        return dp[currentIndex][previousIndex + 1];
    }

    // Bottom up
    public static int longestIncreasingSubsequence(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){

                // 10,22,9,33,21,50,41,60,80
                // In this sequence when i is at place 33 and j is starting a index zero, 33 is greater than 10,22, and
                // 9. However 9 is not increasing. the secondary check of dp[i] <= dp[j] checks if the dp before (index j) has a
                // greater increasing subsequence than the current dp at index i. If the index previous (j) is not greater
                // then that means dp at j is not increasing
                if(nums[i] > nums[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j]+1;
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }
}
