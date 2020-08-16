package Algorithms.Graphs;

public class PathsWithSum {
    public static int getPathFromRootNode(TreeNode root, int targetSum, int sum) {
        int totalPaths = 0;
        if (root == null)
            return 0;

        sum += root.val;

        if (sum == targetSum) {
            totalPaths++;
        }

        totalPaths += getPathFromRootNode(root.left, targetSum, sum);

        totalPaths += getPathFromRootNode(root.right, targetSum, sum);

        return totalPaths;
    }

    public static int getPathsFromNode(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        var pathCountFromRoot = getPathFromRootNode(root, targetSum, 0);

        int leftCount = getPathsFromNode(root.left, targetSum);

        int rightCount = getPathsFromNode(root.right, targetSum);

        return pathCountFromRoot + leftCount + rightCount;
    }
}
