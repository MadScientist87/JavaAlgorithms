package Algorithms.RecursiveAndDynamic;

import java.util.Stack;

public class RobotInAGrid {
    public static Stack<String> path = new Stack<>();
    public static boolean[][] visited;
    static int[][] dirs = new int[][]{new int[]{0, 1}, new int[]{1, 0}};

    public static Stack<String> runPath(int[][] grid, int row, int col, int[][] destination) {
        getPath(grid, row, col, destination);
        return path;
    }

    public static boolean getPath(int[][] grid, int row, int col, int[][] destination) {

        if (row > grid.length - 1 || col > grid[0].length - 1 || visited[row][col])
            return false;

        visited[row][col] = true;

        if (destination[0][0] == row && destination[0][1] == col) {
            return true;
        }
        if (grid[row][col] == -1)
            return false;

        for (int[] direction :
                dirs) {

            boolean foundDestination = getPath(grid, row + direction[0], col + direction[1], destination);

            if (foundDestination) {
                if (direction[0] == 0)
                    path.add("R");
                else
                    path.add("D");

                return true;
            }
        }

        return false;

    }
}
