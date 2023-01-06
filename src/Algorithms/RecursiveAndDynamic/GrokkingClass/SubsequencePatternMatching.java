package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class SubsequencePatternMatching {
    public static int subsequencePatternMatching(String word, String pattern, int wordIndex, int patternIndex){
        if(patternIndex == pattern.length())
            return 1;

        if(wordIndex == word.length())
            return 0;
        int c1 = 0;
        if(word.charAt(wordIndex) == pattern.charAt(patternIndex)){
            c1 = subsequencePatternMatching(word,pattern,wordIndex+1,patternIndex+1);
        }
        int c2 = subsequencePatternMatching(word,pattern,wordIndex +1,patternIndex);
        return c1 +c2;
    }

    public static int subsequencePatternMatching(String word, String pattern){
        if(pattern.length() ==0) return 1;
        if(word.length() == 0 || pattern.length() > word.length())
            return 0;
        int [][] dp = new int[word.length() +1][pattern.length()+1];

        // for all the pattern of 0
        for(int i = 0; i < word.length();i++){
            dp[i][0] =1;
        }

        for(int i = 1; i <= word.length(); i++){
            for(int j = 1; j <= pattern.length(); j++){
                if(word.charAt(i-1) == pattern.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                dp[i][j] += dp[i-1][j];
            }
        }
        return dp[word.length()][pattern.length()];
    }
}
