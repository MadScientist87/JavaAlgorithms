package Algorithms.BloomBerg;

public class CandyCrush {
    boolean isStable;
    public int[][] candyCrush(int[][] board) {

        do {
            isStable = true;
            board = runEliminator(board);
            board = shiftCols(board);
        } while(!isStable);

        return board;
    }

    public int[][] runEliminator(int[][] board) {
        // do rows
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int val = Math.abs(board[i][j]);
                if(val == 0)
                    continue;
                int startInd = j;
                if(j < board[0].length -2 && Math.abs(board[i][j +1]) == val &&  Math.abs(board[i][j +2]) == val) {
                    isStable = false;
                    while(startInd < board[0].length &&  Math.abs(board[i][startInd]) == val) {
                        board[i][startInd++] = -val;
                    }
                }
            }
        }

        // do cols
        for(int j = 0; j < board[0].length; j++) {
            for(int i = 0; i < board.length; i++) {
                int val = Math.abs(board[i][j]);
                if(val == 0)
                    continue;
                int startInd = i;
                if(i < board.length -2 && Math.abs(board[i+1][j]) == val &&  Math.abs(board[i+2][j]) == val) {
                    isStable = false;
                    while(startInd < board.length && Math.abs(board[startInd][j]) == val) {
                        board[startInd++][j] = -val;
                    }
                }
            }
        }


        return board;
    }

    public int[][] shiftCols(int[][] board) {
        for(int j = 0; j < board[0].length; j++) {
            int bottomInd = board.length-1;

            for(int i = board.length-1; i >= 0; i--) {
                if(board[i][j] > 0) {
                    board[bottomInd--][j] = board[i][j];
                }
            }

            while(bottomInd >=0) {
                board[bottomInd--][j] = 0;
            }
        }

        return board;
    }
}
