package Algorithms.Games;

import java.util.HashMap;
import java.util.HashSet;

public class TicTacToe {
    int length;
    HashSet<String> leftDiagonal = new HashSet<String>();
    HashSet<String> rightDiagonal = new HashSet<String>();
    Player one;
    Player two;
    HashMap<Integer, Player> players;
    public void computeDiagonal(){
        for(int i = 0; i < this.length;i++){
            leftDiagonal.add(Integer.toString(i) + Integer.toString(i));
        }
        int starter = 0;
        for(int i = this.length-1; i >= 0;i--){
            rightDiagonal.add(Integer.toString(starter)+ Integer.toString(i));
            starter +=1;

        }
    }
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.length = n;
        this.one = new Player();
        this.two = new Player();
        this.players = new  HashMap<Integer, Player>();
        this.players.put(1,one);
        this.players.put(2,two);
        computeDiagonal();

    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        Player playerObj = this.players.get(player);
        if(leftDiagonal.contains(Integer.toString(row) + Integer.toString(col)))
            playerObj.LeftDiagonal++;
        if(rightDiagonal.contains(Integer.toString(row) + Integer.toString(col)))
            playerObj.RightDiagonal++;

        playerObj.rowCount.put(row,playerObj.rowCount.getOrDefault(row,0) + 1);
        playerObj.ColCount.put(col,playerObj.ColCount.getOrDefault(col,0) +1);

        if(playerObj.rowCount.get(row) == this.length ||playerObj.ColCount.get(col) == this.length ||  playerObj.LeftDiagonal == this.length ||  playerObj.RightDiagonal == this.length)
            return player;
        return 0;
    }
}

 class Player{
    HashMap<Integer, Integer> rowCount = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> ColCount = new HashMap<Integer, Integer>();
    public int LeftDiagonal = 0;
    public int RightDiagonal = 0;


}
