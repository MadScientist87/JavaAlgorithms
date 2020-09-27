package Algorithms.RecursiveAndDynamic;

import java.util.ArrayList;

public class PowerSet {
    public static int counter = 0;

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
       ArrayList<ArrayList<Integer>> allSubsets;

       if(set.size() == index){
           allSubsets = new ArrayList<>();
           allSubsets.add(new ArrayList<>());
           return allSubsets;
       }
       else {
           allSubsets = getSubsets(set, index +1);
           ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
           Integer item = set.get(index);

           for (ArrayList<Integer> subset :
                   allSubsets) {
               ArrayList<Integer> newSubset = new ArrayList<>();
               newSubset.addAll(subset);
               newSubset.add(item);
               moreSubsets.add(newSubset);
           }
           allSubsets.addAll(moreSubsets);
       }
       return allSubsets;
    }
}
