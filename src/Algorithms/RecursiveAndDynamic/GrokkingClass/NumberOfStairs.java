package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class NumberOfStairs {
    public static int numberOfStairs(int n) {
        if (n < 2)
            return 1;
        if (n == 2)
            return 2;
        return numberOfStairs(n - 1) + numberOfStairs(n - 2) + numberOfStairs(n - 3);
    }

    public static int numberOfStairs(int n, int[] dp) {
        if (n < 2)
            return 1;
        if (n == 2)
            return 2;
        if (dp[n] == 0)
            dp[n] = numberOfStairs(n - 1) + numberOfStairs(n - 2) + numberOfStairs(n - 3);
        return dp[n];
    }

    public static int numberOfStairsDp(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i -1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    public static int numberOfStairsDpOptimized(int n){
        int[] dp = new int[n+1];
        int n1 =1;
        int n2 =1;
        int n3 =2;

        for(int i = 3; i <= n; i++){
           int temp= n1 + n2 + n3;
           n1 = n2;
           n2 = n3;
           n3 = temp;
        }
        return n3;
    }
}
