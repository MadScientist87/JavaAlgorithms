package Algorithms.Graphs.ShortestPath;

import java.util.*;

public class MinimumSpanningTree {
    public ArrayList<String> computeMinimumSpanningTree(GraphNode startNode, List<GraphNode> nodes) {
        PriorityQueue<GraphNode> minHeap = new PriorityQueue<>(new GraphComparator());

        HashMap<GraphNode, Edge> nodeEdgeMap = new HashMap<>();
        ArrayList<String> results = new ArrayList<>();

        for (GraphNode node : nodes) {
            if (node == startNode)
                minHeap.add(startNode);
            else {
                node.runningDistanceFromSource = Integer.MAX_VALUE;
                minHeap.add(node);
            }

        }

        while (!minHeap.isEmpty()) {
            GraphNode current = minHeap.poll();
            // We should have calculated all the edges for this node already so we can
            // get the edge name e.g a->b and add that to the results.
            if (nodeEdgeMap.containsKey(current))
                results.add(nodeEdgeMap.get(current).name);

            for (Edge edge : current.edges) {
                GraphNode adjacent = edge.adjacentVertex;

                // cycle detection
                if (!minHeap.contains(adjacent))
                    continue;

                int newDistance = edge.weight;
                if (newDistance < adjacent.runningDistanceFromSource) {
                    // Need to remove from priority queue and re-add to priority queue to ensure that
                    // the comparator can sort properly on the next go around
                    minHeap.remove(adjacent);
                    adjacent.runningDistanceFromSource = newDistance;
                    nodeEdgeMap.put(adjacent, edge);
                    minHeap.add(adjacent);
                }
            }
        }

        return results;
    }


}


