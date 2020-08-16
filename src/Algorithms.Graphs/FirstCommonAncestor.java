package Algorithms.Graphs;

import java.util.Stack;

public class FirstCommonAncestor {
    public static TreeNode findFirstCommonAncestor(TreeNode root, int firstTarget, int secondTarget) {
        Stack<TreeNode> rightStack = new Stack<>();
        Stack<TreeNode> leftStack = new Stack<>();

        if (root != null && find(root.left, firstTarget) && find(root.right, secondTarget))
            return root;

        search(root, leftStack, firstTarget);
        search(root, rightStack, secondTarget);

        Stack<TreeNode> larger;
        Stack<TreeNode> smaller;
        if (leftStack.size() <= rightStack.size()) {
            larger = rightStack;
            smaller = leftStack;
        } else {
            larger = leftStack;
            smaller = rightStack;
        }

        while (larger.size() > smaller.size())
            larger.pop();

        while (larger.peek().val != smaller.peek().val) {
            larger.pop();
            smaller.pop();
        }

        smaller.pop();

        return smaller.pop();

    }

    public static void search(TreeNode root, Stack<TreeNode> stack, int target) {
        if (root == null)
            return;
        if (stack.size() != 0 && stack.peek().val == target)
            return;
        stack.push(root);
        if (root.val == target)
            return;
        search(root.left, stack, target);
        search(root.right, stack, target);

    }

    public static boolean find(TreeNode root, int target) {
        if (root == null)
            return false;

        if (root.val == target)
            return true;

        return find(root.left, target) || find(root.right, target);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (root.val == p.val || root.val == q.val)) return root;

        var leftSearch = lowestCommonAncestor(root.left, p, q);
        var rightSearch = lowestCommonAncestor(root.right, p, q);

        if (leftSearch == null) return rightSearch;
        if (rightSearch == null) return leftSearch;

        return root;
    }
}
