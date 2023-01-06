package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.HashMap;

;
public class RightPointersInEachNode {
    static HashMap<Node,Node> map = new HashMap();
    static ArrayList<Integer> list = new ArrayList();
    public static Node connect(Node root) {
        mapParent(root,null);
        Node answer = helper(root);
        return answer;
    }

    public static Node helper(Node root){
        if(root == null)
            return null;

        connect(root.left);
        connect(root.right);
        Node right = map.get(root);
        root.right = right;


        return root;
    }

    public static void mapParent(Node root, Node parent){
        if(root == null)
            return;
        Node next;
        if(parent == null){
            next = null;
        }
        else{
            next = parent.right;
        }
        map.put(root,next);
        mapParent(root.left,root);
        mapParent(root.right,root);
    }
}
