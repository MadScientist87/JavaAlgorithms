package Algorithms.RecursiveAndDynamic;

import java.util.ArrayList;
import java.util.List;

public class MakeChange {
    public static int counter = 0;
    public static int makeChange(int[] denominations, int amount, int index){
        if(index >= denominations.length-1) {
            return 1;
        }

        int denomAmount = denominations[index];
        int ways = 0;

        for(int i =0;i * denomAmount <= amount;i++){
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(denominations,amountRemaining,index +1);
        }

        return ways;
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private static int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
