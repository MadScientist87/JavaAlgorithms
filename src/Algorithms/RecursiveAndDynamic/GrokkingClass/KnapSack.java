package Algorithms.RecursiveAndDynamic.GrokkingClass;

import java.util.ArrayList;
import java.util.Collections;

public class KnapSack {
    public static int computeKnapSack(int[] profit, int[] weight, int capacity) {
        // base case
        if (capacity == 0 || weight.length != profit.length || profit.length == 0)
            return 0;

        int n = profit.length;
        int[][] dp = new int[n][capacity + 1];

        /* fill first row with zeros as we have no profit for a capacity of 0 */
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        /* fill first row with profit from first item as long as it is less than the capacity */
        for (int c = 0; c <= capacity; c++) {
            if (weight[0] <= c) {
                dp[0][c] = profit[0];
            }
        }

        for (int i = 1; i < profit.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                /* exclude item */
                // this is the profit of the item at the current capacity
                int profitOne = dp[i - 1][j];
                int profitTwo = 0;
                /* Include item if capacity is greater or equal than the weight required to add the item */
                // This is the profit of the current item + the profit of the item without the item
                if (j >= weight[i])
                    profitTwo = profit[i] + dp[i - 1][j - weight[i]];

                dp[i][j] = Math.max(profitOne, profitTwo);
            }
        }
        printItemSelection(dp, weight, capacity);

        return dp[n - 1][capacity];
    }

    public static int computeKnapSackOptimized(int[] profit, int[] weight, int capacity) {
        // base case
        if (capacity == 0 || weight.length != profit.length || profit.length == 0)
            return 0;

        int n = profit.length;
        int[][] dp = new int[2][capacity + 1];

        /* fill first row with zeros as we have no profit for a capacity of 0 */
        for (int i = 0; i < 2; i++) {
            dp[i][0] = 0;
        }

        /* fill first row with profit from first item as long as it is less than the capacity */
        for (int c = 0; c <= capacity; c++) {
            if (weight[0] <= c) {
                dp[0][c] = profit[0];
            }
        }

        for (int i = 1; i < profit.length ; i++) {
            for (int j = 1; j <= capacity; j++) {
                /* exclude item */
                // this is the profit of the item at the current capacity
                int profitOne = dp[(i - 1)%2][j];
                int profitTwo = 0;
                /* Include item if capacity is greater or equal than the weight required to add the item */
                // This is the profit of the current item + the profit of the item without the item
                if (j >= weight[i])
                    profitTwo = profit[i] + dp[(i - 1)%2][j - weight[i]];

                dp[i%2][j] = Math.max(profitOne, profitTwo);
            }
        }
        printItemSelection(dp,weight,capacity);

        return dp[(n - 1)%2][capacity];
    }

    public static int computeKnapSackOptimizedTwo(int[] profit, int[] weight, int capacity) {
        // base case
        if (capacity == 0 || weight.length != profit.length || profit.length == 0)
            return 0;

        int n = profit.length;
        int[] dp = new int[capacity + 1];


        /* fill first row with profit from first item as long as it is less than the capacity */
        for (int c = 0; c <= capacity; c++) {
            if (weight[0] <= c) {
                dp[c] = profit[0];
            }
        }

        for (int i = 1; i < profit.length ; i++) {
            for (int j = capacity; j >= 0; j--) {
                /* exclude item */
                // this is the profit of the item at the current capacity
                int profitOne = dp[j];
                int profitTwo = 0;
                /* Include item if capacity is greater or equal than the weight required to add the item */
                // This is the profit of the current item + the profit of the item without the item
                if (j >= weight[i])
                    profitTwo = profit[i] + dp[j - weight[i]];

                dp[j] = Math.max(profitOne, profitTwo);
            }
        }


        return dp[capacity];
    }

    public static ArrayList<Integer> printItemSelection(int[][] dp, int[] weight, int capacity) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = weight.length - 1; i >= 0; i--) {
            if (capacity >= weight[i]) {
                capacity -= weight[i];
                list.add(i);
            }
        }
        Collections.reverse(list);

        for (int index : list) {
            System.out.println("Selected Item Indexes:Weight " + index + ":" + weight[index]);
        }
        return list;
    }
}
