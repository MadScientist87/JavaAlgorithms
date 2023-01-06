package Algorithms.BloomBerg;

import Algorithms.Graphs.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class VerticalOrder {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null)
            return answer;

        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();

        queue.add(new Pair<>(0, root));

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        while(!queue.isEmpty()) {
            Pair<Integer, TreeNode> current = queue.poll();
            int column = current.getKey();
            TreeNode currentTreeNode = current.getValue();

            ArrayList<Integer> list = map.getOrDefault(column, new ArrayList<>());
            list.add(currentTreeNode.val);
            map.put(column, list);

            if(currentTreeNode.left != null)
                queue.add(new Pair<>(column -1, currentTreeNode.left));
            if(currentTreeNode.right != null)
                queue.add(new Pair<>(column + 1, currentTreeNode.right));
        }

        ArrayList<Integer> columns = new ArrayList<>(map.keySet());

        Collections.sort(columns);

        for(int column: columns) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int value: map.get(column)) {
                list.add(value);
            }

            answer.add(list);
        }

        return answer;
    }


}
