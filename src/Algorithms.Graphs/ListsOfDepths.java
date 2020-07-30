package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListsOfDepths {
   public ArrayList<LinkedList<TreeNode>> nodeListAtDepth = new ArrayList<>();

    public void findDepths(TreeNode node, int level)
    {
        if(node == null)
            return;

       if(nodeListAtDepth.size() == level)
           nodeListAtDepth.add(new LinkedList<>());

       var list = nodeListAtDepth.get(level);
       list.add(node);

       findDepths(node.left, level +1);
       findDepths( node.right, level +1);
    }
}
