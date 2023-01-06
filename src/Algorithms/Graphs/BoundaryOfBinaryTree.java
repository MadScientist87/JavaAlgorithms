package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree {

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null)
            return  result;

        if(!isLeaf(root)) {
            result.add(root.val);
        }

        TreeNode t = root.left;
        while (t != null) {
            result.add(root.val);
            if(t.left != null) {
                t = t.left;
            }
            else {
                t = t.right;
            }
        }

        addLeaves(root, result);

        Stack<Integer> stack = new Stack<>();
        t = root.right;
        while (t != null) {
            stack.add(root.val);
            if(t.right != null) {
                t = t.right;
            }
            else {
                t = t.left;
            }
        }

        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return  result;
    }

    public static boolean isLeaf(TreeNode root) {
        return  root.left == null && root.right == null;
    }

    public static void addLeaves(TreeNode node, ArrayList<Integer> result) {
        if(isLeaf(node)) {
          result.add(node.val);
        }
        else {
            if(node.left != null)
                addLeaves(node.left, result);
            if( node.right != null)
                addLeaves(node.right, result);
        }

    }
}
