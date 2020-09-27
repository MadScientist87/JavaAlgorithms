package Algorithms.Graphs;

import com.sun.source.tree.Tree;

public class MinimalTree {
    public TreeNode CreateMinimalTree(int[] array, int left, int right) {
        if (right <  left)
            return null;

        int mid = (right + left) / 2;
        TreeNode tree = new TreeNode(array[mid]);
        tree.left = CreateMinimalTree(array, left, mid - 1);
        tree.right = CreateMinimalTree(array, mid + 1, right);
        return tree;
    }
}
