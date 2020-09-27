package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequences {
    public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node)
    {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if(node == null){
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.val);

        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        for(LinkedList<Integer> left:leftSeq){
            for(LinkedList<Integer> right: rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left,right,weaved,prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    public static ArrayList<LinkedList<Integer>> allSequences2(TreeNode node)
    {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if(node == null){
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.val);

        LinkedList<Integer> leftSeq = new LinkedList<>();
        LinkedList<Integer> rightSeq = new LinkedList<>();

        getNodeData(node.left,leftSeq);
        getNodeData(node.right,rightSeq);

        ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
        weaveLists(leftSeq,rightSeq,weaved,prefix);
        result.addAll(weaved);

        return result;
    }

    public static void getNodeData(TreeNode root, LinkedList<Integer> list)
    {
        if(root == null)
            return;
        list.add(root.val);
        getNodeData(root.left,list);
        getNodeData(root.right,list);

    }

    public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results,LinkedList<Integer> prefix)
    {
        if(first.size() == 0 || second.size() == 0)
        {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }


        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first,second,results,prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first,second,results,prefix);
        prefix.removeLast();
        second.addFirst(headSecond);

    }
}
