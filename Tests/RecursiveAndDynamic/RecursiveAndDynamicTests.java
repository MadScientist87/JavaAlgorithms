package RecursiveAndDynamic;

import Algorithms.RecursiveAndDynamic.*;
import Algorithms.RecursiveAndDynamic.GrokkingClass.*;
import Algorithms.RecursiveAndDynamic.GrokkingClass.LongestIncreasingSubsequence;
import Algorithms.RecursiveAndDynamic.UdemyClass.*;
import org.junit.Assert;
import org.junit.Test;


import java.util.*;
import java.util.stream.Collectors;

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

        var answer = MakeChange.coinChange(new int[]{1,2,5}, 11);
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

    @Test
    public void LongestIncreasingSubsequence() {

      //  int answer = LongestIncreasingSubsequence.lengthOfLIS(new int[]{2,7,3,8,12,-1});
        System.out.println();
    }

    @Test
    public void canJump() {

        boolean answer = CanJump.canJump(new int[] {2,3,1,1, 4});
        System.out.println();
    }

    @Test
    public void minCostStoneJump() {

        int answer = MinCostToJumpOverStones.minCostToJumpOverStones(new int[] {0,20,30,40,25,15,20,28},3);
        System.out.println();
    }

    @Test
    public void knapSack() {
        int[] profit = new int[]{1,6,10,16};
        int[] weight = new int[]{1, 2, 3,5};

        int answer = KnapSack.computeKnapSackOptimizedTwo(profit,weight,6);
        System.out.println();
    }

    @Test
    public void equalSubsetPartition() {
        int[] nums = new int[]{2,1,3,4};
        boolean answer = EqualSubsetPartition.canPartitionOptimizedTwo(nums);
        System.out.println();
    }

    @Test
    public void isSubset() {
        int[] nums = new int[]{1,2,3,7};

        boolean answer = SubsetSum.isSubSetOptimizedBottomUp(nums, 6);
        System.out.println();
    }

    @Test
    public void minSubset() {
        int[] nums = new int[]{1,3,100,4};
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        int answer = MinSubSetSum.canPartitionOptimizedTwo(nums);
        System.out.println();
    }

    @Test
    public void countOfSubset() {
        int[] nums = new int[]{1,2,7,1,5};

        int answer = CountOfSubset.countSubSetSumBottomUpLessSpace(nums, 9);
        System.out.println();
    }

    @Test
    public void targetSum() {
        int[] nums = new int[]{1,1,2,3};

        int answer = TargetSum.countSubSetSumBottomUp(nums, 1);
        System.out.println();
    }

    @Test
    public void unboundedKnapsack() {
        int[] weights = new int[]{1,3,4,5};
        int[] profits = new int[]{15,50,60,90};
        int capacity = 8;
        Integer[][] dp = new Integer[profits.length][capacity+1];
        int answer = UnboundedKnapsack.unboundedKnapsack(weights, profits,capacity,0,dp);
        System.out.println();
    }

    @Test
    public void rodCutting() {
        int[] lengths = new int[]{1,2,3,4,5};
        int[] prices = new int[]{2,6,7,10,13};
        int rodLength = 5;
        Integer[][] dp = new Integer[lengths.length][rodLength+1];
        int answer = RodCutting.rodCutting(lengths,prices,rodLength,0,dp);
        System.out.println();
    }

    @Test
    public void coinChange() {
        int[] coins = new int[]{1,2,3};
        int target = 5;
        Integer[][] dp = new Integer[coins.length][target+1];
        int answer = CoinChange.coinChange(coins,target,0);
        System.out.println();
    }

    @Test
    public void minCoinChange() {
        int[] coins = new int[]{1,2,3};
        int target = 5;
        Integer[][] dp = new Integer[coins.length][target+1];
        int answer = MinimumCoinChange.minimumCoinChange(coins,target, 0);
        System.out.println();
    }

    @Test
    public void maxRibbonCut() {
        int[] ribbons = new int[]{2,3,5};
        int length = 5;
        Integer[][] dp = new Integer[ribbons.length][length+1];
        int answer = MaximumRibbonCut.maximumRibbonCut2d(ribbons,length);
        System.out.println();
    }

    @Test
    public void calculateFibonacci() {
        int n =8;

        int[] dp = new int[n+1];
        int answer = Fibonacci.calculateFibonacciBottomUpOptimized(n);
        System.out.println();
    }

    @Test
    public void numberOfStairs() {
        int n =3;

        int[] dp = new int[n+1];
        int answer = NumberOfStairs.numberOfStairsDpOptimized(n);
        System.out.println();
    }

    @Test
    public void numberOfFactors() {
        int n =5;

        Integer[] dp = new Integer[n+1];
        int answer = NumberOfFactors.numberOfFactorsDp(n);
        System.out.println();
    }

    @Test
    public void minJumpsToEnd() {
        int[] nums = new int[]{2,3,1,1,4};

        Integer[] dp = new Integer[nums.length+1];
        int answer = MinimumJumpsToReachEnd.minimumJumpsToReachEnd(nums,0, dp);
        System.out.println();
    }

    @Test
    public void minJumpsToEndWithFee() {
        int[] nums = new int[]{2,3,4,5};
        int maxNumberofStepsToTake = 3;
        Integer[] dp = new Integer[nums.length+1];
        int answer = MinJumpsWithFee.minimumJumpsToReachEnd(nums);
        System.out.println();
    }

    @Test
    public void robHouses() {
        int[] profit = new int[]{2,5,1,3,6,2,4};

        Integer[] dp = new Integer[profit.length+1];
        int answer = HouseThief.robHouses(profit);
        System.out.println();
    }

    @Test
    public void longestPalindromicSubsequence() {
        String word = "abdbca";
        Integer[][] dp = new Integer[word.length()][word.length()];
        int answer = LongestPalindromicSubsequence.longestPalindromicSubsequence(word);
        System.out.println();
    }

    @Test
    public void longestPalindromicSubString() {
        String word = "abdbca";
        Integer[][] dp = new Integer[word.length()][word.length()];
        int answer = LongestPalindromicSubstring.longestPalindromicSubstringCount(word);
        System.out.println();
    }

    @Test
    public void countOfPalindromicSubStrings() {
        String word = "aaa";
        Integer[][] dp = new Integer[word.length()][word.length()];
        int answer = CountOfPalindromicSubstrings.longestPalindromicSubstring(word);
        System.out.println();
    }

    @Test
    public void minimumDeletionsInAStringPalindrome() {
        String word = "abdbca";
        Integer[][] dp = new Integer[word.length()][word.length()];
        int answer = MinimumDeletionsInAStringPalindrome.minimumDeletionsInAStringPalindrome(word, 0,word.length()-1);
        System.out.println();
    }

    @Test
    public void palindromicPartitioning() {
        String word = "cddpd";
        Integer[][] dp = new Integer[word.length()][word.length()];
        int answer = PalindromicPartitioning.palindromicPartitioning(word);
        System.out.println();
    }

    @Test
    public void LongestCommonSubstring() {
        String wordOne = "passport";
        String wordTwo = "ppsspt";
        //Integer[][] dp = new Integer[word.length()][word.length()];
        int answer = LongestCommonSubstring.longestCommonSubstring(wordOne, wordTwo);
        System.out.println();
    }

    @Test
    public void LongestCommonSubsequence() {
        String wordOne = "dynamic";
        String wordTwo = "programming";
        Integer[][] dp = new Integer[wordOne.length()][wordTwo.length()];
        int answer = LongestCommonSubsequence.longestCommonSubsequence(wordOne, wordTwo,0,0,dp);
        System.out.println();
    }

    @Test
    public void MinDeletionsAndInsertions() {
        String wordOne = "passport";
        String wordTwo = "ppsspt";
        Integer[][] dp = new Integer[wordOne.length()][wordTwo.length()];
        int[] answer = MinDeletionsAndInsertions.MinDeletionsAndInsertions(wordOne, wordTwo);
        System.out.println();
    }

    @Test
    public void LongestIncreasingSubsequence2() {
        int[] nums = new int[]{10,22,9,33,21,50,41,60,80};
        Integer[][] dp = new Integer[nums.length][nums.length +1];
        int answer = LongestIncreasingSubsequence.longestIncreasingSubsequence(nums);
        System.out.println();
    }

    @Test
    public void MaximumSumIncreasingSubsequence() {
        int[] nums = new int[]{4,1,2,6,10,1,12};
        Integer[][] dp = new Integer[nums.length][nums.length +1];
        int answer = MaximumSumIncreasingSubsequence.maximumSumIncreasingSubsequence(nums);
        System.out.println();
    }

    @Test
    public void ShortestCommonSuperSequence() {
        String wordOne = "dynamic";
        String wordTwo = "programming";
        Integer[][] dp = new Integer[wordOne.length()][wordTwo.length()];
        int answer = ShortestCommonSuperSequence.shortestCommonSuperSequence(wordOne, wordTwo);
        System.out.println();
    }

    @Test
    public void MinimumDeletionsToMakeSequenceSorted() {
        int[] nums = new int[]{-4,10,3,7,15};
        int answer = MinimumDeletionsToMakeSequenceSorted.minDeletions(nums);
        System.out.println();
    }

    @Test
    public void LongestRepeatingSubsequence() {
        String wordOne = "aabdbcec";

        Integer[][] dp = new Integer[wordOne.length()][wordOne.length()];
        int answer = LongestRepeatingSubsequence.longestRepeatingSubsequence(wordOne);
        System.out.println();
    }

    @Test
    public void SubsequencePatternMatching() {
        String wordOne = "baxmx";
        String pattern = "ax";

        Integer[][] dp = new Integer[wordOne.length()][wordOne.length()];
        int answer = SubsequencePatternMatching.subsequencePatternMatching(wordOne,pattern);
        System.out.println();
    }

    @Test
    public void LongestBitonicSubsequence() {
        int[] nums = new int[]{4,2,3,6,10,1,12};
        Integer[][] dp = new Integer[nums.length][nums.length +1];
        int answer = LongestBitonicSubsequence.longBitonicSubsequenceBottomUp(nums);
        System.out.println();
    }

    @Test
    public void EditDistance() {
        String wordOne = "abdca";
        String wordTwo = "cbda";

        Integer[][] dp = new Integer[wordOne.length()][wordTwo.length()];
        int answer = EditDistance.editDistance(wordOne,wordTwo);
        System.out.println();
    }

    @Test
    public void stringInterleave() {
        String wordOne = "abd";
        String wordTwo = "cef";
        String wordThree = "abcdef";

        Integer[][] dp = new Integer[wordOne.length()][wordTwo.length()];
        boolean answer = InterleavingString.stringInterleave(wordOne,wordTwo,wordThree);
        System.out.println();
    }

    @Test
    public void friendCircle() {
        int[][] matrix = new int[][]{{1,1,0},
                {1,1,0},
        {0,0,1}};

        int answer = FriendCircles.findCircleNum(matrix);
        System.out.println();
    }

    @Test
    public void distinctIslands() {
        DistinctIslands di = new DistinctIslands();
        int[][] grid = new int[][]{{0,1,0},{1,0,1}};
       int answer = di.numDistinctIslands(grid);
        System.out.println();
    }

    @Test
    public void evaluateDivision() {

        String[][]equations = new String[][] {{"a","b"},{"b", "c" }};
        double[] values = {2.0,3.0};
        String[][]queries = new String[][] {{"a","c"},{"b", "a" },{"a","e"},{"a","a"},{"x","x"}};
        List<List<String>> equationsList = Arrays.stream(equations)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        List<List<String>> queriesList = Arrays.stream(queries)
                .map(Arrays::asList)
                .collect(Collectors.toList());


        double[] answer = EvaluateDivision.calcEquation(equationsList,values,queriesList);
        double[] expectedResult = new double[] {6.0, 0.5, -1.0, 1.0,-1.0};
        Assert.assertTrue(Arrays.equals(expectedResult, answer));
    }

    public static  <T> List<T> twoDArrayToList(T[][] twoDArray) {
        List<T> list = new ArrayList<T>();
        for (T[] array : twoDArray) {
            list.addAll(Arrays.asList(array));
        }
        return list;
    }

    @Test
    public void partitionArray() {
        int[] array = new int[] {5,16,3,20,9,20,16,19,6};
        int k = 4;
        int answer = PartitionArray.partitionArray(array,k);

        Assert.assertEquals(answer, 3);
    }

    @Test
    public void generateSum() {
        int[] array = new int[]{2,5,1,6,7};
        int k = 3;

        ArrayList<ArrayList<Integer>> answer = GenerateSum.generateSum(array,k,9);

        System.out.println();
    }
}
