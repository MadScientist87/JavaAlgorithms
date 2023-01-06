package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CourseScheduler {
    enum Status {None, Partial, Complete}
     public static Stack<Integer> stack = new Stack<>();
    static Graph graph = new Graph();
    static List<Integer> answerList = new ArrayList<Integer>();
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        loadList(numCourses,prerequisites);
        return rundfs(graph.nodes);


    }

    public static int[] rundfs(ArrayList<GraphNode> projects ) {
        for (GraphNode project : projects
        ) {
            if (project.status == Status.None)
                if (!dfs(project))
                    return new int [0];
        }
        int[] answer = new int[projects.size()];
        List<Integer> stackToList = new ArrayList(stack);
        //Collections.reverse(stackToList);

        int[] array = stackToList.stream().mapToInt(i->i).toArray();
        return array;


    }

    public static boolean dfs(GraphNode graphNode){
        if(graphNode.status == Status.Partial)
            return false;

        if(graphNode.status == Status.None){
            graphNode.status = Status.Partial;

            for(GraphNode node:graphNode.children){
                if(!dfs(node))
                    return false;
            }
            graphNode.status = Status.Complete;
            stack.add(graphNode.val);
        }
        return true;
    }

    public static void loadList(int numCourses, int[][] prerequisites){
        for(int i = 0; i < numCourses; i++){
            var nodet =new GraphNode();
            nodet.val = i;
            graph.nodes.add(nodet);

        }

        for(int i = 0; i < prerequisites.length; i++){
            int[] prereq = prerequisites[i];
            GraphNode node =  graph.nodes.get(prereq[0]);
            GraphNode newNode = graph.nodes.get(prereq[1]);
            node.children.add(newNode);

        }
    }


     static class Graph{

        public ArrayList<GraphNode> nodes;

        Graph(){
            nodes = new ArrayList();
        }

    }

     static class GraphNode{

        public ArrayList<GraphNode> children;
        public Status status = Status.None;
        public int val;

        GraphNode(){
            children = new ArrayList();
        }
    }
}
