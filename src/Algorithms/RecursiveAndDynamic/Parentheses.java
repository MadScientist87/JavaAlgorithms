package Algorithms.RecursiveAndDynamic;

import java.util.ArrayList;

public class Parentheses {
    public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
        if (leftRem < 0 || rightRem < leftRem)
            return;
        if (leftRem == 0 && rightRem == 0) {
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
            if (leftRem > 0) {
                str[count] = '(';
                addParen(list, leftRem - 1, rightRem, str, count + 1);
            }

            if (rightRem > leftRem) {
                str[count] = ')';
                addParen(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }

    public static ArrayList<String> generateParens(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, count);
        return list;
    }

    // Much simpler implementation
    public static void backtrack(ArrayList<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }
}
