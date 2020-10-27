package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class MinSubSetSum {
    public static int minSubsetSum(int[] nums, int index, int sumOne, int sumTwo) {
        if (index == nums.length)
            return Math.abs(sumOne - sumTwo);

        int diffOne = minSubsetSum(nums, index + 1, sumOne + nums[index], sumTwo);
        int diffTwo = minSubsetSum(nums, index + 1, sumOne, sumTwo + nums[index]);

        return Math.min(diffOne, diffTwo);
    }


    public static int minSubsetSum(int[] nums, int index, int sumOne, int sumTwo, Integer[][] dp) {
        if (index == nums.length) {
            return Math.abs(sumOne - sumTwo);
        }

        if (dp[index][sumOne] == null) {
            int diffOne = minSubsetSum(nums, index + 1, sumOne + nums[index], sumTwo);
            int diffTwo = minSubsetSum(nums, index + 1, sumOne, sumTwo + nums[index]);
            dp[index][sumOne] = Math.min(diffOne, diffTwo);
        }

        return dp[index][sumOne];
    }


    public static int canPartitionOptimizedTwo(int[] nums) {
       int sum = 0;

       for(int num:nums){
           sum+=num;
       }

       boolean[][] dp = new boolean[nums.length][(sum/2) +1];

       for(int i = 0; i < nums.length; i++){
           dp[i][0] = true;
       }

       for(int i = 0; i <= sum/2;i++){
           if(nums[0] == i)
           dp[0][i] = true;
       }

       for(int i = 1; i < nums.length; i++){
           for(int j = 1; j <= sum/2; j++){

               if(dp[i-1][j]){
                   dp[i][j] = true;
               }
               else if(j>=nums[i]){
                   if(dp[i-1][j-nums[i]]){
                       dp[i][j] =true;
                   }
               }
           }
       }

       int sum1 = 0;
       for(int i = 0; i <= sum/2; i++){
           if(dp[nums.length-1][i])
               sum1 = i;
       }
       int sum2 = sum - sum1;

       return Math.abs(sum1 - sum2);
    }
}
