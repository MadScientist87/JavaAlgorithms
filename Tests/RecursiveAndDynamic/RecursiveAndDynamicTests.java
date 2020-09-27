package RecursiveAndDynamic;

import Algorithms.RecursiveAndDynamic.*;
import Algorithms.RecursiveAndDynamic.UdemyClass.*;
import org.junit.Assert;
import org.junit.Test;


import java.util.*;

public class RecursiveAndDynamicTests {
    @Test
    public void tripleStep() {
        var answer = TripleStep.tripleStep(3);
        Assert.assertEquals(answer, 4);
    }

    @Test
    public void robotInAGrid() {

        int[][] grid = {
                {0, 0, 0},
                {-1, -1, 0},
                {0, 0, 0},
        };

        RobotInAGrid.visited = new boolean[grid.length][grid[0].length];
        var answer = RobotInAGrid.runPath(grid, 0, 0, new int[][]{new int[]{2, 2}});
        Collections.reverse(answer);

        Stack<String> compare = new Stack<>();
        compare.add("R");
        compare.add("R");
        compare.add("D");
        compare.add("D");

        Assert.assertEquals(answer, compare);
    }

    @Test
    public void magicIndex() {
        var answer = MagicIndex.getMagicIndex(new int[]{1, 2, 3, 4, 4, 6}, 0, 5);
        System.out.println();
    }

    @Test
    public void permutation() {
        Permutations.generatePermutation("aac", 0, 2);
        var answer = Permutations.permutations;
        System.out.println();
    }

    @Test
    public void towerOfHanoi() {
        TowersOfHanoi.tower(2, "tower 1", "tower 3", "tower 2");
        //var answer = Permutations.permutations;
        System.out.println();
    }

    @Test
    public void powerSet() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        var answer = PowerSet.getSubsets(list, 0);
        System.out.println();
    }

    @Test
    public void multiply() {

        var answer = Multiply.multiply(7, 8);
        System.out.println();
    }

    @Test
    public void generateParens() {

        var answer = Parentheses.generateParens(3);
        System.out.println();
    }

    @Test
    public void makeChange() {

        var answer = MakeChange.coinChange(new int[]{25, 10, 5, 1}, 30);
        System.out.println();
    }

    @Test
    public void nQueens() {
        int[][] board = new int[8][8];
        NQueens.target = 8;
        NQueens.placeQueenFindSingle(board, 0);
        System.out.println();
    }

    @Test
    public void nQueensAllWays() {
        int[][] board = new int[8][8];
        var answer = NQueens.getAllWays(board, 0, 8);
        System.out.println();
    }

    @Test
    public void stackOfBoxes() {
        ArrayList<Box> list = new ArrayList<>();
        var box = new Box(3, 5, 7);
        list.add(box);
        var boxTwo = new Box(5, 4, 6);
        list.add(boxTwo);
        var answer = StackOfBoxes.createStack(list);
        System.out.println();
    }

    @Test
    public void binarySearch() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        var answer = BinarySearch.binarySearch(array, 0, array.length - 1, 6);
        System.out.println();
    }

    @Test
    public void isInSequence() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        var answer = IsArrayinSequence.isInSequence(array);
        System.out.println();
    }

    @Test
    public void getSumOfDigits() {
        int input = 123456;
        var answer = SumOfDigits.getSumOfDigits(input);
        System.out.println();
    }

    @Test
    public void permute() {
        Permutation.permute("abc",0,2);
        System.out.println();
    }

    @Test
    public void combinations() {
        HashSet<Integer> set = new HashSet();
        int[] array = new int[4];
        for(int i=0;i<4;i++){
            array[i] = i+1;
        }
        CombinationsOfSetK.combinations(array,2,set,0);
        System.out.println();
    }

    @Test
    public void nQueensUdemy() {
        int[][] board = new int[8][8];
        NQueens.target = 8;
        nQueens.placeQueen(board, 8,0);
        System.out.println();
    }

    @Test
    public void wordBreak() {
        ArrayList<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        boolean answer = CombinationsOfSetK.wordBreak("leetcode", list);
        System.out.println();
    }
}
