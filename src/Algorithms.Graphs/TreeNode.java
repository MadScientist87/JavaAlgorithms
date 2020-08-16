package Algorithms.Graphs;

public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public TreeNode(int x) { val = x; }

    // Inserts a node an links it to a parent node
    public static TreeNode insert(TreeNode node, int data)
    {

        /* 1. If the tree is empty, return a new,
         single node */
        if (node == null) {
            return (new TreeNode(data));
        }
        else {

            TreeNode temp;

            /* 2. Otherwise, recur down the tree */
            if (data <= node.val) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            }
            else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }

            /* return the (unchanged) node pointer */
            return node;
        }
    }
}
