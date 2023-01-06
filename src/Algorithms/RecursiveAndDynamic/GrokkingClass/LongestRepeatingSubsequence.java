package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class LongestRepeatingSubsequence {
    public static int longestRepeatingSubsequence(String word, int indexOne, int indextwo,Integer[][] dp){
        if(indexOne >word.length() -1 || indextwo > word.length() -1)
            return 0;
        if(dp[indexOne][indextwo] == null){
            if(indexOne != indextwo && word.charAt(indexOne) == word.charAt(indextwo)){
                return 1 + longestRepeatingSubsequence(word, indexOne +1, indextwo +1,dp);
            }
            int c1 = longestRepeatingSubsequence(word, indexOne +1,indextwo,dp);
            int c2 = longestRepeatingSubsequence(word, indexOne, indextwo + 1,dp);
            dp[indexOne][indextwo] = Math.max(c1,c2);
        }


        return  dp[indexOne][indextwo];
    }

    // Bottom up
    public static int longestRepeatingSubsequence(String word){
        int[][] dp = new int[word.length()+1][word.length()+1];
        int maxLength = 0;

        for(int i = 1; i <= word.length();i++){
            for(int j = 1; j <= word.length(); j++){
                if(j != i && word.charAt(i -1) == word.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                maxLength = Math.max(dp[i][j],maxLength);
            }

        }
        return maxLength;
    }
}
