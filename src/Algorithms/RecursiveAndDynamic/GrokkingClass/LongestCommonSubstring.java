package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class LongestCommonSubstring {
    public static int longestCommonSubstring(String wordOne, String wordTwo, int wordOneIndex, int wordTwoIndex, int count){
        if(wordOneIndex > wordOne.length()-1 || wordTwoIndex > wordTwo.length()-1)
            return count;

        if(wordOne.charAt(wordOneIndex) == wordTwo.charAt(wordTwoIndex)){
            count = longestCommonSubstring(wordOne,wordTwo,wordOneIndex +1, wordTwoIndex +1, count +1);
        }

        int c1 = longestCommonSubstring(wordOne,wordTwo,wordOneIndex +1, wordTwoIndex , 0);
        int c2 = longestCommonSubstring(wordOne,wordTwo,wordOneIndex , wordTwoIndex +1 ,0);

        return Math.max(count,Math.max(c1,c2));
    }

    //Bottom up Approach
    public static int longestCommonSubstring(String wordOne, String wordTwo){
        int maxLength = 0;
        int[][] dp = new int[wordOne.length() +1][wordTwo.length()+1];

        for(int i =1; i <= wordOne.length(); i++){
            for(int j = 1; j <= wordTwo.length();j++){
                if(wordOne.charAt(i-1) == wordTwo.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLength = Math.max(dp[i][j], maxLength);
                }
            }
        }
        return maxLength;
    }

}
