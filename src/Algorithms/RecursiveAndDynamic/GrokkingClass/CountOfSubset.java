package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class CountOfSubset {
    public static int countOfSubset(int[] nums, int target) {
        int sum = 0;
        for(int num:nums)
            sum+=num;
        return countOfSubset(nums, target, 0, 0, new Integer[nums.length][sum+1]);
    }

    public static int countOfSubset(int[] nums, int target, int index, int sum, Integer[][] dp) {
        if (sum == target){
           return 1;
        }

        if (nums.length == 0 || index >= nums.length) {
            return 0;
        }
        int countOne = 0;
        int countTwo =0;
        if(dp[index][sum] == null){
            countOne = countOfSubset(nums, target, index + 1, sum + nums[index],dp);
            countTwo = countOfSubset(nums, target, index + 1, sum,dp);
            dp[index][sum] = countOne + countTwo;
        }


        return  dp[index][sum];
    }
}
