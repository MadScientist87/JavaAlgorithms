package GraphsAndTrees;

import Algorithms.Graphs.*;
import org.junit.Assert;
import org.junit.Test;

public class GraphsAndTreesTests {
    @Test
    public void MinHeap() {
        MinHeap heap = new MinHeap(15);
        heap.insert(3);
        heap.insert(4);
        heap.insert(2);
        heap.minHeap();
        int popped = heap.remove();

        Assert.assertEquals(2, popped);
    }

    @Test
    public void RoutesBetweenNodes() {
        Graph graph = new Graph();
        graph.nodes = new GraphNode[3];
        graph.nodes[0] = new GraphNode(1);
        graph.nodes[1] = new GraphNode(2);
        graph.nodes[2] = new GraphNode(3);
        graph.nodes[0].addChild(graph.nodes[1]);
        graph.nodes[1].addChild(graph.nodes[2]);

        var route = new RoutesBetweenNodes();
        var anwser = route.isRouteBetweenNodes(graph, graph.nodes[0], graph.nodes[2]);
        System.out.println();

    }

    @Test
    public void MinimalTree() {
        int[] array = new int[]{1, 2, 3, 4};
        MinimalTree minTree = new MinimalTree();
        var tree = minTree.CreateMinimalTree(array, 0, array.length - 1);
        System.out.println();
    }


    @Test
    public void ListOfDepths() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        ListsOfDepths depth = new ListsOfDepths();
        depth.findDepths(node, 0);
        var list = depth.nodeListAtDepth;

        System.out.println();
    }

    @Test
    public void checkBalanced() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(7);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(8);
        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(5);
        CheckBalancedTree checkBalancedTree = new CheckBalancedTree();
        var answer = checkBalancedTree.checkBalanced(node);

        System.out.println();
    }

    @Test
    public void isValidBST() {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);


        ValidateBST validateBST = new ValidateBST();
        //var answer = validateBST.isValidBST(node);
       validateBST.isValidBSTRecursive(node);
        var answer = validateBST.isValid;

                System.out.println();
    }

}
