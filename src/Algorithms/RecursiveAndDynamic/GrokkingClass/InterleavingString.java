package Algorithms.RecursiveAndDynamic.GrokkingClass;

import java.util.HashMap;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        return isInterleave(s1, s2, s3, 0, 0, 0, map);
    }

    public boolean isInterleave(String s1, String s2, String s3, int i1, int i2, int i3, HashMap<String, Boolean> map) {
        if (i1 == s1.length() && i2 == s2.length() && i3 == s3.length())
            return true;

        if (s3.length() == i3)
            return false;

        boolean b1 = false;
        boolean b2 = false;
        String key = i1 + "-" + i2 + "-" + i3;
        if (!map.containsKey(key)) {
            if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
                b1 = isInterleave(s1, s2, s3, i1 + 1, i2, i3 + 1, map);
            }

            if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
                b2 = isInterleave(s1, s2, s3, i1, i2 + 1, i3 + 1, map);
            }

            map.put(key, b1 || b2);
        }
        return map.get(key);
    }

    // bottom up
    public static boolean stringInterleave(String s1, String s2, String p){

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];

        if(s1.length() + s2.length() != p.length())
            return false;

        for(int m = 0; m <= s1.length(); m++){
            for(int n = 0; n <= s2.length();n++){
                // if m and n are zero p must also be zero
                if(m == 0 && n == 0)
                    dp[m][n] = true;
                else if(m == 0 && s2.charAt(n-1) == p.charAt(n +m -1))
                    dp[m][n] = dp[m][n-1];
                else if(n == 0 && s1.charAt(m-1) == p.charAt(n +m -1))
                    dp[m][n] = dp[m-1][n];
                else {
                    if(m > 0 && s1.charAt(m-1) == p.charAt(n +m -1))
                        dp[m][n] = dp[m-1][n];
                    if(n > 0 && s2.charAt(n-1) == p.charAt(n +m -1))
                        dp[m][n] |= dp[m][n-1];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
