package Algorithms.Graphs.ShortestPath;

public class Edge {
    int weight;
    GraphNode adjacentVertex;
    String name;
    public Edge(int distance, GraphNode adjacentVertex,String name){
        this.weight = distance;
        this.adjacentVertex = adjacentVertex;
        this.name = name;
    }
}
