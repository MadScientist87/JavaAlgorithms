package Algorithms.StacksAndQueues;

import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for(int i =0; i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.add(i);
            }
            else
            {
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                }
                else{
                    max = Math.max(i - stack.peek(), max);
                }
            }


        }
        return max;
    }
}
