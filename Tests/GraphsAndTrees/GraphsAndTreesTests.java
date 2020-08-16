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

    @Test
    public void InOrderSuccessor() {
        TreeNode root = null, temp = null;
        root = TreeNode.insert(root, 20);
        root = TreeNode.insert(root, 8);
        root = TreeNode.insert(root, 22);
        root = TreeNode.insert(root, 4);
        root = TreeNode.insert(root, 12);
        root = TreeNode.insert(root, 10);
        root = TreeNode.insert(root, 14);
        temp = root.left.right.left;

        var successor = Algorithms.Graphs.InOrderSuccessor.getInOrderSuccessor(temp);
        Assert.assertEquals(successor.val, 12);
    }

    @Test
    public void BuildOrder() {
        BuildOrder buildOrder = new BuildOrder();
        // a is dependent on d (d needs to be built before a) d has two children a and b.
        var graph = buildOrder.buildGraph(new String[]{"a", "b", "c", "d", "e", "f"}, new String[][]{{"d", "a"}, {"b", "f"}, {"d", "b"}, {"a", "f"}, {"c", "d"}});
        var order1 = buildOrder.orderProjects(graph.getNodes());
        //var order = buildOrder.rundfs(graph.getNodes());

        System.out.println();
    }

    @Test
    public void firstCommonAncestor() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(8);
        node.right.right = new TreeNode(5);
        node.right.right.left = new TreeNode(9);
        node.right.right.right = new TreeNode(10);

        var ancestor = Algorithms.Graphs.FirstCommonAncestor.findFirstCommonAncestor(node, 9, 10);
        Assert.assertEquals(ancestor, node.right.right);
    }

    @Test
    public void firstCommonAncestorRecursive() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(8);
        node.right.right = new TreeNode(5);
        node.right.right.left = new TreeNode(9);
        node.right.right.right = new TreeNode(10);

        var ancestor = Algorithms.Graphs.FirstCommonAncestor.lowestCommonAncestor(node, node.left.left.left, node.left.left.right);
        Assert.assertEquals(ancestor, node.left.left);
    }

    @Test
    public void BSTSequences() {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(4);

        var result = Algorithms.Graphs.BSTSequences.allSequences2(node);
        System.out.println();
        //Assert.assertEquals(ancestor, node.right.right);
    }

    @Test
    public void checkSubtree() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(8);
        node.right.right = new TreeNode(5);
        node.right.right.left = new TreeNode(9);
        node.right.right.right = new TreeNode(10);

        TreeNode nodeTwo = new TreeNode(5);
       nodeTwo.left = new TreeNode(9);
        nodeTwo.right = new TreeNode(10);

        var result = Algorithms.Graphs.CheckSubtree.containsTree(node,nodeTwo);
        System.out.println();
        //Assert.assertEquals(ancestor, node.right.right);
    }


    @Test
    public void getRandomTreenode() {

                RandomTreeNode node = new RandomTreeNode(1);
        node.insert(3);
        node.insert(5);
        node.insert(7);
        var randomNode = node.getRandom();

        System.out.println();
        //Assert.assertEquals(ancestor, node.right.right);
    }


    @Test
    public void checkPathsWithSum() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(8);
        node.right.right = new TreeNode(5);
        node.right.right.left = new TreeNode(9);
        node.right.right.right = new TreeNode(10);


        var result = Algorithms.Graphs.PathsWithSum.getPathsFromNode(node,7);

        //Assert.assertEquals(ancestor, node.right.right);
    }
}
