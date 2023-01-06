package Algorithms.Graphs;

public class BSTUtility {
    public static TreeNode addRecursive(TreeNode root, int value) {
        if(root == null) {
            root = new  TreeNode(value);
            return root;
        }

        if(value < root.val)
            root.left = addRecursive(root.left, value);
        else if (value > root.val)
            root.right = addRecursive(root.right, value);
        return root;
    }
    // This function is written with the idea you will already have a root node created
    // If not we will create one for you. If you do have one created you can ignore the return
    // value as your root node will be passed by reference.
    public static TreeNode addIterative(TreeNode root , int value){
        if(root == null) {
            root = new TreeNode(value);
            return root;
        }

        TreeNode current = root;
        while(current != null) {
            if(value < current.val) {
                if(current.left == null) {
                    current.left = new TreeNode(value);
                    break;
                }
                current = current.left;
            }
            else if (value > current.val) {
                if(current.right == null) {
                    current.right = new TreeNode(value);
                    break;
                }
                current = current.right;
            }
        }

        return  root;
    }

    public static void delete(TreeNode root, int value) {
        // Search through tree find current Node and Parent Node
        TreeNode current = root;
        TreeNode parent = null;
        while(current != null) {
            parent = current;
            if(value < current.val) {
                current = current.left;
                if(current.val == value)
                    break;
            }
            else if (value > current.val) {
                current = current.right;
                if(current.val == value) {
                    break;
                }
            }
            else if(value == current.val){
                break;
            }
        }

        // Deleting a leaf node. A node that has no children
        if( current.left == null && current.right == null) {
            deleteLeaf(parent, current);
        }
        else if(current.left == null || current.right == null) {
            deleteWhenNodeHasOneChild(parent, current);
        }
        else {
            deleteWhenNodeHasTwoChildren(parent,current, root);
        }

        return;
    }

    private static void deleteWhenNodeHasTwoChildren(TreeNode parent, TreeNode current, TreeNode root) {
        TreeNode mostLeftValueNode = findLeftestLeastValueNode(current.right);
        int newValue = mostLeftValueNode.val;
        delete(root ,mostLeftValueNode.val);
        current.val = newValue;
    }

    private static TreeNode findLeftestLeastValueNode(TreeNode node) {
        if(node == null)
            return null;
        findLeftestLeastValueNode(node.left);
        findLeftestLeastValueNode(node.right);
        return  node;
    }

    private static void deleteWhenNodeHasOneChild(TreeNode parent, TreeNode current) {
        if(current.val < parent.val) {
            if(current.left != null)
                parent.left = current.left;
            else if(current.right != null)
                parent.left = current.right;
        }
        else  if(current.val > parent.val) {
            if(current.left != null)
                parent.right = current.left;
            else if(current.right != null)
                parent.right = current.right;
        }
    }

    private static void deleteLeaf(TreeNode parent, TreeNode current) {
        if(current.val < parent.val)
            parent.left = null;
        else
            parent.right = null;
    }
}
