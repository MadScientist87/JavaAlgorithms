package Algorithms.RecursiveAndDynamic;
import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    public static int target = 0;
    public static ArrayList<int[][]> ways;

    public static ArrayList<int[][]> getAllWays(int[][] board, int col, int sizeOfBoard) {
        target = sizeOfBoard;
        ways = new ArrayList<>();
        placeQueen(board, col);
        return ways;
    }

    // This function lists all the ways queens can be placed on the board
    // Instead of returning once we have found a valid board in the for loop we keep going
    // backtracking and adding more queens to find another valid solution
    public static boolean placeQueen(int[][] board, int col) {
        if (col == target) {
            // Deep copy of array. Backtracking will clear array of data if board is passed by reference
            int[][] b = new int[target][];
            for (int i = 0; i < target; i++) {
                b[i] = Arrays.copyOf(board[i], board[i].length);
            }

            ways.add(b);
            return true;
        }

        boolean res = false;
        for (int i = 0; i < target; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                res = placeQueen(board, col + 1) || res;

                // backtrack
                board[i][col] = 0;
            }
        }

        return res;
    }

    // This function is used to find a Single answer to the nQueens problem. It breaks the recursion
    // and leaves the board with all placed queens intact.
    public static boolean placeQueenFindSingle(int[][] board, int col) {
        if (col == target) {
            return true;
        }

        for (int i = 0; i < target; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (placeQueenFindSingle(board, col + 1) == true) {
                    return true;
                }

                // backtrack
                board[i][col] = 0;
            }
        }

        return false;
    }

    public static boolean isSafe(int[][] board, int row, int column) {

        //Check all places in the same row before the target column
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1)
                return false;
        }

        //Check upper left
        for (int i = row, j = column; j >= 0 && i >= 0; j--, i--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check lower left
        for (int i = row, j = column; j >= 0 && i < target; j--, i++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }
}
