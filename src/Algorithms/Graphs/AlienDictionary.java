package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AlienDictionary {
    HashSet<Character> letters = new HashSet<Character>();
    HashMap<Character, GraphNode> map = new HashMap<Character, GraphNode>();
    ArrayList<Character[]> adjacenyList = new ArrayList();
    Graph graph;
    List<Character> answer = new ArrayList<>();

    public String alienOrder(String[] words) {
        buildAdjacenyList(words);
        fillGraph();
        if(!rundfs())
            return "";

        StringBuilder result = new StringBuilder(answer.size());
        for (Character c : answer) {
            result.append(c);
        }
        return result.reverse().toString();
    }

    public boolean rundfs(){
        for(GraphNode node:graph.nodes){
            if(!dfs(node))
                return false;
        }
        return true;
    }

    public boolean dfs(GraphNode node){
        if(node.status == Status.Partial)
            return false;

        if(node.status == Status.None){
            node.status = Status.Partial;
            for (GraphNode child:node.children
                 ) {
                if(!dfs(child))
                    return false;
            }
            node.status = Status.Complete;
            answer.add(node.val);
        }
        return true;
    }

    public void fillGraph() {
        graph = new Graph();
        for (char letter : letters) {
            GraphNode node = new GraphNode(letter);
            graph.nodes.add(node);
            map.put(letter, node);
        }

        for (Character[] array : adjacenyList) {
            GraphNode node = map.get(array[0]);
            if (!node.children.contains(map.get(array[1])))
                node.children.add(map.get(array[1]));
        }
    }


    public void buildAdjacenyList(String[] words) {

        for (int i = 1; i < words.length; i++) {
            char[] arrayOne = words[i - 1].toCharArray();
            char[] arrayTwo = words[i].toCharArray();
            for(Character c :arrayOne){
                letters.add(c);
            }

            for(Character c :arrayTwo){
                letters.add(c);
            }

            for (int y = 0; y < Math.min(arrayOne.length, arrayTwo.length); y++) {

                if (arrayOne[y] == arrayTwo[y])
                    continue;
                if (arrayOne[y] != arrayTwo[y]) {
                    adjacenyList.add(new Character[]{arrayOne[y], arrayTwo[y]});
                }
                break;
            }

        }
    }

    enum Status {None, Partial, Complete}

    class Graph {
        List<GraphNode> nodes;

        public Graph() {
            nodes = new ArrayList();
        }
    }

    class GraphNode {
        public List<GraphNode> children;
        public Status status = Status.None;
        char val;

        public GraphNode(char value) {
            val = value;
            if (children == null)
                children = new ArrayList<>();
        }
    }
}
