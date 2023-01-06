package Algorithms.Graphs.ShortestPath;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

    public HashMap<GraphNode, GraphNode> computeShortestPath(GraphNode startNode, List<GraphNode> nodes) {
        PriorityQueue<GraphNode> minHeap = new PriorityQueue<>(new GraphComparator());

        HashMap<GraphNode, Integer> distance = new HashMap<>();
        HashMap<GraphNode, GraphNode> path = new HashMap<>();

        for (GraphNode node : nodes) {
            if (node == startNode)
                minHeap.add(startNode);
            else {
                node.runningDistanceFromSource = Integer.MAX_VALUE;
                minHeap.add(node);
            }

        }

        distance.put(startNode, 0);
        path.put(startNode, null);

        while (!minHeap.isEmpty()) {
            GraphNode current = minHeap.poll();

            for (Edge edge : current.edges) {
                GraphNode adjacent = edge.adjacentVertex;

                // cycle detection
                if (!minHeap.contains(adjacent))
                    continue;

                int newDistance = current.runningDistanceFromSource + edge.weight;
                if (newDistance < adjacent.runningDistanceFromSource) {
                    // Need to remove from priority queue and re-add to priority queue to ensure that
                    // the comparator can sort properly on the next go around
                    minHeap.remove(adjacent);
                    adjacent.runningDistanceFromSource = newDistance;
                    distance.put(adjacent, newDistance);
                    path.put(adjacent, current);
                    minHeap.add(adjacent);
                }
            }
        }

        return path;
    }


}

class GraphComparator implements Comparator<GraphNode> {
    public int compare(GraphNode s1, GraphNode s2) {
        if (s1.runningDistanceFromSource < s2.runningDistanceFromSource)
            return -1;
        else if (s1.runningDistanceFromSource > s2.runningDistanceFromSource)
            return 1;
        return 0;
    }
}