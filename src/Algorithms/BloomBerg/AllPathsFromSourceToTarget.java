package Algorithms.BloomBerg;

import java.util.*;

public class AllPathsFromSourceToTarget {
    boolean[] visited;
    Stack<Integer> buffer;
    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        HashMap<Integer, int[]> map = new HashMap<>();
        visited = new boolean[graph.length];
        buffer = new Stack<>();
        result = new ArrayList<List<Integer>>();
        for(int i = 0; i < graph.length; i++) {
            map.put(i, graph[i]);
        }
        buffer.add(0);
        dfs(0, map, graph.length -1);

        return result;
    }

    public void dfs(int current, HashMap<Integer, int[]> map, int target) {
        if(visited[current])
            return;

        if(current == target) {
            // Add items in buffer to masterList
            ArrayList<Integer> resultList = new ArrayList<>();
            Iterator<Integer> iter = buffer.iterator();

            while(iter.hasNext()) {
                resultList.add(iter.next());
            }
            result.add(resultList);

            return;
        }

        visited[current] = true;

        for(int neighbor: map.get(current)) {
            buffer.add(neighbor);
            dfs(neighbor, map, target);
            buffer.pop();
        }
    }
}
