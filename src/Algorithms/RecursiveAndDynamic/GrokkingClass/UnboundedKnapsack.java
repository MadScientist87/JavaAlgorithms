package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class UnboundedKnapsack {
    // Recursive function
    public static int unboundedKnapsack(int[] weight, int[] profit, int capacity, int index) {
        if (profit.length == 0 || capacity == 0 || (weight.length != profit.length) || index>= profit.length)
            return 0;
        int profitOne = 0;
        int profitTwo = 0;
        if (capacity >= weight[index])
            profitOne = profit[index] + unboundedKnapsack(weight, profit, capacity - weight[index], index);

        profitTwo = unboundedKnapsack(weight, profit, capacity, index + 1);
        return Math.max(profitOne, profitTwo);
    }

    // top down function
    public static int unboundedKnapsack(int[] weight, int[] profit, int capacity, int index, Integer[][] dp) {
        if (profit.length == 0 || capacity == 0 || (weight.length != profit.length) || index>= profit.length)
            return 0;
        if(dp[index][capacity] == null){
            int profitOne = 0;
            int profitTwo = 0;
            if (capacity >= weight[index])
                profitOne = profit[index] + unboundedKnapsack(weight, profit, capacity - weight[index], index);

            profitTwo = unboundedKnapsack(weight, profit, capacity, index + 1);
            dp[index][capacity] = Math.max(profitOne,profitTwo);
        }

        return dp[index][capacity];
    }

    public static int unboundedKnapsack(int[] weight, int[] profit, int capacity) {
        if (profit.length == 0 || capacity == 0 || (weight.length != profit.length))
            return 0;

        int[][] dp = new int[profit.length][capacity + 1];

        for (int i = 0; i < profit.length; i++) {
            dp[i][0] = 0;
        }

        // by starting at zero and not pre-populating the first row, we can look at adding the same item
        // multiple times as long as the bag has capacity
        for (int i = 0; i < profit.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int profitOne = 0;
                int profitTwo = 0;

                // including the current profit minus the capacity of adding an item to the bag
                if (j >= weight[i])
                    profitOne = profit[i] + dp[i][j - weight[i]];
                // excluding the item, Looking a row about to see the profit of the previous item without adding
                if (i > 1)
                    profitTwo = dp[i - 1][j];

                dp[i][j] = Math.max(profitOne, profitTwo);
            }
        }

        return dp[profit.length - 1][capacity];
    }
}
