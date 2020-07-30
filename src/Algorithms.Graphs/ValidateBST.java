package Algorithms.Graphs;

import java.util.Stack;

public class ValidateBST {
    public boolean isValid = true;
    public double inOrderGlobal = -Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        double inOrder = -Double.MAX_VALUE;

        while (root != null || stack.size() != 0)
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= inOrder) return false;
            inOrder = root.val;
            root = root.right;
        }
        return true;
    }

    public void isValidBSTRecursive(TreeNode root)
    {
        if(!isValid || root == null)
            return;

        isValidBSTRecursive(root.left);
        if(root.val <= inOrderGlobal)
            isValid = false;
        inOrderGlobal = root.val;
        isValidBSTRecursive(root.right);
    }
}
