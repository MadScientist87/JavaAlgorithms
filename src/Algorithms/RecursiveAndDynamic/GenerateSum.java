package Algorithms.RecursiveAndDynamic;

import java.util.ArrayList;
import java.util.Stack;

public class GenerateSum {
    static ArrayList<ArrayList<Integer>> answer;
    static Stack<Integer> stack = new Stack<>();
    static Integer sum = 0;
    static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> generateSum(int[] nums, int k, int target) {
        answer = new ArrayList<>();
        visited = new boolean[nums.length];
        helper(nums, 0 , k,  target);

        return answer;
    }

    public static void helper(int[] nums, int start ,int k, int target) {

        if(sum == target && stack.size() == k) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = stack.size() -1; i >= 0 ; i--) {
                list.add(stack.get(i));
            }

            answer.add(list);
        }

        for(int i = start; i < nums.length; i++) {
            if(visited[i])
                continue;
            visited[i] = true;
            sum += nums[i];
            stack.add(nums[i]);
            helper(nums,start +1, k, target);
            if(!stack.isEmpty())
                sum -= stack.pop();
            visited[i] = false;
        }

        return;
    }
}
