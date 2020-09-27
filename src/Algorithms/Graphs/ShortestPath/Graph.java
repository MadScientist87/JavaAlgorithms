package Algorithms.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public List<GraphNode> nodes;

    public void addEdge(String  startKey, String endKey, int distance){
        GraphNode start = findNodeByKey(startKey);
        GraphNode end = findNodeByKey(endKey);
        if(start == null){
            start = new GraphNode(startKey);
            nodes.add(start);
        }

        if(end == null){

            end = new GraphNode(endKey);
            nodes.add(end);
        }
        start.edges.add(new Edge(distance,end,start.key + end.key));
        end.edges.add(new Edge(distance,start, end.key + start.key));


    }

    public GraphNode findNodeByKey(String key){
        if(nodes == null)
            nodes = new ArrayList<>();
        for(GraphNode node: nodes){
            if(node.key == key)
                return node;
        }
        return null;
    }
}
