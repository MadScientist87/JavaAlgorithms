package Algorithms.RecursiveAndDynamic.UdemyClass;

import java.util.*;

public class CombinationsOfSetK {
    ArrayList<List<Integer>> list = new ArrayList<>();
    public static void combinations(int[] input, int k, HashSet<Integer> set, int start){
        if(set.size() == k){
            System.out.println(set);
            return;
        }

        if(start == input.length)
        {
            return;
        }

        for(int i = start; i < input.length;i++){
            set.add(input[i]);
            combinations(input,k,set,i+1);
            set.remove(input[i]);
        }

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0)
            return true;

        for(int i = 0; i < s.length(); i++){
            String word = s.substring(0,i +1);
            if(wordDict.contains(word)){
                wordBreak(s.substring(i+1), wordDict);
            }
        }

        return false;
    }
}
