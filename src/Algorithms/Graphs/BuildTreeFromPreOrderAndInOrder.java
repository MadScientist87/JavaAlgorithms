package Algorithms.Graphs;
import java.util.HashMap;
public class BuildTreeFromPreOrderAndInOrder {
    // start from first preorder element
    static int preOrderIndex = 0;
    static int[] preOrder;
    static int[] inOrder;
    static HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;

        int idx = 0;

        for(int val: inorder){
            idx_map.put(val,idx++);
        }

        return helper(0, inorder.length);
    }

    public TreeNode helper(int inOrderLeft, int inOrderRight){
        if(inOrderLeft == inOrderRight)
            return null;

        int rootValue = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);
        int inorderIdx = idx_map.get(rootValue);

        root.left = helper(inOrderLeft, inorderIdx);
        root.right = helper(inorderIdx + 1, inOrderRight);

        return root;
    }


}
