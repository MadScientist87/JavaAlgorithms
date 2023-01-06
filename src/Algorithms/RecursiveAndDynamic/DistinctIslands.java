package Algorithms.RecursiveAndDynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DistinctIslands {
    boolean[][] visited;
    List<String> masterDirectionList = new ArrayList();
    public int numDistinctIslands(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    String directionList = "";
                    directionList+= findIslands(grid, i,j,null,directionList);
                    masterDirectionList.add(directionList);
                }
            }
        }


        HashSet<String> set= new HashSet<>();
        for(int i = 0; i < masterDirectionList.size(); i++){
            set.add(masterDirectionList.get(i));
        }

        return set.size();
    }



    public String findIslands(int[][] grid, int row, int col, Character direction,String directionList){
        if((row < 0 || row > grid.length-1 || col < 0 || col > grid[0].length-1) || visited[row][col] || grid[row][col] == 0)
            return "";

        visited[row][col] = true;
        grid[row][col] = 0;
        if(direction != null)
            directionList += direction;
        directionList+= findIslands(grid, row, col+1, 'R', directionList);
        directionList+= findIslands(grid, row+1, col, 'D', directionList);
        directionList+=findIslands(grid, row-1, col, 'U',directionList);
        directionList+= findIslands(grid, row, col-1, 'L',directionList);
        return directionList;
    }
}
