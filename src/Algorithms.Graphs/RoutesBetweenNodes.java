package Algorithms.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RoutesBetweenNodes {
    public boolean isRouteBetweenNodes(Graph graph, GraphNode start, GraphNode end) {
        if (start == end)
            return true;

        Queue<GraphNode> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            var node = queue.remove();

            node.visited = true;

            if (node.children != null)
                for (GraphNode childNode :
                        node.children) {
                    if (!childNode.visited) {
                        childNode.visited = true;
                        if (childNode == end)
                            return true;
                        else
                            queue.add(childNode);
                    }
                }
        }

        return false;
    }
}
