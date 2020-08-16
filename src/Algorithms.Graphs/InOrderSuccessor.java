package Algorithms.Graphs;

public class InOrderSuccessor {
    public static TreeNode getInOrderSuccessor(TreeNode node) {
        if (node.right != null)
            return getLeftMostNode(node.right);
        else
        {
            TreeNode parent = node.parent;
            while (parent.right == node && parent !=null)
            {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static TreeNode getLeftMostNode(TreeNode node)
    {
        while (node.left != null)
        {
            node = node.left;
        }

        return node;
    }
}
