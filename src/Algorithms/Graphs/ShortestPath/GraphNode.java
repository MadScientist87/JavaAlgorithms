package Algorithms.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public String key;
    List<Edge> edges = new ArrayList<>();
    int runningDistanceFromSource;

    public GraphNode(String key){
        this.key = key;
    }

}
