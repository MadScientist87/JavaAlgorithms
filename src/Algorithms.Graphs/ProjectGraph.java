package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class ProjectGraph {
    ArrayList<ProjectNode> nodes = new ArrayList<>();
    HashMap<String, ProjectNode> map = new HashMap<>();

    public ProjectNode getOrCreateProject(String projectName)
    {
        ProjectNode project;

        if(map.containsKey(projectName))
            project = map.get(projectName);
        else
        {
            project = new ProjectNode(projectName);
            nodes.add(project);
            map.put(projectName,project);
        }

        return project;
    }

    public void addEdge(String start, String end)
    {
        var startNode = getOrCreateProject(start);
        var endNode = getOrCreateProject(end);
        startNode.addNeighbor(endNode);
    }

    public ArrayList<ProjectNode> getNodes()
    {
        return nodes;
    }
}


