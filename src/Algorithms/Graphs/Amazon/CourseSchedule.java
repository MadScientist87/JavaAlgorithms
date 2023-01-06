package Algorithms.Graphs.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public  class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];

        for(int[] prerequisite: prerequisites) {
            ArrayList<Integer> listOfCourseNeededToTake = map.getOrDefault(prerequisite[0], new ArrayList<>());
            listOfCourseNeededToTake.add(prerequisite[1]);
            map.put(prerequisite[0], listOfCourseNeededToTake);
        }

        for (int i = 0; i < numCourses; i++) {
            if(isCyclic(map, visited, checked,i))
                return false;
        }

        return true;
    }

    public static boolean isCyclic( HashMap<Integer,ArrayList<Integer>> map, boolean[] visited, boolean[] checked ,int currentCourse) {
        boolean ret = false;
        if(checked[currentCourse])
            return false;

        if(visited[currentCourse])
            return true;

        visited[currentCourse] = true;

        for (Integer prerequisite : map.getOrDefault(currentCourse, new ArrayList<>())) {
            if(isCyclic(map, visited, checked, prerequisite)) {
                ret = true;
                break;
            }
        }

        checked[currentCourse] = true;

        visited[currentCourse] = false;

        return ret;
    }
}
