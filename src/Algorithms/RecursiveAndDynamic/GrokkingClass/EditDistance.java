package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class EditDistance {
    public static int editDistance(String s1, String s2, int sOneIndex, int sTwoIndex){
        if(sOneIndex == s1.length())
            return s2.length() - sTwoIndex;

        if(sTwoIndex == s2.length())
            return s1.length() - sOneIndex;


        if(s1.charAt(sOneIndex) == s2.charAt(sTwoIndex)){
          return   editDistance(s1,s2,sOneIndex+1, sTwoIndex+1);
        }

        int c1 = 1 + editDistance(s1,s2,sOneIndex+1, sTwoIndex);
        int c2 = 1 +editDistance(s1,s2,sOneIndex, sTwoIndex+1);
        int c3 = 1 +editDistance(s1,s2,sOneIndex +1, sTwoIndex+1);

        return Math.min(c1, Math.min(c2,c3));
    }

    // top down
    public static int editDistance(String s1, String s2, int sOneIndex, int sTwoIndex, Integer[][] dp){
        if(dp[sOneIndex][sTwoIndex] == null){
            if(sOneIndex == s1.length())
                dp[sOneIndex][sTwoIndex] = s2.length() - sTwoIndex;

            if(sTwoIndex == s2.length())
                dp[sOneIndex][sTwoIndex] = s1.length() - sOneIndex;


            if(s1.charAt(sOneIndex) == s2.charAt(sTwoIndex)){
                return  editDistance(s1,s2,sOneIndex+1, sTwoIndex+1);
            }

            int c1 = 1 + editDistance(s1,s2,sOneIndex+1, sTwoIndex);
            int c2 = 1 +editDistance(s1,s2,sOneIndex, sTwoIndex+1);
            int c3 = 1 +editDistance(s1,s2,sOneIndex +1, sTwoIndex+1);
            dp[sOneIndex][sTwoIndex] =Math.min(c1, Math.min(c2,c3));
        }
        return dp[sOneIndex][sTwoIndex];
    }
    // Bottom up
    public static int editDistance(String wordOne, String wordTwo){
        int[][] dp = new int[wordOne.length()+1][wordTwo.length()+1];

        for(int i1 = 0; i1 <= wordOne.length();i1++){
            dp[i1][0] = i1;
        }

        for(int i2 = 0; i2 <= wordTwo.length();i2++){
            dp[0][i2] = i2;
        }

        for(int i = 1; i <= wordOne.length(); i++){
            for(int j = 1; j <= wordTwo.length(); j++){
                if(wordOne.charAt(i-1) == wordTwo.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else dp[i][j] = 1 +Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]));
            }
        }

        return dp[wordOne.length()][wordTwo.length()];
    }
}
