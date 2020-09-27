package Algorithms.RecursiveAndDynamic.UdemyClass;

public class nQueens {
    public static boolean placeQueen(int[][] board, int target, int col){
       if(col == target)
           return true;

        for(int i =0;i < target; i++){

            if(isSafe(board,i,col,target) == true){
                board[i][col] =1;
               if(placeQueen(board, target,col +1) == true)
                   return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col,int target){
        for(int i =col; i >=0; i--){
            if(board[row][i] == 1)
                return false;
        }

        for(int i = col, j = row; j >= 0 && i >= 0; j--,i--){
            if(board[j][i] == 1)
                return false;
        }

        for(int i = col, j = row; i >= 0 && j < target; j++,i--){
            if(board[j][i] == 1)
                return false;
        }

        return true;
    }
}
