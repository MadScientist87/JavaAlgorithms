package Algorithms.RecursiveAndDynamic.UdemyClass;

public class MinCostToJumpOverStones {
    // stone array
    /*[,20,30,40,25,15,20,28]*/
    // First cell is empty

    public static int minCostToJumpOverStones(int[] stones, int maxJumps ){
        int length = stones.length;
        int[] dp = new int[length];

        for(int i =1; i < length;i++){
                dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= Math.min(maxJumps, i); j++){
                dp[i] = Math.min(dp[i], dp[i-j] +stones[i]);
            }
        }
        return dp[length -1];
    }
}
