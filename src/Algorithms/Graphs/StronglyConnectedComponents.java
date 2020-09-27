package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StronglyConnectedComponents {

    public ArrayList<Integer>[] graph;
    int[] lowLink;
    int[] nodeIndex;
    int times;
    boolean[] visited;
    List<List<Integer>> criticalConnection;


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        for(int i = 0;i < n;i++){
            graph[i] = new ArrayList<Integer>();
        }
        buildGraph(connections);
        lowLink = new int[n];
        nodeIndex = new int[n];
        times = 0;
        visited = new boolean[n];
        criticalConnection = new ArrayList<List<Integer>>();
        dfs(0,-1);
        return criticalConnection;
    }

    public void buildGraph(List<List<Integer>> connections){
        for(List<Integer> connection:connections){
            if(graph[connection.get(0)] == null){
                graph[connection.get(0)] = new ArrayList();
            }
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }
    }

    public void dfs(int currentNode, int parentNode){
        lowLink[currentNode] = nodeIndex[currentNode] = times++;
        visited[currentNode] = true;

        for(int neighbor: graph[currentNode]){
            if(neighbor == parentNode){
                continue;
            }
            else if(!visited[neighbor]){
                dfs(neighbor,currentNode);
                lowLink[currentNode] = Math.min(lowLink[currentNode],lowLink[neighbor]);
                if(nodeIndex[currentNode] < lowLink[neighbor]){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(currentNode);
                    list.add(neighbor);
                    criticalConnection.add(list);
                }
            }
            else{
                lowLink[currentNode] = Math.min(lowLink[currentNode],lowLink[neighbor]);
            }

        }
    }

}
