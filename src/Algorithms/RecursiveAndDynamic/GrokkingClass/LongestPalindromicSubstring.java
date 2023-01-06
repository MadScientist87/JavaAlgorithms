package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class LongestPalindromicSubstring {
    public static String longestPalindromicSubstring(String word) {
        if (word.length() == 0)
            return "";
        int maxCount = Integer.MIN_VALUE;
        String maxPalindrome = "";
        for (int i = 0; i < word.length(); i++) {
            String c1 = expandAroundCenter(word, i, i);
            String c2 = expandAroundCenter(word, i, i + 1);
            maxCount = Math.max(maxCount, Math.max(c1.length(), c2.length()));
            String currentPalindrome = "";
            if (c1.length() > c2.length()) {
                currentPalindrome = c1;
            } else {
                currentPalindrome = c2;
            }
            if (currentPalindrome.length() > maxPalindrome.length())
                maxPalindrome = currentPalindrome;
        }
        return maxPalindrome;
    }

    public static String expandAroundCenter(String word, int left, int right) {
        int count = 0;
        String subString = "";
        while (left >= 0 && right < word.length()) {
            if (left == right)
                count += 1;
            else if (word.charAt(left) == word.charAt(right)) {
                count += 2;
            } else {
                break;
            }
            subString = word.substring(left, right + 1);
            left--;
            right++;
        }
        return subString;
    }
// returns the count
    public static int longestPalindromicSubstringCount(String word) {
        if (word.length() == 0)
            return 0;
       int start = 0;
       int end = 0;

        for (int i = 0; i < word.length(); i++) {
            String c1 = expandAroundCenter(word, i, i);
            String c2 = expandAroundCenter(word, i, i + 1);
            int len = Math.max(c1.length(), c2.length());
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return end+1 - start;
    }
}
