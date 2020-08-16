package Algorithms.Graphs;

import java.util.Hashtable;

public class PathsWithSumHashtable {

    public static int pathsWithSum(TreeNode root, int runningSum,int targetSum, Hashtable<Integer,Integer> pathsWithCount){

        if(root == null)
            return 0;
        runningSum += root.val;

        int totalCount = pathsWithCount.getOrDefault(runningSum-targetSum,0);

        if(runningSum == targetSum)
            totalCount++;

        incrementPath(pathsWithCount,runningSum,1);
        totalCount += pathsWithSum(root.left,runningSum,targetSum,pathsWithCount);
        totalCount += pathsWithSum(root.right,runningSum,targetSum,pathsWithCount);
        incrementPath(pathsWithCount,runningSum,-1);

        return totalCount;

    }


    public static void incrementPath(Hashtable<Integer,Integer> pathsWithCount, int runningSum,int delta)
    {
        int newCount = pathsWithCount.getOrDefault(runningSum,0);

        newCount += delta;

        if(newCount == 0)
        {
            pathsWithCount.remove(runningSum);
        }
        else
            pathsWithCount.put(runningSum,newCount);
    }

}
