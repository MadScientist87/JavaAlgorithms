package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class Fibonacci {
    // recursive
    public static int calculateFibonacci(int n) {
        if (n < 2)
            return n;
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }

    public static int calculateFibonacci(int n, int[] dp) {
        if (n < 2) {
            return n;
        }

        if (dp[n] == 0)
            dp[n] = calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        return dp[n];
    }

    public static int calculateFibonacciBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

    public static int calculateFibonacciBottomUpOptimized(int n) {
        int[] dp = new int[n + 1];
        int n1 = 0;
        int n2 = 1;

        for (int i = 2; i <= n; i++) {
            int temp = n1 + n2;
            n1 = n2;
            n2 = temp;

        }

        return n2;
    }
}
