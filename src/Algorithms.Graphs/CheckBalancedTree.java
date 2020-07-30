package Algorithms.Graphs;

public class CheckBalancedTree {
    // Recurse over the right and left subtree and then does the same logic on every subtree until the
    // the bottom of the tree is reached. This has a big O of n log(n)
    public boolean checkBalanced(TreeNode root){
        if(root == null)
            return true;
        var leftDepth = getDepth(root.left);
        var rightDepth = getDepth(root.right);
        var heightDiff = Math.abs(leftDepth - rightDepth);

        if(heightDiff > 1)
            return false;
        else
            return checkBalanced(root.left) && checkBalanced(root.right);

    }

    public int getDepth(TreeNode node)
    {
        if(node == null)
            return 0;

        return Math.max(getDepth(node.left),getDepth(node.right)) + 1;
    }

    public boolean checkBalancedExample2(TreeNode root){
        return getHeight(root) != Integer.MIN_VALUE;
    }

    public int getHeight(TreeNode root)
    {
        if(root == null)
            return 0;

        var leftHeight = getHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE)
            return  Integer.MIN_VALUE;
        var rightHeight = getHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE)
            return  Integer.MIN_VALUE;

        if(Math.abs(leftHeight - rightHeight) > 1)
            return Integer.MIN_VALUE;
        else
            return Math.max(leftHeight, rightHeight) + 1;

    }
}
