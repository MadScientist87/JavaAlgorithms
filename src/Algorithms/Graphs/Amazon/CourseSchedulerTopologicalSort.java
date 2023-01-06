package Algorithms.Graphs.Amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Gnode implements Comparable<Gnode> {
    int degrees = 0;
    Integer value = null;

    public Gnode (int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Gnode node) {
        return Integer.compare(degrees,node.degrees);
    }
}


public class CourseSchedulerTopologicalSort {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Gnode> nodeMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> listPreqs = new HashMap<>();
        PriorityQueue<Gnode> queue = new PriorityQueue<>();
        buildMap(numCourses,prerequisites,nodeMap,listPreqs);
        fillQueue(queue, nodeMap);
        while(!queue.isEmpty()) {
            Gnode node = queue.poll();

            if(node.degrees > 0)
                return false;

            removeCourseFromSort(node.value, nodeMap,listPreqs);
        }

        return  true;
    }

    public static void removeCourseFromSort(int course , HashMap<Integer, Gnode> nodeMap,  HashMap<Integer, ArrayList<Integer>> listPreqs) {
        ArrayList<Integer> itemsToDecrement = listPreqs.getOrDefault(course, new ArrayList<>());

        for(int itemToDecrement: itemsToDecrement) {
            Gnode node = nodeMap.get(itemToDecrement);
            node.degrees -= 1;
        }
    }

    public static void fillQueue(PriorityQueue<Gnode> queue, HashMap<Integer, Gnode> nodeMap) {
        for(Gnode node: nodeMap.values()) {
            queue.add(node);
        }
    }

    public static void buildMap (int numCourses, int[][] prerequisites,  HashMap<Integer, Gnode> nodeMap, HashMap<Integer, ArrayList<Integer>> listPreqs) {
        for(int i = 0; i < prerequisites.length; i++) {
            ArrayList<Integer> list = listPreqs.getOrDefault(i,new ArrayList<>());
            list.add(prerequisites[i][1]);
            listPreqs.put(prerequisites[i][0], list);
            Gnode prereq = nodeMap.getOrDefault(prerequisites[i][1], new Gnode(prerequisites[i][1]));
            prereq.degrees++;
            nodeMap.put(prerequisites[i][1], prereq);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!nodeMap.containsKey(i)){
                nodeMap.put(i, new Gnode(i));
            }
        }
    }
}
