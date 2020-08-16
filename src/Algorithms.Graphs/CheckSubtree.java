package Algorithms.Graphs;

public class CheckSubtree {

    public static boolean containsTree(TreeNode largerTree, TreeNode smallerTree) {
        if (smallerTree == null)
            return true;
        return subTree(largerTree, smallerTree);
    }

    public static boolean subTree(TreeNode largerTree, TreeNode smallerTree) {
        if (largerTree == null)
            return false;

        else if (largerTree.val == smallerTree.val && isSameTree(largerTree, smallerTree))
            return true;

        return subTree(largerTree.left, smallerTree) || subTree(largerTree.right, smallerTree);
    }


    public static boolean isSameTree(TreeNode treeOne, TreeNode treeTwo) {
        if (treeOne == null && treeTwo == null)
            return true;
        if (treeOne == null || treeTwo == null)
            return false;
        if (treeOne.val == treeTwo.val)
            return isSameTree(treeOne.left, treeTwo.left) && isSameTree(treeOne.right, treeTwo.right);

        return false;
    }
}
