package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String wordOne, String wordTwo, int wordOneIndex, int wordTwoIndex, Integer[][]dp){
        if(wordOneIndex > wordOne.length()-1 || wordTwoIndex > wordTwo.length()-1)
            return 0;
        if(dp[wordOneIndex][wordTwoIndex] == null){
            if(wordOne.charAt(wordOneIndex) == wordTwo.charAt(wordTwoIndex)){
                return 1 + longestCommonSubsequence(wordOne,wordTwo,wordOneIndex +1, wordTwoIndex +1,dp);
            }

            int c1 = longestCommonSubsequence(wordOne,wordTwo,wordOneIndex +1, wordTwoIndex ,dp);
            int c2 = longestCommonSubsequence(wordOne,wordTwo,wordOneIndex , wordTwoIndex +1,dp) ;
            dp[wordOneIndex][wordTwoIndex] = Math.max(c1,c2);
        }

        return  dp[wordOneIndex][wordTwoIndex];
    }

    //Bottom Up
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        int maxlength = 0;
        for(int i = 1; i <= text1.length();i++){
            for(int j = 1; j <= text2.length(); j++){
                if(text1.charAt(i-1) ==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

                maxlength = Math.max(dp[i][j], maxlength);
            }
        }
        return maxlength;
    }
}
