package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class HouseThief {
    // recursive
    public static int robHouses(int[] profit, int index) {
        if (index >= profit.length)
            return 0;
        int currentHouse = profit[index] + robHouses(profit, index + 2);
        int skipCurrent = robHouses(profit, index + 1);
        int winnings = Math.max(currentHouse,skipCurrent );

        return winnings;
    }

    // top down
    public static int robHouses(int[] profit, int index, Integer[] dp) {
        if (index >= profit.length)
            return 0;

        if(dp[index] != null)
            return dp[index];

        int currentHouse = profit[index] + robHouses(profit, index + 2);
        int skipCurrent = robHouses(profit, index + 1);
        dp[index] = Math.max(currentHouse,skipCurrent );

        return dp[index];
    }

    public static int robHouses(int[] profit) {
        if(profit.length == 0) return 0;
        if(profit.length ==1 ) return profit[0];
        int[] dp = new int[profit.length +1];
        dp[0] = 0;
        dp[1] = profit[0];

        for(int i = 2; i <= profit.length;i++){
            dp[i] = Math.max(profit[i-1] +dp[i-2],dp[i-1]);
        }
        return dp[profit.length];
    }
}
