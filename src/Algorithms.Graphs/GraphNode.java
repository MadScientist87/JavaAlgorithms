package Algorithms.Graphs;

import java.util.ArrayList;

public class GraphNode {
    public int value;
    public ArrayList<GraphNode> children = new ArrayList<>();
    public boolean visited = false;

    public GraphNode(int value) {
        this.value = value;
    }

    public void addChild(GraphNode node)
    {
        if(children == null)
            children = new ArrayList<>();
        children.add(node);
    }

    public ArrayList<GraphNode> getAdjacent()
    {
        return children;
    }
}
